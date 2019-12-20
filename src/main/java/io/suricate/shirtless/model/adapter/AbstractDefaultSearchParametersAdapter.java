package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import lombok.NonNull;

public class AbstractDefaultSearchParametersAdapter<
			F extends SearchFilterParameters, FT,
			FA extends SearchFilterParametersAdapter<F, FT>,
			PT,
			PA extends SearchPaginationParametersAdapter<DefaultSearchPaginationParameters, PT>,
			ST,
			SA extends SearchSortParametersAdapter<DefaultSearchSortParameters, ST>
		> extends AbstractSearchParametersAdapter<F, FT, FA, DefaultSearchPaginationParameters, PT, PA, DefaultSearchSortParameters, ST, SA> {

	public AbstractDefaultSearchParametersAdapter(
		@NonNull FA filterAdapter,
		@NonNull PA paginationAdapter,
		@NonNull SA sortAdapter
	) {
		super(filterAdapter, paginationAdapter, sortAdapter);
	}

}
