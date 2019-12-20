package io.suricate.shirtless.exceptions.search.parameters;

public class EmptySearchPaginationParametersNotAllowed extends RuntimeException {

	public EmptySearchPaginationParametersNotAllowed() {
	}

	public EmptySearchPaginationParametersNotAllowed(String message) {
		super(message);
	}

	public EmptySearchPaginationParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptySearchPaginationParametersNotAllowed(Throwable cause) {
		super(cause);
	}

	public EmptySearchPaginationParametersNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
