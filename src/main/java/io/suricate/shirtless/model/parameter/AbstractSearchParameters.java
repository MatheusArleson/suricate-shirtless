package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractSearchParameters<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters
		> implements SearchParameters<F, P, S> {

	private F filterParameters;
	private P paginationParameters;
	private S sortParameters;

}
