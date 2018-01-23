package com.qintiantian.seckill.exception;

public class IllegalArgException extends SeckillException {

	private static final long serialVersionUID = 1L;

	public IllegalArgException(SeckillErrorDefinition errorDefinition, String mesage) {
		super(errorDefinition, mesage);
	}
}
