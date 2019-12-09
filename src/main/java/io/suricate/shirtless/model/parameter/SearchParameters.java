package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.Objects;

public interface SearchParameters<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters
		> {

	F getFilterParameters();
	void setFilterParameters(F filterParameters);

	P getPaginationParameters();
	void setPaginationParameters(P paginationParameters);

	S getSortParameters();
	void setSortParameters(S sortParameters);

	static boolean isNull(SearchParameters parameters){
		return Objects.isNull(parameters);
	}

	static boolean isNotNull(SearchParameters parameters){
		return !isNull(parameters);
	}

	static boolean isEmpty(SearchParameters parameters){
		return isNull(parameters) || (
			SearchFilterParameters.isEmpty(parameters.getFilterParameters()) &&
			SearchPaginationParameters.isEmpty(parameters.getPaginationParameters()) &&
			SearchSortParameters.isEmpty(parameters.getSortParameters())
		);
	}

	static boolean isNotEmpty(SearchParameters parameters){
		return !isEmpty(parameters);
	}



}
