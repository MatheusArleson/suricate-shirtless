package io.suricate.shirtless.exceptions;

public class EmptySearchSortParametersNotAllowed extends RuntimeException {

	public EmptySearchSortParametersNotAllowed() {
	}

	public EmptySearchSortParametersNotAllowed(String message) {
		super(message);
	}

	public EmptySearchSortParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptySearchSortParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptySearchSortParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
