package io.suricate.shirtless.service;

import io.suricate.shirtless.exceptions.search.parameters.EmptySearchFilterParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchPaginationParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchSortParametersNotAllowed;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public abstract class AbstractSearchService<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> implements SearchService<O, F, P, S, SP> {

	@Override
	public Long count(SP searchParameters) {
		SP safeSearchParameters = this.safeGetSearchParameters(searchParameters);
		F filterParameters = this.safeGetFilterParameters(safeSearchParameters.getFilterParameters());
		P paginationParameters = this.safeGetPaginationParameters(safeSearchParameters.getPaginationParameters());
		S sortParameters = this.safeGetSortParameters(safeSearchParameters.getSortParameters());

		return this.count(filterParameters, paginationParameters, sortParameters);
	}

	protected abstract Long count(F filterParameters, P paginationParameters, S sortParameters);

	@Override
	public Collection<O> search(SP searchParameters) {
		SP safeSearchParameters = this.safeGetSearchParameters(searchParameters);
		F filterParameters = this.safeGetFilterParameters(safeSearchParameters.getFilterParameters());
		P paginationParameters = this.safeGetPaginationParameters(safeSearchParameters.getPaginationParameters());
		S sortParameters = this.safeGetSortParameters(safeSearchParameters.getSortParameters());

		return this.search(filterParameters, paginationParameters, sortParameters);
	}

	protected abstract Collection<O> search(F filterParameters, P paginationParameters, S sortParameters);

	private SP safeGetSearchParameters(SP searchParameters) {
		if (SearchParameters.isNotEmpty(searchParameters)) {
			return searchParameters;
		} else {
			if (this.isSearchWithEmptySearchParametersAllowed()) {
				return this.getFallbackSearchParametersInstance();
			} else {
				throw new EmptySearchParametersNotAllowed("Search with empty parameters is not allowed.");
			}
		}
	}

	private F safeGetFilterParameters(F searchFilterParameters) {
		if (SearchFilterParameters.isNotEmpty(searchFilterParameters)) {
			return searchFilterParameters;
		} else {
			if (this.isSearchWithEmptySearchFilterParametersAllowed()) {
				return this.getFallbackSearchFilterParametersInstance();
			} else {
				throw new EmptySearchFilterParametersNotAllowed("Search with empty filter parameters is not allowed.");
			}
		}
	}

	private P safeGetPaginationParameters(P searchPaginationParameters) {
		if (SearchPaginationParameters.isNotEmpty(searchPaginationParameters)) {
			return searchPaginationParameters;
		} else {
			if (this.isSearchWithEmptySearchPaginationParametersAllowed()) {
				return this.getFallbackSearchPaginationParametersInstance();
			} else {
				throw new EmptySearchPaginationParametersNotAllowed("Search with empty pagination parameters is not allowed.");
			}
		}
	}

	private S safeGetSortParameters(S searchSortParameters) {
		if (SearchSortParameters.isNotEmpty(searchSortParameters)) {
			return searchSortParameters;
		} else {
			if (this.isSearchWithEmptySearchSortParametersAllowed()) {
				return this.getFallbackSearchSortParametersInstance();
			} else {
				throw new EmptySearchSortParametersNotAllowed("Search with empty sort parameters is not allowed.");
			}
		}
	}
}
