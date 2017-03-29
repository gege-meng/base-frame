package com.ddu.enums;

public enum SubjectStateEnum {

	Inited("未开始", 0), Answering("正在作答", 1), Answered("已作答", 2);
	
	private SubjectStateEnum(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	private String name;
	
	private int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

}
