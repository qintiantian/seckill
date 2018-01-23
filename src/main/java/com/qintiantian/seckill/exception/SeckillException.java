package com.qintiantian.seckill.exception;

import lombok.Getter;

@Getter
public class SeckillException extends RuntimeException {

	private static final long serialVersionUID = -5985005189820645774L;

	private final SeckillErrorDefinition errorDefinition;

	public SeckillException(String mesage) {
        super(mesage);
        this.errorDefinition = null;
    }

	public SeckillException(Throwable cause) {
        super(cause);
        this.errorDefinition = null;
    }

	public SeckillException(String mesage, Throwable cause) {
        super(mesage, cause);
        this.errorDefinition = null;
    }

	public SeckillException(SeckillErrorDefinition errorDefinition, String mesage) {
        super(mesage);
        this.errorDefinition = errorDefinition;
    }

	public SeckillException(SeckillErrorDefinition errorDefinition, String message, Throwable cause) {
        super(message, cause);
        this.errorDefinition = errorDefinition;
    }
}
