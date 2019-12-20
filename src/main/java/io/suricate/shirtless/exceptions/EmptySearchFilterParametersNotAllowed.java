package io.suricate.shirtless.exceptions;

public class EmptySearchFilterParametersNotAllowed extends RuntimeException {

	public EmptySearchFilterParametersNotAllowed() {
	}

	public EmptySearchFilterParametersNotAllowed(String message) {
		super(message);
	}

	public EmptySearchFilterParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptySearchFilterParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptySearchFilterParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
