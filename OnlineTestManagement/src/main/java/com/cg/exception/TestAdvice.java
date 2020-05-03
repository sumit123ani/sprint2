package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TestAdvice {

	@ExceptionHandler(value = { OnlineTestException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException(Exception ex)
	{
		return new ErrorInfo(ex.getMessage());
	}
	
}
