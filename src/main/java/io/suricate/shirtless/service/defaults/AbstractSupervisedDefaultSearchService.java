package io.suricate.shirtless.service.defaults;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.service.AbstractSupervisedSearchService;
import io.suricate.shirtless.service.SupervisedSearchService;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;
import lombok.NonNull;

public abstract class AbstractSupervisedDefaultSearchService<
			O,
			F extends SearchFilterParameters,
			SP extends SearchParameters<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters>,
			SU extends SearchParametersSupervisor<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP>
		> extends AbstractSupervisedSearchService<O, F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP, SU>
		implements SupervisedSearchService<O, F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP, SU> {

	public AbstractSupervisedDefaultSearchService(@NonNull SU searchParamsSupervisor) {
		super(searchParamsSupervisor);
	}

}
