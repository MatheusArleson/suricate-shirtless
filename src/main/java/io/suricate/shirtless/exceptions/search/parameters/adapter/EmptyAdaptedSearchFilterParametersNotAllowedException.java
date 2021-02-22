package io.suricate.shirtless.exceptions.search.parameters.adapter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import lombok.NonNull;

/**
 * Exception triggered when the passed {@link SearchFilterParameters} could not be adapted
 * <br/>OR<br/>
 * adapted result is empty AND emptiness is not allowed in a operation.
 *
 * @see AdapterException
 * @see EmptyAdaptedSearchPaginationParametersNotAllowedException
 * @see EmptyAdaptedSearchSortParametersNotAllowedException
 *
 */
public class EmptyAdaptedSearchFilterParametersNotAllowedException extends AdapterException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public EmptyAdaptedSearchFilterParametersNotAllowedException(@NonNull String message) {
		super(message);
	}

	/**
	 * Message and Cause constructor.
	 *
	 * @param message contains the message for the exception.
	 * @param cause contains the cause of the exception.
	 */
	public EmptyAdaptedSearchFilterParametersNotAllowedException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}

}
