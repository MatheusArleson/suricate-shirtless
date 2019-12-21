package io.suricate.shirtless.model.adapter.filter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.Optional;

/**
 * Base interface for adaptation of an Search Filter Parameters.
 * <p>
 * Instances should focus on the adaptation of the {@link SearchFilterParameters}
 * to the Target class defined in the class generics.
 * <p>
 * The Target class is the object that another layer can work with.
 * Eg. Spring cannot understand {@link SearchFilterParameters}, so we need to adapt to an
 * Specification class instance.
 * <p>
 * Adapter Design Pattern: http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * @param <F> Class of the Search Sort Parameters
 * @param <T> Class of the Adapted Type; The output of the adapter.
 *
 * @see SearchSortParameters
 *
 */
public interface SearchFilterParametersAdapter<F extends SearchFilterParameters, T> {

	/**
	 * Adapts an {@link SearchFilterParameters} to an Target type defined
	 * by class generics.
	 * <p>
	 *
	 *
	 * @param searchFilterParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 *
	 */
	Optional<T> adaptFilter(F searchFilterParameters);

}
