package com.seo.dj.common.type;

public enum ResponseType {
	INTERNAL_EXCEPTION(-1001, "Internal Server Error.");
	
	public Integer code;
	public String message;
	
	ResponseType(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
