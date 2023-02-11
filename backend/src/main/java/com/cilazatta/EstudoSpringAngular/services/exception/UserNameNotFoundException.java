package com.cilazatta.EstudoSpringAngular.services.exception;

public class UserNameNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserNameNotFoundException(String msg) {
		super(msg);
	}
	
}
