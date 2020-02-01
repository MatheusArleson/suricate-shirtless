package io.suricate.shirtless.exceptions.search.parameters;

public class EmptySearchFilterParametersNotAllowed extends EmptyParameterNotAllowedException {

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

}
