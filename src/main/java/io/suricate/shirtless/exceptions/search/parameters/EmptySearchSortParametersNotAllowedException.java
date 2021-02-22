package io.suricate.shirtless.exceptions.search.parameters;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.SupervisedSearchService;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;

/**
 * Exception triggered when either the passed {@link SearchSortParameters} parameter or associated fallbacks are empty
 * AND emptiness is not allowed in a operation.
 *
 * @see SearchParameters
 * @see SupervisedSearchService
 * @see SearchParametersSupervisor
 * @see EmptyParameterNotAllowedException
 * @see EmptySearchParametersNotAllowedException
 * @see EmptySearchFilterParametersNotAllowedException
 * @see EmptySearchPaginationParametersNotAllowedException
 */
public class EmptySearchSortParametersNotAllowedException extends EmptyParameterNotAllowedException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public EmptySearchSortParametersNotAllowedException(String message) {
		super(message);
	}

}
