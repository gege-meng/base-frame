package com.ddu.entity;

import com.ddu.base.BaseEntity;

/**
 * 用户信息
 * @author lvm
 *
 */
public class User extends BaseEntity{

	private static final long serialVersionUID = 7558481343920369617L;

	//编码
	private String number;
	
	//名称
	private String name;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [number=" + number + ", name=" + name + "]";
	}
}
