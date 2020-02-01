package io.suricate.shirtless.exceptions.search.parameters;

public class EmptyParameterNotAllowedException extends Exception {

	public EmptyParameterNotAllowedException() {
	}

	public EmptyParameterNotAllowedException(String message) {
		super(message);
	}

	public EmptyParameterNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyParameterNotAllowedException(Throwable cause) {
		super(cause);
	}

}
