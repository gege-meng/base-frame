package com.ddu.entity;

import com.ddu.base.BaseEntity;

/**
 * 答题结果表
 * @author lvm
 *
 */
public class Answer extends BaseEntity{

	private static final long serialVersionUID = -741779339650676144L;

	//小题号ID
	private Long smallSubjectId;
	//用户ID
	private Long userId;
	//结果
	private String result;
	//状态: 0错误，1正确
	private int state;
	//花费时间, s
	private Long spentTime;

	public Long getSmallSubjectId() {
		return smallSubjectId;
	}

	public void setSmallSubjectId(Long smallSubjectId) {
		this.smallSubjectId = smallSubjectId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(Long spentTime) {
		this.spentTime = spentTime;
	}

	@Override
	public String toString() {
		return "Answer [smallSubjectId=" + smallSubjectId + ", userId="
				+ userId + ", result=" + result + ", state=" + state
				+ ", spentTime=" + spentTime + "]";
	}
	
	/*小题对象*/
	private SmallSubject smallSubject;
	/* 用户对象 */
	private User user;

	public SmallSubject getSmallSubject() {
		return smallSubject;
	}

	public User getUser() {
		return user;
	}
}
