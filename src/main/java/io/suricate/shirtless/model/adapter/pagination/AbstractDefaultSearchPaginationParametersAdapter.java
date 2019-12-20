package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractDefaultSearchPaginationParametersAdapter<T>
		extends AbstractSearchPaginationParametersAdapter<DefaultSearchPaginationParameters, T>
		implements SearchPaginationParametersAdapter<DefaultSearchPaginationParameters, T> {

}
