package io.suricate.shirtless.service;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;

public interface SupervisedSearchService<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>,
			SU extends SearchParametersSupervisor<F, P, S, SP>
		> extends SearchService<O, F, P, S, SP> {

}
