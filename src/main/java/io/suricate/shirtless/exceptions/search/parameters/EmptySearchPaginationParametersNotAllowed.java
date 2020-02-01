package io.suricate.shirtless.exceptions.search.parameters;

public class EmptySearchPaginationParametersNotAllowed extends EmptyParameterNotAllowedException {

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

}
