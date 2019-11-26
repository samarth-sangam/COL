package com.comviva.col.exceptions;

public class InternalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalException(Exception e) {
		super(e);
	}

	public InternalException(String msg) {
		super(msg);
	}

	public InternalException(Throwable t) {
		super(t);
	}

}
