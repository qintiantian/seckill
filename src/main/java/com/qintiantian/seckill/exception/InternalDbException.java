package com.qintiantian.seckill.exception;

public class InternalDbException extends SeckillException {

	private static final long serialVersionUID = 1L;

	public InternalDbException(SeckillErrorDefinition errorDefinition, String mesage) {
		super(errorDefinition, mesage);
	}
}
