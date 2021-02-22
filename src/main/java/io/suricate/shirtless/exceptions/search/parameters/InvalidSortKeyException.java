package io.suricate.shirtless.exceptions.search.parameters;

import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.key.SearchSortKeyAdapter;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

/**
 * Root Exception triggered when the {@link SearchSortParameters} section contains an invalid sort code.
 *
 * @see SearchSortParameters
 * @see SearchSortParametersAdapter
 * @see SearchSortKeyAdapter
 */
public class InvalidSortKeyException extends RuntimeException {

	/**
	 * Message only constructor.
	 *
	 * @param message contains the message for the exception.
	 */
	public InvalidSortKeyException(String message) {
		super(message);
	}

}
