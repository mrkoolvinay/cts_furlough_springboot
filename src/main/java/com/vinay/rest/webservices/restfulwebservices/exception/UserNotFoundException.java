package com.vinay.rest.webservices.restfulwebservices.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1628425511407114237L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
