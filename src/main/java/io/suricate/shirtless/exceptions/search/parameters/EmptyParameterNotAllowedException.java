package io.suricate.shirtless.exceptions.search.parameters;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.service.SupervisedSearchService;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;
import lombok.NonNull;

/**
 * Root Exception triggered when either the passed {@link SearchParameters} parameter or associated fallbacks contain empty
 * sections AND emptiness is not allowed in a operation.
 *
 * @see SearchParameters
 * @see SupervisedSearchService
 * @see SearchParametersSupervisor
 * @see EmptySearchFilterParametersNotAllowedException
 * @see EmptySearchPaginationParametersNotAllowedException
 * @see EmptySearchSortParametersNotAllowedException
 */
public class EmptyParameterNotAllowedException extends RuntimeException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public EmptyParameterNotAllowedException(@NonNull String message) {
		super(message);
	}

	/**
	 * Message and Cause constructor.
	 *
	 * @param message contains the message for the exception.
	 * @param cause contains the cause of the exception.
	 */
	public EmptyParameterNotAllowedException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}

}
