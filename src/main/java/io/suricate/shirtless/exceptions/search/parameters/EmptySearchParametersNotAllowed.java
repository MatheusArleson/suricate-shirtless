package io.suricate.shirtless.exceptions.search.parameters;

public class EmptySearchParametersNotAllowed extends EmptyParameterNotAllowedException {

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

}
