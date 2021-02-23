package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import lombok.NonNull;

import java.util.Optional;

/**
 *
 *
 * @param <T>
 * @param <SKA>
 */
public abstract class AbstractSortKeyBackedDefaultSearchSortParametersAdapter<
			T,
			SKA extends SearchSortKeyAdapter
		> extends AbstractSortKeyBackedSearchSortParametersAdapter<DefaultSearchSortParameters, T, SKA> {

	/**
	 *
	 *
	 * @param sortKeyAdapter
	 */
	public AbstractSortKeyBackedDefaultSearchSortParametersAdapter(@NonNull SKA sortKeyAdapter) {
		super(sortKeyAdapter);
	}

	@Override
	protected final Optional<T> generateAdaptedFromSearchSortKeysValues(String[] searchSortKeysValues, DefaultSearchSortParameters searchSortParameters) {
		return this.generateAdaptedFromSearchSortKeysValues(searchSortKeysValues, searchSortParameters.getSortDirections());
	}

	/**
	 *
	 * @param searchSortKeysValues
	 * @param searchSortDirections
	 * @return
	 */
	protected abstract Optional<T> generateAdaptedFromSearchSortKeysValues(String[] searchSortKeysValues, String[] searchSortDirections);

}
