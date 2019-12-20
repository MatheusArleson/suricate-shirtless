package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractSearchPaginationParametersAdapter<
			P extends SearchPaginationParameters,
			T
		> implements SearchPaginationParametersAdapter<P, T> {

	@Override
	public Optional<T> adaptPagination(P searchPaginationParameters) {
		if (SearchPaginationParameters.isEmpty(searchPaginationParameters)) {
			return Optional.empty();
		} else {
			return this.generateAdapted(
				searchPaginationParameters.getPageNumber(),
				searchPaginationParameters.getPageSize()
			);
		}
	}

	protected abstract Optional<T> generateAdapted(Integer pageNumber, Integer pageSize);

}
