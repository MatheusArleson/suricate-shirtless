package io.suricate.shirtless.service.defaults;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.service.AbstractSearchService;
import io.suricate.shirtless.service.SearchService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractDefaultSearchService<
			O,
			F extends SearchFilterParameters,
			SP extends SearchParameters<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters>
		> extends AbstractSearchService<O, F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP>
		implements SearchService<O, F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP> {

}
