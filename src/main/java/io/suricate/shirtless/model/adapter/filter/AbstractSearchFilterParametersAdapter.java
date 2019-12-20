package io.suricate.shirtless.model.adapter.filter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractSearchFilterParametersAdapter<
			F extends SearchFilterParameters,
			T
		> implements SearchFilterParametersAdapter<F, T> {

	@Override
	public Optional<T> adaptFilter(F searchFilterParameters) {
		if (SearchFilterParameters.isEmpty(searchFilterParameters)) {
			return Optional.empty();
		} else {
			return this.generateAdapted(searchFilterParameters);
		}
	}

	protected abstract Optional<T> generateAdapted(F searchFilterParameters);

}
