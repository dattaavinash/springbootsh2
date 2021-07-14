package com.example.spdbconc.exceptionHandilng;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class YourException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public YourException(String message,Exception e)
	{
		super(message);
	}
    
	public YourException(String message)
	{
		super(message);
	}
}
