package io.suricate.shirtless.exceptions.search.parameters.adapter;

public class EmptyAdaptedSearchSortParametersNotAllowed extends AdpterException {

	public EmptyAdaptedSearchSortParametersNotAllowed() {
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(String message) {
		super(message);
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyAdaptedSearchSortParametersNotAllowed(Throwable cause) {
		super(cause);
	}

}
