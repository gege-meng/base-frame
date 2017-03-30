package com.ddu.util;

public enum ConsEnum {

	Successed(100, "成功"), Failed(200, "失败"), OutTimed(300, "登录超时"), Service_Exception(
			500, "服务异常"), Param_Error(600, "参数错误");
	
	private ConsEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private String msg;
	
	private int code;

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

}
