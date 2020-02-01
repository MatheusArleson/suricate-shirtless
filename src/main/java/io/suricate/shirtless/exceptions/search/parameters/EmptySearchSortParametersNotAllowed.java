package io.suricate.shirtless.exceptions.search.parameters;

public class EmptySearchSortParametersNotAllowed extends EmptyParameterNotAllowedException {

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

}
