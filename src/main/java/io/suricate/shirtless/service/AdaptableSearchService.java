package io.suricate.shirtless.service;

import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;

public interface AdaptableSearchService<
			O,
			F extends SearchFilterParameters, FT,
			P extends SearchPaginationParameters, PT,
			S extends SearchSortParameters, ST,
			SP extends SearchParameters<F, P, S>,
			SU extends SearchParametersSupervisor<F, P, S, SP>,
			SA extends SearchParametersAdapter<F, FT, P, PT, S, ST>
		> extends SupervisedSearchService<O, F, P, S, SP, SU> {

}
