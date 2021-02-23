package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

/**
 * Base interface for Search Parameters Adapters.
 * <br><br>
 * Search Parameters Adapter uses the concept of <a href="https://en.wikipedia.org/wiki/Adapter_pattern"><b>Adapter Design Pattern</b></a>.
 * <br><br>
 * In other words, this interface is responsible for transforming the {@link SearchParameters} sections into other objects
 * that can be used by the downstream layers to process it.
 * <br><br>
 * e.g. Adapting the {@link SearchFilterParameters} section to a SQL WHERE Clause. <br>
 * e.g. Adapting the {@link SearchPaginationParameters} section to a SQL LIMIT or OFFSET Clause. <br>
 * e.g. Adapting the {@link SearchSortParameters} section to a SQL ORDER BY Clause. <br>
 *
 * @param <F>  Type of the Filter - Anything that extends {@link SearchFilterParameters}
 * @param <AF> Type of Adapted Filter - To be used on downstream
 * @param <P>  Type of the Pagination - Anything that extends {@link SearchPaginationParameters}
 * @param <AP> Type of Adapted Pagination - To be used on downstream
 * @param <S>  Type of the Sort - Anything that extends {@link SearchSortParameters}
 * @param <AS> Type of Adapted Sort - To be used on downstream
 *
 * @see AbstractSearchParametersAdapter
 * @see AbstractDefaultSearchParametersAdapter
 * @see SearchFilterParametersAdapter
 * @see SearchPaginationParametersAdapter
 * @see SearchSortParametersAdapter
 */
public interface SearchParametersAdapter<
			F extends SearchFilterParameters,
			AF,
			P extends SearchPaginationParameters,
			AP,
			S extends SearchSortParameters, AS
		> extends
		SearchFilterParametersAdapter<F, AF>,
		SearchPaginationParametersAdapter<P, AP>,
		SearchSortParametersAdapter<S, AS> {

}
