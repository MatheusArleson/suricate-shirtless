package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.NonNull;

/**
 * Abstraction for {@link SearchParametersAdapter} implementations that use the default implementations for filter, pagination and sorting.
 * <br><br>
 * Extensions of this class just need to specify target types and adapters that can perform the adaptation.
 *
 * @param <F>  Type of the Filter - Anything that extends {@link SearchFilterParameters}
 * @param <AF> Type of Adapted Filter - To be used on downstream
 * @param <FA> Type of Filter Adapter - Anything that extends {@link SearchFilterParametersAdapter}
 * @param <AP> Type of Adapted Pagination - To be used on downstream
 * @param <PA> Type of Pagination Adapter - Anything that extends {@link SearchPaginationParametersAdapter}
 * @param <AS> Type of Adapted Sort - To be used on downstream
 * @param <SA> Type of Sort Adapter - Anything that extends {@link SearchSortParametersAdapter}
 *
 * @see DefaultSearchPaginationParameters
 * @see DefaultSearchSortParameters
 * @see SearchParametersAdapter
 * @see AbstractSearchParametersAdapter
 * @see SearchFilterParametersAdapter
 * @see SearchPaginationParametersAdapter
 * @see SearchSortParametersAdapter
 */
public abstract class AbstractDefaultSearchParametersAdapter<
			F extends SearchFilterParameters,
			AF,
			FA extends SearchFilterParametersAdapter<F, AF>,
			AP,
			PA extends SearchPaginationParametersAdapter<DefaultSearchPaginationParameters, AP>,
			AS,
			SA extends SearchSortParametersAdapter<DefaultSearchSortParameters, AS>
		> extends AbstractSearchParametersAdapter<F, AF, FA, DefaultSearchPaginationParameters, AP, PA, DefaultSearchSortParameters, AS, SA> {

	/**
	 * Constructs an instance of the adapter.
	 *
	 * @param filterAdapter contains the adapter for filter parameters.
	 * @param paginationAdapter contains the adapter for pagination parameters.
	 * @param sortAdapter contains the adapter for sort parameters.
	 */
	public AbstractDefaultSearchParametersAdapter(
		@NonNull FA filterAdapter,
		@NonNull PA paginationAdapter,
		@NonNull SA sortAdapter
	) {
		super(filterAdapter, paginationAdapter, sortAdapter);
	}

}
