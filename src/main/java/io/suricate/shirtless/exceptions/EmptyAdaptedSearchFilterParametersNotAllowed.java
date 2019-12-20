package io.suricate.shirtless.exceptions;

public class EmptyAdaptedSearchFilterParametersNotAllowed extends RuntimeException {

	public EmptyAdaptedSearchFilterParametersNotAllowed() {
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(String message) {
		super(message);
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
