package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

/**
 *
 *
 *
 * @param <F> The class of the Filter part of the Search Parameter.
 *
 * @see SearchParameters
 * @see SearchFilterParameters
 * @see SearchPaginationParameters
 * @see SearchSortParameters
 */
public class AbstractDefaultSearchParameters<F extends SearchFilterParameters>
		extends AbstractSearchParameters<
			F,
			DefaultSearchPaginationParameters,
			DefaultSearchSortParameters
		> {

	public AbstractDefaultSearchParameters() {
		super();
	}

	public AbstractDefaultSearchParameters(
		F filterParameters,
		DefaultSearchPaginationParameters paginationParameters,
		DefaultSearchSortParameters sortParameters
	) {
		super(filterParameters, paginationParameters, sortParameters);
	}
}
