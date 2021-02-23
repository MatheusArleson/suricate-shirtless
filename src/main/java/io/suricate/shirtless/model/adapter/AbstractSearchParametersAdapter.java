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

/**
 * Base Abstraction for {@link SearchParametersAdapter} implementations.
 * <br><br>
 * Extensions of this class just need to specify target types and adapters that can perform the adaptation.
 *
 * @param <F>  Type of the Filter - Anything that extends {@link SearchFilterParameters}
 * @param <AF> Type of Adapted Filter - To be used on downstream
 * @param <FA> Type of Filter Adapter - Anything that extends {@link SearchFilterParametersAdapter}
 * @param <P>  Type of the Pagination - Anything that extends {@link SearchPaginationParameters}
 * @param <AP> Type of Adapted Pagination - To be used on downstream
 * @param <PA> Type of Pagination Adapter - Anything that extends {@link SearchPaginationParametersAdapter}
 * @param <S>  Type of the Sort - Anything that extends {@link SearchSortParameters}
 * @param <AS> Type of Adapted Sort - To be used on downstream
 * @param <SA> Type of Sort Adapter - Anything that extends {@link SearchSortParametersAdapter}
 *
 * @see SearchParametersAdapter
 * @see AbstractDefaultSearchParametersAdapter
 * @see SearchFilterParametersAdapter
 * @see SearchPaginationParametersAdapter
 * @see SearchSortParametersAdapter
 */
@RequiredArgsConstructor
public abstract class AbstractSearchParametersAdapter<
			F extends SearchFilterParameters,
			AF,
			FA extends SearchFilterParametersAdapter<F, AF>,
			P extends SearchPaginationParameters,
			AP,
			PA extends SearchPaginationParametersAdapter<P, AP>,
			S extends SearchSortParameters,
			AS,
			SA extends SearchSortParametersAdapter<S, AS>
		> implements SearchParametersAdapter<F, AF, P, AP, S, AS> {

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private final FA filterAdapter;

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private final PA paginationAdapter;

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private final SA sortAdapter;

	@Override
	public Optional<AF> adaptFilter(F searchFilterParameters) {
		return this.getFilterAdapter().adaptFilter(searchFilterParameters);
	}

	@Override
	public Optional<AP> adaptPagination(P searchPaginationParameters) {
		return this.getPaginationAdapter().adaptPagination(searchPaginationParameters);
	}

	@Override
	public Optional<AS> adaptSort(S searchSortParameters) {
		return this.getSortAdapter().adaptSort(searchSortParameters);
	}

}
