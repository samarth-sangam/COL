package com.comviva.col.exceptions;

/**
 * Custom Exception to handle Duplicate database rows.
 * 
 * @author samarth.sangam
 *
 */
public class DuplicateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateException(Exception ex) {
		super(ex);
	}

	public DuplicateException(Throwable t) {
		super(t);
	}

	public DuplicateException(String message) {
		super(message);
	}
}
