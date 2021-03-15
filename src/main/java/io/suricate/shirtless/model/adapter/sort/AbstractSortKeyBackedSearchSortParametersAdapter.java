package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.exceptions.search.parameters.InvalidSortKeyException;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.AbstractSearchSortParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.key.SearchSortKeyAdapter;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Base abstraction for {@link AbstractSearchSortParametersAdapter} implementations that rely on a {@link SearchSortKeyAdapter}.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdaptedFromSearchSortKeysValues(SearchSortParameters, String[])}.
 *
 * @param <S>   Class of the Search Sort Parameters
 * @param <AS>  Class of the Adapted Type; The output of the adapter.
 * @param <SKA> Class of the Search Sort Key Adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractSortKeyBackedSearchSortParametersAdapter<
			S extends SearchSortParameters,
			AS,
			SKA extends SearchSortKeyAdapter
		> extends AbstractSearchSortParametersAdapter<S, AS> {

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private final SKA sortKeyAdapter;

	@Override
	protected Optional<AS> generateAdapted(S searchSortParameters) {
		String[] sortCodes = searchSortParameters.getSortCodes();
		int numberOfSortCodes = sortCodes.length;
		String[] searchSortKeyValues = new String[numberOfSortCodes];

		for (int idx = 0; idx < numberOfSortCodes; idx++) {
			String sortCode = sortCodes[idx];
			Optional<SearchSortKey> searchSortKeyOpt = this.getSortKeyAdapter().adaptSortKeyCode(sortCode);

			if(searchSortKeyOpt.isPresent()){
				searchSortKeyValues[idx] = searchSortKeyOpt.get().getValue();
			} else {
				throw new InvalidSortKeyException("Invalid Sort code detected.");
			}
		}

		return this.generateAdaptedFromSearchSortKeysValues(searchSortParameters, searchSortKeyValues);
	}

	/**
	 * Adapts from {@link SearchSortParameters} to an Target type defined
	 * by class generics - additionally receiving the adapted sort keys values.
	 *
	 * @param searchSortParameters the instance to be adapted.
	 * @param searchSortKeysValues the values referenced by the sort parameters codes.
	 * @return Empty Optional if cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AS> generateAdaptedFromSearchSortKeysValues(S searchSortParameters, String[] searchSortKeysValues);

}
