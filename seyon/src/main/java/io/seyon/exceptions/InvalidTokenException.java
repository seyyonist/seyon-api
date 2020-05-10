package io.seyon.exceptions;

public class InvalidTokenException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -681572083352612279L;

	public InvalidTokenException() {
		super();
	}

	public InvalidTokenException(String msg) {
		super(msg);
	}

	public InvalidTokenException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTokenException(Throwable cause) {
		super(cause);
	}
}
