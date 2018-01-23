package com.qintiantian.seckill.exception;

import lombok.Getter;

@Getter
public enum SeckillErrorDefinition {
	USER_NOT_EXISTS("SECKILL_0001", "user not exists");
	
	private SeckillErrorDefinition(String errorCode, String  errorDescription){
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	private String errorCode;
	
	private String errorDescription;
}
