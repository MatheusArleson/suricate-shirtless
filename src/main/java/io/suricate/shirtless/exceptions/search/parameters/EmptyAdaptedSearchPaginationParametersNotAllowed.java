package io.suricate.shirtless.exceptions.search.parameters;

public class EmptyAdaptedSearchPaginationParametersNotAllowed extends RuntimeException {

	public EmptyAdaptedSearchPaginationParametersNotAllowed() {
	}

	public EmptyAdaptedSearchPaginationParametersNotAllowed(String message) {
		super(message);
	}

	public EmptyAdaptedSearchPaginationParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyAdaptedSearchPaginationParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptyAdaptedSearchPaginationParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
