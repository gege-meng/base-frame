package com.ddu.util;

import java.io.Serializable;

public class ApiResult<T> implements Serializable {
	
	private static final long serialVersionUID = -1289351482579433686L;
	
	//消息code
	private Integer code;
	//消息内容
	private String msg;
	//跳转url
	private String redirectUrl;
	//响应结果
	private T result;
	
	public ApiResult(ConsEnum cons) {
		this.code = cons.getCode();
		this.msg = cons.getMsg();
	}

	public ApiResult() {
		this(ConsEnum.Successed);
	}
	
	public ApiResult(ConsEnum cons, String msg) {
		this.code = cons.getCode();
		this.msg = msg;
	}
	
	public ApiResult(String msg) {
		this(ConsEnum.Successed, msg);
	}
	
	public ApiResult(ConsEnum cons, T result) {
		this(cons);
		this.result = result;
	}

	public ApiResult(T result) {
		this(ConsEnum.Successed, result);
	}

	public ApiResult(ConsEnum cons, String msg, T result) {
		this(cons, msg);
		this.result = result;
	}
	
	public ApiResult(String msg, T result) {
		this(ConsEnum.Successed, msg, result);
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}