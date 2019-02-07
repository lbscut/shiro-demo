package com.lb.shiro.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AuthorizationException.class)
	public ResponseEntity<String> authroizationExceptionHandler() {
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}


	@ExceptionHandler(value = IncorrectCredentialsException.class)
	public ResponseEntity<String> incorrectCredentialsExceptionHandler() {
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		
	}
		
}
