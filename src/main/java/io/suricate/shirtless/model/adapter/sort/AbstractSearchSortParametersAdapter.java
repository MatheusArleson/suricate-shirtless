package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Base abstraction for {@link SearchPaginationParametersAdapter} implementations.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdapted(SearchSortParameters)}.
 *
 * @param <S> Class of the Search Sort Parameters
 * @param <AS> Class of the Adapted Type; The output of the adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractSearchSortParametersAdapter<
			S extends SearchSortParameters,
			AS
		> implements SearchSortParametersAdapter<S, AS> {

	@Override
	public final Optional<AS> adaptSort(S searchSortParameters) {
		if (SearchSortParameters.isEmpty(searchSortParameters)) {
			return Optional.empty();
		} else {
			return this.generateAdapted(searchSortParameters);
		}
	}

	/**
	 * Adapts from {@link SearchSortParameters} to an Target type defined
	 * by class generics.
	 *
	 * @param searchSortParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AS> generateAdapted(S searchSortParameters);

}
