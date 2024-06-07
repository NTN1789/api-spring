package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticationException extends AuthenticationException{

	private static final long serialVersionUID = 1L;
	
	public InvalidJwtAuthenticationException(String exception) {
		super(exception);
	}
	
}