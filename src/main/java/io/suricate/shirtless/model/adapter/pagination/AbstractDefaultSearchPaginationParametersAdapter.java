package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Abstraction of {@link SearchPaginationParametersAdapter} using default implementations for Pagination.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdapted(Integer, Integer)}.
 *
 * @param <AP> Class of the Adapted Type; The output of the adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractDefaultSearchPaginationParametersAdapter<AP>
		extends AbstractSearchPaginationParametersAdapter<DefaultSearchPaginationParameters, AP>
		implements SearchPaginationParametersAdapter<DefaultSearchPaginationParameters, AP> {

	@Override
	protected final Optional<AP> generateAdapted(@NonNull DefaultSearchPaginationParameters searchPaginationParameters) {
		return this.generateAdapted(searchPaginationParameters.getPageNumber(), searchPaginationParameters.getPageSize());
	}

	/**
	 * Adapts from {@link DefaultSearchPaginationParameters} values to an Target type defined
	 * by class generics.
	 *
	 * @param pageNumber Value for the Page Number
	 * @param pageSize Value for the Page Size
	 * @return Empty Optional if parameter cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AP> generateAdapted(Integer pageNumber, Integer pageSize);

}
