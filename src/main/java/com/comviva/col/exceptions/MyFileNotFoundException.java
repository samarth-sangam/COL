package com.comviva.col.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author samarth.sangam
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFileNotFoundException(String message) {
		super(message);
	}

	public MyFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}