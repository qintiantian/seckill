package com.qintiantian.seckill.exception;

public class ResourceNotFoundException extends SeckillException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(SeckillErrorDefinition errorDefinition, String mesage) {
		super(errorDefinition, mesage);
	}
}
