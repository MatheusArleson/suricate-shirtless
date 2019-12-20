package io.suricate.shirtless.service;

import io.suricate.shirtless.exceptions.search.parameters.EmptyAdaptedSearchFilterParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.EmptyAdaptedSearchPaginationParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.EmptyAdaptedSearchSortParametersNotAllowed;
import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.AdaptedSearchParametersSupervisor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.Optional;

public abstract class AbstractAdaptableSearchService<
			O,
			F extends SearchFilterParameters, FT,
			P extends SearchPaginationParameters, PT,
			S extends SearchSortParameters, ST,
			SP extends SearchParameters<F, P, S>,
			SU extends AdaptedSearchParametersSupervisor<F, P, S, SP>,
			SA extends SearchParametersAdapter<F, FT, P, PT, S, ST>
		> extends AbstractSupervisedSearchService<O, F, P, S, SP, SU>
		implements AdaptableSearchService<O, F, FT, P, PT, S, ST, SP, SU, SA> {

	@Getter(AccessLevel.PROTECTED)
	private final SA searchParametersAdapter;

	public AbstractAdaptableSearchService(
		@NonNull SU searchParamsSupervisor,
		@NonNull SA searchParametersAdapter
	) {
		super(searchParamsSupervisor);
		this.searchParametersAdapter = searchParametersAdapter;
	}

	@Override
	protected Long count(F filterParameters, P paginationParameters, S sortParameters) {
		FT adaptedFilter = this.adaptFilterParameters(filterParameters);
		PT adapterPagination = this.adaptPaginationParameters(paginationParameters);
		ST adapterSort = this.adaptSortParameters(sortParameters);

		return this.count(adaptedFilter, adapterPagination, adapterSort);
	}

	protected abstract Long count(FT adaptedFilter, PT adapterPagination, ST adapterSort);

	@Override
	protected Collection<O> search(F filterParameters, P paginationParameters, S sortParameters) {
		FT adaptedFilter = this.adaptFilterParameters(filterParameters);
		PT adapterPagination = this.adaptPaginationParameters(paginationParameters);
		ST adapterSort = this.adaptSortParameters(sortParameters);

		return this.search(adaptedFilter, adapterPagination, adapterSort);
	}

	protected abstract Collection<O> search(FT adaptedFilter, PT adapterPagination, ST adapterSort);

	private FT adaptFilterParameters(F filterParameters) {
		Optional<FT> adaptedFilterOpt = this.getSearchParametersAdapter().adaptFilter(filterParameters);

		if(adaptedFilterOpt.isPresent()){
			return adaptedFilterOpt.get();
		} else {
			if(this.getSearchParamsSupervisor().isSearchWithEmptyAdaptedSearchFilterParametersAllowed()){
				return null;
			} else {
				throw new EmptyAdaptedSearchFilterParametersNotAllowed("Search with empty adapted filter parameters is not allowed.");
			}
		}
	}

	private PT adaptPaginationParameters(P paginationParameters) {
		Optional<PT> adaptedPaginationOpt = this.getSearchParametersAdapter().adaptPagination(paginationParameters);

		if(adaptedPaginationOpt.isPresent()){
			return adaptedPaginationOpt.get();
		} else {
			if(this.getSearchParamsSupervisor().isSearchWithEmptyAdaptedSearchPaginationParametersAllowed()){
				return null;
			} else {
				throw new EmptyAdaptedSearchPaginationParametersNotAllowed("Search with empty adapted pagination parameters is not allowed.");
			}
		}
	}

	private ST adaptSortParameters(S sortParameters) {
		Optional<ST> adaptedSortOpt = this.getSearchParametersAdapter().adaptSort(sortParameters);

		if(adaptedSortOpt.isPresent()){
			return adaptedSortOpt.get();
		} else {
			if(this.getSearchParamsSupervisor().isSearchWithEmptyAdaptedSearchSortParametersAllowed()){
				return null;
			} else {
				throw new EmptyAdaptedSearchSortParametersNotAllowed("Search with empty adapted sort parameters is not allowed.");
			}
		}
	}
}
