package com.lockerapp.exception;
import java.lang.RuntimeException;
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException{
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(final String message) {
		super(message);
	}

}

