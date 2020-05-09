package io.seyon.exceptions;

public class InvalidCompanyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3252468343802668660L;
	
	public InvalidCompanyException() {
		super();
	}
	
	public InvalidCompanyException(String message) {
		super(message);
	}

	public InvalidCompanyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidCompanyException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCompanyException(Throwable cause) {
		super(cause);
	}

}
