package io.suricate.shirtless.exceptions;

public class EmptySearchParametersNotAllowed extends RuntimeException {

	public EmptySearchParametersNotAllowed() {
	}

	public EmptySearchParametersNotAllowed(String message) {
		super(message);
	}

	public EmptySearchParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptySearchParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptySearchParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
