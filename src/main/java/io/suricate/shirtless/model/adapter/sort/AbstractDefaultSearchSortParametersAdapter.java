package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Abstraction of {@link SearchSortParametersAdapter} using default implementations for Sorting.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdapted(String[], String[])}.
 *
 * @param <AS> Class of the Adapted Type; The output of the adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractDefaultSearchSortParametersAdapter<AS>
		extends AbstractSearchSortParametersAdapter<DefaultSearchSortParameters, AS>
		implements SearchSortParametersAdapter<DefaultSearchSortParameters, AS> {

	@Override
	protected final Optional<AS> generateAdapted(DefaultSearchSortParameters searchSortParameters) {
		return this.generateAdapted(searchSortParameters.getSortCodes(), searchSortParameters.getSortDirections());
	}

	/**
	 * Adapts from {@link DefaultSearchSortParameters} values to an Target type defined
	 * by class generics.
	 *
	 * @param sortCodes Values of Sort Codes
	 * @param sortDirections Values of Sort Directions
	 * @return Empty Optional if parameter cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AS> generateAdapted(String[] sortCodes, String[] sortDirections);

}
