package io.suricate.shirtless.service.params.supervisor;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

public interface SearchParametersSupervisor<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> {

	boolean isSearchWithEmptySearchParametersAllowed();

	SP getFallbackSearchParametersInstance();

	boolean isSearchWithEmptySearchFilterParametersAllowed();

	F getFallbackSearchFilterParametersInstance();

	boolean isSearchWithEmptySearchPaginationParametersAllowed();

	P getFallbackSearchPaginationParametersInstance();

	boolean isSearchWithEmptySearchSortParametersAllowed();

	S getFallbackSearchSortParametersInstance();

}
