package com.comviva.col.exceptions;

/**
 * Custom Exception for Invalid password.
 * 
 * @author samarth.sangam
 *
 */
public class InvalidPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5424203583979596814L;

	public InvalidPasswordException(Exception ex) {
		super(ex);
	}

	public InvalidPasswordException(Throwable t) {
		super(t);
	}

	public InvalidPasswordException(String message) {
		super(message);
	}
}
