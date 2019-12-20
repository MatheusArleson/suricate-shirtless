package io.suricate.shirtless.service;

import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.AdaptedSearchParametersSupervisor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

public abstract class AbstractDataStoreSearchService<
			O,
			F extends SearchFilterParameters,
			FT,
			P extends SearchPaginationParameters, PT,
			S extends SearchSortParameters, ST,
			SP extends SearchParameters<F, P, S>,
			SU extends AdaptedSearchParametersSupervisor<F, P, S, SP>,
			SA extends SearchParametersAdapter<F, FT, P, PT, S, ST>,
			DS
		> extends AbstractAdaptableSearchService<O, F, FT, P, PT, S, ST, SP, SU, SA>
		implements DataStoreSearchService<O, F, FT, P, PT, S, ST, SP, SU, SA, DS> {

	@Getter(AccessLevel.PROTECTED)
	private final DS dataStore;

	public AbstractDataStoreSearchService(
		@NonNull SU searchParamsSupervisor,
		@NonNull SA searchParametersAdapter,
		@NonNull DS dataStore
	) {
		super(searchParamsSupervisor, searchParametersAdapter);

		this.dataStore = dataStore;
	}

}
