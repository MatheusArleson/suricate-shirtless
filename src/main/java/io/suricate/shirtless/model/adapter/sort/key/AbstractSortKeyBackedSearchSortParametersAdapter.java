package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.adapter.sort.AbstractSearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
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
		String[] searchSortKeysValues = Arrays.stream(sortCodes)
				.map((sortCode) ->  this.getSortKeyAdapter().adaptSortKeyCode(sortCode))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(SearchSortKey::getValue)
				.toArray(String[]::new);

		if(searchSortKeysValues.length != sortCodes.length){
			return Optional.empty();
		}

		return this.generateAdaptedFromSearchSortKeys(searchSortKeysValues, sortDirections);
	}

	protected abstract Optional<T> generateAdaptedFromSearchSortKeys(String[] searchSortKeys, String[] sortDirections);

}
