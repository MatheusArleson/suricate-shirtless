package io.suricate.shirtless.service;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractSupervisedSearchService<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>,
			SU extends SearchParametersSupervisor<F, P, S, SP>
		> extends AbstractSearchService<O, F, P, S, SP>
		implements SupervisedSearchService<O, F, P, S, SP, SU> {

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private final SU searchParamsSupervisor;

	@Override
	public boolean isSearchWithEmptySearchParametersAllowed() {
		return this.getSearchParamsSupervisor().isSearchWithEmptySearchParametersAllowed();
	}

	@Override
	public SP getFallbackSearchParametersInstance() {
		return this.getSearchParamsSupervisor().getFallbackSearchParametersInstance();
	}

	@Override
	public boolean isSearchWithEmptySearchFilterParametersAllowed() {
		return this.getSearchParamsSupervisor().isSearchWithEmptySearchFilterParametersAllowed();
	}

	@Override
	public F getFallbackSearchFilterParametersInstance() {
		return this.getSearchParamsSupervisor().getFallbackSearchFilterParametersInstance();
	}

	@Override
	public boolean isSearchWithEmptySearchPaginationParametersAllowed() {
		return this.getSearchParamsSupervisor().isSearchWithEmptySearchPaginationParametersAllowed();
	}

	@Override
	public P getFallbackSearchPaginationParametersInstance() {
		return this.getSearchParamsSupervisor().getFallbackSearchPaginationParametersInstance();
	}

	@Override
	public boolean isSearchWithEmptySearchSortParametersAllowed() {
		return this.getSearchParamsSupervisor().isSearchWithEmptySearchSortParametersAllowed();
	}

	@Override
	public S getFallbackSearchSortParametersInstance() {
		return this.getSearchParamsSupervisor().getFallbackSearchSortParametersInstance();
	}
}
