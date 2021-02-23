package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Base abstraction for {@link SearchPaginationParametersAdapter} implementations.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdapted(SearchPaginationParameters)}.
 *
 * @param <P> Class of the Search Pagination Parameters
 * @param <AP> Class of the Adapted Type; The output of the adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractSearchPaginationParametersAdapter<
			P extends SearchPaginationParameters,
			AP
		> implements SearchPaginationParametersAdapter<P, AP> {

	@Override
	public final Optional<AP> adaptPagination(P searchPaginationParameters) {
		if (SearchPaginationParameters.isEmpty(searchPaginationParameters)) {
			return Optional.empty();
		} else {
			return this.generateAdapted(searchPaginationParameters);
		}
	}

	/**
	 * Adapts from {@link SearchPaginationParameters} to an Target type defined
	 * by class generics.
	 *
	 * @param searchPaginationParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AP> generateAdapted(P searchPaginationParameters);

}
