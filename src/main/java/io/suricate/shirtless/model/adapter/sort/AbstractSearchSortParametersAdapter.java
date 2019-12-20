package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractSearchSortParametersAdapter<
			S extends SearchSortParameters,
			T
		> implements SearchSortParametersAdapter<S, T> {

	@Override
	public Optional<T> adaptSort(S searchSortParameters) {
		if (SearchSortParameters.isEmpty(searchSortParameters)) {
			return Optional.empty();
		} else {
			return this.generateAdapted(
				searchSortParameters.getSortCodes(),
				searchSortParameters.getSortDirections()
			);
		}
	}

	protected abstract Optional<T> generateAdapted(String[] sortCodes, String[] sortDirections);

}
