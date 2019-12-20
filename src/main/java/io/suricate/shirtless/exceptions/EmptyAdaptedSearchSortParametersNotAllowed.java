package io.suricate.shirtless.exceptions;

public class EmptyAdaptedSearchSortParametersNotAllowed extends RuntimeException {

	public EmptyAdaptedSearchSortParametersNotAllowed() {
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(String message) {
		super(message);
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
