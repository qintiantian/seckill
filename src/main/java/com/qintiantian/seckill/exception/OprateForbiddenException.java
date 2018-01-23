package com.qintiantian.seckill.exception;

public class OprateForbiddenException extends SeckillException {

	private static final long serialVersionUID = 1L;

	public OprateForbiddenException(SeckillErrorDefinition errorDefinition, String mesage) {
		super(errorDefinition, mesage);
	}
}
