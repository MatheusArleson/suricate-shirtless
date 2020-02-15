package io.suricate.shirtless.exceptions.search.parameters;

public class InvalidSortKeyException extends RuntimeException {

	public InvalidSortKeyException() {
		super();
	}

	public InvalidSortKeyException(String message) {
		super(message);
	}

	public InvalidSortKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidSortKeyException(Throwable cause) {
		super(cause);
	}

}
