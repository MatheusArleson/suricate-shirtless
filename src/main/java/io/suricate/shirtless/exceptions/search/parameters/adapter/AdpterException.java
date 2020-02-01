package io.suricate.shirtless.exceptions.search.parameters.adapter;

public class AdpterException extends RuntimeException {

	public AdpterException() {
	}

	public AdpterException(String message) {
		super(message);
	}

	public AdpterException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdpterException(Throwable cause) {
		super(cause);
	}

}
