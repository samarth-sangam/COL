package com.comviva.col.exceptions;

public class UnauthorizedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthorizedException(Exception ex) {
		super(ex);
	}

	public UnauthorizedException(String string) {
		super(string);
	}

}
