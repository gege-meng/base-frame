package com.ddu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ddu.base.BaseMapper;
import com.ddu.entity.BigSubject;

@Repository
public interface BigSubjectMapper extends BaseMapper<BigSubject>{
	
	/**
	 * 根据ID号更新状态
	 * @param id
	 * @param state
	 * UPDATE t_big_subject SET state_=1 WHERE id_=1;
	 */
	public void updateStateById(@Param(value = "id") Long id, @Param(value = "state") int state);
	
}
	