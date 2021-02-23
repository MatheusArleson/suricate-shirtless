package io.suricate.shirtless.exceptions.search.parameters.adapter;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.NonNull;

/**
 * Exception triggered when the passed {@link SearchSortParameters} could not be adapted
 * <br>OR<br>
 * adapted result is empty AND emptiness is not allowed in a operation.
 *
 * @see AdapterException
 * @see EmptyAdaptedSearchFilterParametersNotAllowedException
 * @see EmptyAdaptedSearchPaginationParametersNotAllowedException
 *
 */
public class EmptyAdaptedSearchSortParametersNotAllowedException extends AdapterException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public EmptyAdaptedSearchSortParametersNotAllowedException(@NonNull String message) {
		super(message);
	}

	/**
	 * Message and Cause constructor.
	 *
	 * @param message contains the message for the exception.
	 * @param cause contains the cause of the exception.
	 */
	public EmptyAdaptedSearchSortParametersNotAllowedException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}

}
