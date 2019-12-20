package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractSearchParametersAdapter<
			F extends SearchFilterParameters, FT,
			FA extends SearchFilterParametersAdapter<F, FT>,
			P extends SearchPaginationParameters, PT,
			PA extends SearchPaginationParametersAdapter<P, PT>,
			S extends SearchSortParameters, ST,
			SA extends SearchSortParametersAdapter<S, ST>
		> implements SearchParametersAdapter<F, FT, P, PT, S, ST> {

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private FA filterAdapter;

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private PA paginationAdapter;

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private SA sortAdapter;

	@Override
	public Optional<FT> adaptFilter(F searchFilterParameters) {
		return this.getFilterAdapter().adaptFilter(searchFilterParameters);
	}

	@Override
	public Optional<PT> adaptPagination(P searchPaginationParameters) {
		return this.getPaginationAdapter().adaptPagination(searchPaginationParameters);
	}

	@Override
	public Optional<ST> adaptSort(S searchSortParameters) {
		return this.getSortAdapter().adaptSort(searchSortParameters);
	}

}
