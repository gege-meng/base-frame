/** 用户表 */
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
	id_ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	number_ CHAR(10) NOT NULL UNIQUE COMMENT '编码',
	name_ VARCHAR(20) NOT NULL COMMENT '姓名',
	create_time_ TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	lastupdate_time_ TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'
) ENGINE = INNODB CHARSET=utf8 COMMENT ='用户表';

INSERT INTO t_user(number_, name_) VALUES('01247520', '张三');
INSERT INTO t_user(number_, name_) VALUES('01247521', '李四');

SELECT * FROM t_user WHERE  number_ ='01247520' AND name_ ='张三';

/** 大题表 */
DROP TABLE IF EXISTS t_big_subject;
CREATE TABLE t_big_subject(
	id_ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	number_ SMALLINT NOT NULL COMMENT '大题号',
	simple_name_ VARCHAR(20) NOT NULL COMMENT '简称',
	name_ VARCHAR(20) NOT NULL COMMENT '名称',
	state_ TINYINT NOT NULL DEFAULT 0 COMMENT '作答状态: 0未开始，1正在作答, 2已答',
	parent_id_ BIGINT COMMENT '父节点',
	remarks_ VARCHAR(1000) COMMENT '说明',
	create_time_ TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	lastupdate_time_ TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'
) ENGINE = INNODB CHARSET=utf8 COMMENT ='大题表';

INSERT INTO t_big_subject(number_, simple_name_, name_, remarks_) VALUES
(1, '第一轮', '百人团对决', '百人团与选手同时答题，（百人团20秒后答题停止，选手口述作答）。以百人团答错题的人数作为选手的得分。选手答错即中止比赛，并以之前所得分之和作为该名选手的比分。'),
(2, '第二轮', '飞花令', '第一轮比赛中得分最高的选手与百人团中脱颖而出的一名选手进行飞花令。由第一轮比赛中得分最高的选手来选择主题字，每人有10秒思考时间，10秒内未作答一方为输。获胜选手进入擂主争霸赛。'),
(3, '第三轮', '擂主争霸', '两名选手进行抢答，答对得一分，答错对方得一分，先到五分者胜，即为新擂主。');
INSERT INTO t_big_subject(number_, simple_name_, name_, parent_id_) VALUES
(11, '1', '第1组', 1),
(12, '2', '第2组', 1),
(13, '3', '第3组', 1),
(14, '4', '第4组', 1);

SELECT * FROM t_big_subject;

SELECT * FROM t_big_subject WHERE parent_id_ IS NULL;


#选题 --> 出题
UPDATE t_big_subject SET state_=1;

/** 小题表 */
DROP TABLE IF EXISTS t_small_subject;
CREATE TABLE t_small_subject(
	id_ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	big_subject_id_ BIGINT NOT NULL COMMENT '大题ID',
	number_ SMALLINT NOT NULL COMMENT '小题号',
	answer_ VARCHAR(255) NOT NULL COMMENT '正确答案',
	state_ TINYINT NOT NULL DEFAULT 0 COMMENT '状态: 0未开始，1正在作答, 2已答',
	strat_time_ TIMESTAMP COMMENT '作答开始时间',
	end_time_ TIMESTAMP COMMENT '作答结束时间',
	create_time_ TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	lastupdate_time_ TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	CONSTRAINT fk_ss_big_subject FOREIGN KEY (big_subject_id_) REFERENCES t_big_subject(id_)
) ENGINE = INNODB CHARSET=utf8 COMMENT ='小题表';

INSERT INTO t_small_subject(big_subject_id_, number_, answer_) VALUES(1, 1, 'A');
INSERT INTO t_small_subject(big_subject_id_, number_, answer_) VALUES(1, 2, 'B');
INSERT INTO t_small_subject(big_subject_id_, number_, answer_) VALUES(1, 3, 'C');
INSERT INTO t_small_subject(big_subject_id_, number_, answer_) VALUES(1, 4, 'A');
INSERT INTO t_small_subject(big_subject_id_, number_, answer_) VALUES(1, 5, 'B');
INSERT INTO t_small_subject(big_subject_id_, number_, answer_) VALUES(1, 6, 'C');

SELECT * FROM t_small_subject;


#出题  1:呈现小题，2:更新小题信息
SELECT * FROM t_small_subject WHERE big_subject_id_=1 AND state_=0 ORDER BY number_ ASC LIMIT 1;
UPDATE t_small_subject SET strat_date_= CURRENT_TIMESTAMP(), state_=1 WHERE id_ = ?;
/** 开始作答,更新表状态
update t_small_subject set strat_date_=current_timestamp(), state_=1 where id_ in(
	select id_ from (SELECT id_ FROM t_small_subject WHERE big_subject_id_=1 AND state_=0 order by number_ asc limit 1) t
);*/
#答题结束显示结果  1.显示答题结果(小题结果.答对人数，前三名) 2:更新小题信息  3: 如果为最后一题，则在更新小题之后更新大题状态
SELECT id_ FROM t_small_subject WHERE big_subject_id_=1 AND state_=1 ORDER BY number_ DESC LIMIT 1;
UPDATE t_small_subject SET end_date_=CURRENT_TIMESTAMP(), state_=2 WHERE id_ =1;
/* update t_small_subject set end_date_=current_timestamp(), state_=2 where id_ in(
	select id_ from (SELECT id_ FROM t_small_subject WHERE big_subject_id_=1 AND state_=1 ORDER BY number_ desc LIMIT 1) t
);*/
SELECT ta.* FROM t_small_subject ss, t_answer ta WHERE ss.`id_`=ta.`small_subject_id_` AND ss.id_=1 ORDER BY ta.create_time_ ASC;



SELECT * FROM t_small_subject s1, (
	SELECT id_, MIN(number_) FROM t_small_subject WHERE big_subject_id_=1 AND state_=0
)s2 WHERE s1.id_ = s2.id_;

/**  答题结果表 */
DROP TABLE IF EXISTS t_answer;
CREATE TABLE t_answer(
	id_ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	small_subject_id_ BIGINT NOT NULL COMMENT '小题号ID',
	user_id_ BIGINT NOT NULL COMMENT '用户ID',
	result_ VARCHAR(255) COMMENT '结果',
	state_ TINYINT COMMENT '状态: 0错误，1正确',
	spent_time_ BIGINT COMMENT '花费时间, s',
	create_time_ TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	lastupdate_time_ TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
	CONSTRAINT fk_an_small_subject FOREIGN KEY (small_subject_id_) REFERENCES t_user(id_),
	CONSTRAINT fk_an_user FOREIGN KEY (user_id_) REFERENCES t_small_subject(id_)
) ENGINE = INNODB CHARSET=utf8 COMMENT ='答题情况表';

INSERT INTO t_answer(small_subject_id_, user_id_, result_,state_) VALUES(1, 1, 'test', 1);
INSERT INTO t_answer(small_subject_id_, user_id_, result_,state_) VALUES(1, 1, 'B',    0);
INSERT INTO t_answer(small_subject_id_, user_id_, result_) VALUES(1, 1, 'test');

SELECT * FROM t_answer;

#select * from t_answer where state_=1 order by create_time_ asc limit 3; 
#单独插入一条数据 subjectid, userid, result, state   取数来源  SELECT id_, answer_, strat_time_ FROM t_small_subject WHERE id_ = 1;
INSERT INTO t_answer(small_subject_id_, user_id_, result_, state_, spent_time_) VALUES(1, 1, 'test', 1, TIMESTAMPDIFF(SECOND, '2017-03-29 09:15:25', CURRENT_TIMESTAMP()));











