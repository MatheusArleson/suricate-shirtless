package io.suricate.shirtless.exceptions.search.parameters.adapter;

public class EmptyAdaptedSearchFilterParametersNotAllowed extends AdpterException {

	public EmptyAdaptedSearchFilterParametersNotAllowed() {
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(String message) {
		super(message);
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyAdaptedSearchFilterParametersNotAllowed(Throwable cause) {
		super(cause);
	}

}
