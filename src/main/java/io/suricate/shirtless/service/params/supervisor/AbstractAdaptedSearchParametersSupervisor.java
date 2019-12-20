package io.suricate.shirtless.service.params.supervisor;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.function.Supplier;

public abstract class AbstractAdaptedSearchParametersSupervisor<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> extends AbstractSearchParametersSupervisor<F, P, S, SP>
		implements AdaptedSearchParametersSupervisor<F, P, S, SP> {

	private final boolean searchWithEmptyAdaptedSearchFilterParametersAllowed;
	private final boolean searchWithEmptyAdaptedSearchPaginationParametersAllowed;
	private final boolean searchWithEmptyAdaptedSearchSortParametersAllowed;

	public AbstractAdaptedSearchParametersSupervisor(
		boolean searchWithEmptySearchParametersAllowed, Supplier<SP> fallbackSearchParametersSupplier,
		boolean searchWithEmptySearchFilterParametersAllowed, Supplier<F> fallbackSearchFilterParametersSupplier,
		boolean searchWithEmptySearchPaginationParametersAllowed, Supplier<P> fallbackSearchPaginationParametersSupplier,
		boolean searchWithEmptySearchSortParametersAllowed, Supplier<S> fallbackSearchSortParametersSupplier,
		boolean searchWithEmptyAdaptedSearchFilterParametersAllowed,
		boolean searchWithEmptyAdaptedSearchPaginationParametersAllowed,
		boolean searchWithEmptyAdaptedSearchSortParametersAllowed
	) {
		super(
			searchWithEmptySearchParametersAllowed, fallbackSearchParametersSupplier,
			searchWithEmptySearchFilterParametersAllowed, fallbackSearchFilterParametersSupplier,
			searchWithEmptySearchPaginationParametersAllowed, fallbackSearchPaginationParametersSupplier,
			searchWithEmptySearchSortParametersAllowed, fallbackSearchSortParametersSupplier
		);

		this.searchWithEmptyAdaptedSearchFilterParametersAllowed = searchWithEmptyAdaptedSearchFilterParametersAllowed;
		this.searchWithEmptyAdaptedSearchPaginationParametersAllowed = searchWithEmptyAdaptedSearchPaginationParametersAllowed;
		this.searchWithEmptyAdaptedSearchSortParametersAllowed = searchWithEmptyAdaptedSearchSortParametersAllowed;
	}


	@Override
	public boolean isSearchWithEmptyAdaptedSearchFilterParametersAllowed() {
		return this.searchWithEmptyAdaptedSearchFilterParametersAllowed;
	}

	@Override
	public boolean isSearchWithEmptyAdaptedSearchPaginationParametersAllowed() {
		return this.searchWithEmptyAdaptedSearchPaginationParametersAllowed;
	}

	@Override
	public boolean isSearchWithEmptyAdaptedSearchSortParametersAllowed() {
		return this.searchWithEmptyAdaptedSearchSortParametersAllowed;
	}

}
