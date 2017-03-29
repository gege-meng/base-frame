package com.ddu.entity;

import com.ddu.base.BaseEntity;

/**
 * 大题
 * @author lvm
 *
 */
public class BigSubject extends BaseEntity{

	private static final long serialVersionUID = 8463848222716587167L;
	
	//大题号
	private int number;
	//简称
	private String simpleName;
	//名称
	private String name;
	//作答状态: 0未答，1正在作答, 2已答
	private int state;
	//父节点
	private int parentId;
	//说明
	private String remarks;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "BigSubject [number=" + number + ", simpleName=" + simpleName
				+ ", name=" + name + ", state=" + state + ", parentId="
				+ parentId + ", remarks=" + remarks + "]";
	}

}
