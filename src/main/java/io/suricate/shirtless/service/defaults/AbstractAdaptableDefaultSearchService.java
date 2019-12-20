package io.suricate.shirtless.service.defaults;

import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.service.AbstractAdaptableSearchService;
import io.suricate.shirtless.service.AdaptableSearchService;
import io.suricate.shirtless.service.params.supervisor.AdaptedSearchParametersSupervisor;

public abstract class AbstractAdaptableDefaultSearchService<
			O,
			F extends SearchFilterParameters, FT,
			PT,
			ST,
			SP extends SearchParameters<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters>,
			SU extends AdaptedSearchParametersSupervisor<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP>,
			SA extends SearchParametersAdapter<F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST>
		> extends AbstractAdaptableSearchService<O, F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST, SP, SU, SA>
		implements AdaptableSearchService<O, F, FT, DefaultSearchPaginationParameters, PT, DefaultSearchSortParameters, ST, SP, SU, SA> {

	public AbstractAdaptableDefaultSearchService(
		SU searchParamsSupervisor,
		SA searchParametersAdapter
	) {
		super(searchParamsSupervisor, searchParametersAdapter);
	}
}
