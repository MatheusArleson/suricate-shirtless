package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.adapter.sort.key.SearchSortKeyAdapter;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.NonNull;

import java.util.Optional;

/**
 * Abstraction for {@link AbstractSortKeyBackedSearchSortParametersAdapter} using the default implementation for Sorting.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdaptedFromSearchSortKeysValues(String[], String[])}.
 *
 * @param <AS>  Class of the Adapted Type; The output of the adapter.
 * @param <SKA> Class of the Search Sort Key Adapter.
 *
 * @see SearchSortParameters
 * @see SearchSortParametersAdapter
 * @see AbstractSortKeyBackedSearchSortParametersAdapter
 */

public abstract class AbstractSortKeyBackedDefaultSearchSortParametersAdapter<
			AS,
			SKA extends SearchSortKeyAdapter
		> extends AbstractSortKeyBackedSearchSortParametersAdapter<DefaultSearchSortParameters, AS, SKA> {

	/**
	 * Constructs an instance of the adapted with the provided {@link SearchSortKeyAdapter}.
	 *
	 * @param sortKeyAdapter contains the sort key adapter to be used.
	 */
	public AbstractSortKeyBackedDefaultSearchSortParametersAdapter(@NonNull SKA sortKeyAdapter) {
		super(sortKeyAdapter);
	}

	@Override
	protected final Optional<AS> generateAdaptedFromSearchSortKeysValues(DefaultSearchSortParameters searchSortParameters, String[] searchSortKeysValues) {
		return this.generateAdaptedFromSearchSortKeysValues(searchSortKeysValues, searchSortParameters.getSortDirections());
	}

	/**
	 * Adapts from {@link DefaultSearchSortParameters} to an Target type defined
	 * by class generics - additionally receiving the adapted sort keys values.
	 *
	 * @param searchSortKeysValues contains the values referenced by the sort parameters codes.
	 * @param searchSortDirections contains the sort directions.
	 * @return Empty Optional if cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AS> generateAdaptedFromSearchSortKeysValues(String[] searchSortKeysValues, String[] searchSortDirections);

}
