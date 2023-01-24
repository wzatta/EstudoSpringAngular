package com.cilazatta.EstudoSpringAngular.services.exception;

public class FieldNotNullException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FieldNotNullException(String msg) {
		super(msg);
	}
	
}
