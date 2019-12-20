package io.suricate.shirtless.service.params.supervisor;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@AllArgsConstructor
public abstract class AbstractSearchParametersSupervisor<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> implements SearchParametersSupervisor<F, P, S, SP> {

	private final boolean searchWithEmptySearchParametersAllowed;
	@Getter(AccessLevel.PROTECTED)
	private final Supplier<SP> fallbackSearchParametersSupplier;

	private final boolean searchWithEmptySearchFilterParametersAllowed;
	@Getter(AccessLevel.PROTECTED)
	private final Supplier<F> fallbackSearchFilterParametersSupplier;

	private final boolean searchWithEmptySearchPaginationParametersAllowed;
	@Getter(AccessLevel.PROTECTED)
	private final Supplier<P> fallbackSearchPaginationParametersSupplier;

	private final boolean searchWithEmptySearchSortParametersAllowed;
	@Getter(AccessLevel.PROTECTED)
	private final Supplier<S> fallbackSearchSortParametersSupplier;

	@Override
	public boolean isSearchWithEmptySearchParametersAllowed() {
		return this.searchWithEmptySearchParametersAllowed;
	}

	@Override
	public SP getFallbackSearchParametersInstance() {
		return this.getFallbackSearchParametersSupplier().get();
	}

	@Override
	public boolean isSearchWithEmptySearchFilterParametersAllowed() {
		return this.searchWithEmptySearchFilterParametersAllowed;
	}

	@Override
	public F getFallbackSearchFilterParametersInstance() {
		return this.getFallbackSearchFilterParametersSupplier().get();
	}

	@Override
	public boolean isSearchWithEmptySearchPaginationParametersAllowed() {
		return this.searchWithEmptySearchPaginationParametersAllowed;
	}

	@Override
	public P getFallbackSearchPaginationParametersInstance() {
		return this.getFallbackSearchPaginationParametersSupplier().get();
	}

	@Override
	public boolean isSearchWithEmptySearchSortParametersAllowed() {
		return this.searchWithEmptySearchSortParametersAllowed;
	}

	@Override
	public S getFallbackSearchSortParametersInstance() {
		return this.getFallbackSearchSortParametersSupplier().get();
	}
}
