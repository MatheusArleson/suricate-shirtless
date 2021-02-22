package io.suricate.shirtless.service.defaults;

import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.service.AbstractDataSourceSearchService;
import io.suricate.shirtless.service.DataSourceSearchService;
import io.suricate.shirtless.service.params.supervisor.AdaptedSearchParametersSupervisor;
import lombok.NonNull;

public abstract class AbstractDataSourceDefaultSearchService<
			O,
			F extends SearchFilterParameters,
			FT,
			PT,
			ST,
			SP extends SearchParameters<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters>,
			SU extends AdaptedSearchParametersSupervisor<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP>,
			SA extends SearchParametersAdapter<F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST>,
			DS
		> extends AbstractDataSourceSearchService<O, F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST, SP, SU, SA, DS>
		implements DataSourceSearchService<O, F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST, SP, SU, SA, DS> {

	public AbstractDataSourceDefaultSearchService(
		@NonNull SU searchParamsSupervisor,
		@NonNull SA searchParametersAdapter,
		@NonNull DS dataStore
	) {
		super(searchParamsSupervisor, searchParametersAdapter, dataStore);
	}

}
