package io.suricate.shirtless.exceptions.search.parameters.adapter;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import lombok.NonNull;

/**
 * Exception triggered when the passed {@link SearchPaginationParameters} could not be adapted
 * <br>OR<br>
 * adapted result is empty AND emptiness is not allowed in a operation.
 *
 * @see AdapterException
 * @see EmptyAdaptedSearchFilterParametersNotAllowedException
 * @see EmptyAdaptedSearchSortParametersNotAllowedException
 *
 */
public class EmptyAdaptedSearchPaginationParametersNotAllowedException extends AdapterException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public EmptyAdaptedSearchPaginationParametersNotAllowedException(@NonNull String message) {
		super(message);
	}

	/**
	 * Message and Cause constructor.
	 *
	 * @param message contains the message for the exception.
	 * @param cause contains the cause of the exception.
	 */
	public EmptyAdaptedSearchPaginationParametersNotAllowedException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}

}
