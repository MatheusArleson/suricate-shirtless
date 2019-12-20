package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractDefaultSearchSortParametersAdapter<T>
		extends AbstractSearchSortParametersAdapter<DefaultSearchSortParameters, T>
		implements SearchSortParametersAdapter<DefaultSearchSortParameters, T> {

}
