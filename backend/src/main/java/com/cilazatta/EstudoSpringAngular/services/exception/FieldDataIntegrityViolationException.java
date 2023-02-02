package com.cilazatta.EstudoSpringAngular.services.exception;

public class FieldDataIntegrityViolationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FieldDataIntegrityViolationException(String msg) {
		super(msg);
	}
	
}
