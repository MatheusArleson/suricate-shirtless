package io.suricate.shirtless.exceptions.search.parameters.adapter;

public class EmptyAdaptedSearchPaginationParametersNotAllowed extends AdpterException {

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

}
