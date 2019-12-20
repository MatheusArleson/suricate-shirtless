package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import lombok.NonNull;

public abstract class AbstractSortKeyBackedDefaultSearchSortParametersAdapter<
			T,
			SKA extends SearchSortKeyAdapter
		> extends AbstractSortKeyBackedSearchSortParametersAdapter<DefaultSearchSortParameters, T, SKA> {

	public AbstractSortKeyBackedDefaultSearchSortParametersAdapter(@NonNull SKA sortKeyAdapter) {
		super(sortKeyAdapter);
	}

}
