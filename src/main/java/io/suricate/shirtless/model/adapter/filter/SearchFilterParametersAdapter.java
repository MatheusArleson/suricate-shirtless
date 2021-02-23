package io.suricate.shirtless.model.adapter.filter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.Optional;

/**
 * Base interface for adaptation of an {@link SearchFilterParameters}.
 * <br><br>
 * Instances should focus on the adaptation of the {@link SearchFilterParameters}
 * to the Target class defined in the class generics.
 * <br><br>
 * The Target class is the object that another layer can work with.
 * Eg. Spring cannot understand {@link SearchFilterParameters} object, so we need to adapt to an
 * Specification class instance in order for it to be processed by Spring.
 * <br><br>
 * More information on the <a href="http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm">Adapter Design Pattern</a>.
 *
 * @param <F> Class of the Search Sort Parameters
 * @param <AF> Class of the Adapted Type; The output of the adapter.
 *
 * @see SearchSortParameters
 *
 */
public interface SearchFilterParametersAdapter<F extends SearchFilterParameters, AF> {

	/**
	 * Adapts an {@link SearchFilterParameters} to an Target type defined
	 * by class generics.
	 *
	 * @param searchFilterParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 *
	 */
	Optional<AF> adaptFilter(F searchFilterParameters);

}
