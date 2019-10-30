package com.comviva.col.exceptions;

/**
 * Custom Exception for no database row.
 * 
 * @author samarth.sangam
 *
 */
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1447701704775792332L;

	public NotFoundException(Exception ex) {
		super(ex);
	}

	public NotFoundException(Throwable t) {
		super(t);
	}

	public NotFoundException(String message) {
		super(message);
	}

}
