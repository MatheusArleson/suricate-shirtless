package io.suricate.shirtless.model.adapter.filter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Base abstraction for {@link SearchFilterParametersAdapter} implementations.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #generateAdapted(SearchFilterParameters)}.
 *
 * @param <F> Class of the Search Sort Parameters
 * @param <AF> Class of the Adapted Type; The output of the adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractSearchFilterParametersAdapter<
			F extends SearchFilterParameters,
			AF
		> implements SearchFilterParametersAdapter<F, AF> {

	@Override
	public final Optional<AF> adaptFilter(F searchFilterParameters) {
		if (SearchFilterParameters.isEmpty(searchFilterParameters)) {
			return Optional.empty();
		} else {
			return this.generateAdapted(searchFilterParameters);
		}
	}

	/**
	 * Specify HOW the adapted does his work of adapting from the {@link F} type to target {@link AF} type.
	 *
	 * @param searchFilterParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 */
	protected abstract Optional<AF> generateAdapted(F searchFilterParameters);

}
