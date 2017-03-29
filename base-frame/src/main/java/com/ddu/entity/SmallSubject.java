package com.ddu.entity;

import java.util.Date;

import com.ddu.base.BaseEntity;

/**
 * 小题
 * @author lvm
 *
 */
public class SmallSubject extends BaseEntity{

	private static final long serialVersionUID = -6535407123363231367L;
	
	// 大题ID
	private Long bigSubjectId;
	//小题号
	private int number;
	//正确答案
	private String answer;
	//作答开始时间
	private Date startTime;
	//作答结束时间
	private Date endTime;

	public Long getBigSubjectId() {
		return bigSubjectId;
	}

	public void setBigSubjectId(Long bigSubjectId) {
		this.bigSubjectId = bigSubjectId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "SmallSubject [bigSubjectId=" + bigSubjectId + ", number="
				+ number + ", answer=" + answer + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	/*大题对象*/
	private BigSubject bigSubject;

	public BigSubject getBigSubject() {
		return bigSubject;
	}
	
}
