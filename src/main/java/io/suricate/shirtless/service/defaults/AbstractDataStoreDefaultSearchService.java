package io.suricate.shirtless.service.defaults;

import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.service.AbstractDataStoreSearchService;
import io.suricate.shirtless.service.DataStoreSearchService;
import io.suricate.shirtless.service.params.supervisor.AdaptedSearchParametersSupervisor;
import lombok.NonNull;

public abstract class AbstractDataStoreDefaultSearchService<
			O,
			F extends SearchFilterParameters,
			FT,
			PT,
			ST,
			SP extends SearchParameters<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters>,
			SU extends AdaptedSearchParametersSupervisor<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP>,
			SA extends SearchParametersAdapter<F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST>,
			DS
		> extends AbstractDataStoreSearchService<O, F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST, SP, SU, SA, DS>
		implements DataStoreSearchService<O, F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST, SP, SU, SA, DS> {

	public AbstractDataStoreDefaultSearchService(
		@NonNull SU searchParamsSupervisor,
		@NonNull SA searchParametersAdapter,
		@NonNull DS dataStore
	) {
		super(searchParamsSupervisor, searchParametersAdapter, dataStore);
	}

}
