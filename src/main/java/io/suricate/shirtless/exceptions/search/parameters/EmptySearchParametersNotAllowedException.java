package io.suricate.shirtless.exceptions.search.parameters;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.service.SupervisedSearchService;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;

/**
 * Exception triggered when the {@link SearchParameters} parameter or associated fallbacks is itself empty
 * AND emptiness is not allowed in a operation.
 *
 * @see SearchParameters
 * @see SupervisedSearchService
 * @see SearchParametersSupervisor
 * @see EmptyParameterNotAllowedException
 * @see EmptySearchParametersNotAllowedException
 * @see EmptySearchFilterParametersNotAllowedException
 * @see EmptySearchPaginationParametersNotAllowedException
 * @see EmptySearchSortParametersNotAllowedException
 */
public class EmptySearchParametersNotAllowedException extends EmptyParameterNotAllowedException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public EmptySearchParametersNotAllowedException(String message) {
		super(message);
	}

}
