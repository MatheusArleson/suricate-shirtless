package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.exceptions.search.parameters.InvalidSortKeyException;
import io.suricate.shirtless.model.adapter.sort.AbstractSearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractSortKeyBackedSearchSortParametersAdapter<
			S extends SearchSortParameters,
			T,
			SKA extends SearchSortKeyAdapter
		> extends AbstractSearchSortParametersAdapter<S, T> {

	@Getter(AccessLevel.PROTECTED)
	@NonNull
	private SKA sortKeyAdapter;

	@Override
	protected Optional<T> generateAdapted(String[] sortCodes, String[] sortDirections) {
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

		return this.generateAdaptedFromSearchSortKeysValues(searchSortKeyValues, sortDirections);
	}

	protected abstract Optional<T> generateAdaptedFromSearchSortKeysValues(String[] searchSortKeysValues, String[] sortDirections);

}
