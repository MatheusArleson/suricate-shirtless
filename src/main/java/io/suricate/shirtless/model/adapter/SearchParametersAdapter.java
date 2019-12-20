package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

public interface SearchParametersAdapter<
			F extends SearchFilterParameters, FT,
			P extends SearchPaginationParameters, PT,
			S extends SearchSortParameters, ST
		> extends
		SearchFilterParametersAdapter<F, FT>,
		SearchPaginationParametersAdapter<P, PT>,
		SearchSortParametersAdapter<S, ST> {

}
