package com.deyvisson.bookstore.service.exceptions;

public class DataIntegrityViolationExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExecption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegrityViolationExecption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
