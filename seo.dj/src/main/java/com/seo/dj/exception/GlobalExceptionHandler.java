package com.seo.dj.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final HttpHeaders httpHeaders = new HttpHeaders();
	
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatus status, HttpServletRequest request) {

		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute("javax.servlet.error.exception", ex);
		}

		return new ResponseEntity<Object>(body, headers, status);
	}
	
	@ExceptionHandler(value = BindException.class)
	protected ResponseEntity<Object> handlerInternalException(BindException exception, HttpServletRequest request) {
		// TODO: make error headers and error messgae body.
		
		List<String> errorMessages = new ArrayList<String>();
		
		for(ObjectError error: exception.getAllErrors()) {
			errorMessages.add(error.getDefaultMessage());
		}
		
		return handleExceptionInternal(exception, errorMessages, httpHeaders, HttpStatus.OK, request);
	}
}
