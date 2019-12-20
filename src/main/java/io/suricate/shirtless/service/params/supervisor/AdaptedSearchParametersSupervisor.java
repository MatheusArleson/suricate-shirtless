package io.suricate.shirtless.service.params.supervisor;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

public interface AdaptedSearchParametersSupervisor<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> extends SearchParametersSupervisor<F, P, S, SP> {

	boolean isSearchWithEmptyAdaptedSearchFilterParametersAllowed();
	boolean isSearchWithEmptyAdaptedSearchPaginationParametersAllowed();
	boolean isSearchWithEmptyAdaptedSearchSortParametersAllowed();

}
