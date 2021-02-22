package io.suricate.shirtless.exceptions.search.parameters.adapter;

import io.suricate.shirtless.model.parameter.SearchParameters;
import lombok.NonNull;

/**
 * Root exception triggered when the passed {@link SearchParameters} and its sections could not be adapted.
 *
 * @see EmptyAdaptedSearchFilterParametersNotAllowedException
 * @see EmptyAdaptedSearchPaginationParametersNotAllowedException
 * @see EmptyAdaptedSearchSortParametersNotAllowedException
 *
 */
public class AdapterException extends RuntimeException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public AdapterException(@NonNull String message) {
		super(message);
	}

	/**
	 * Message and Cause constructor.
	 *
	 * @param message contains the message for the exception.
	 * @param cause contains the cause of the exception.
	 */
	public AdapterException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}

}
