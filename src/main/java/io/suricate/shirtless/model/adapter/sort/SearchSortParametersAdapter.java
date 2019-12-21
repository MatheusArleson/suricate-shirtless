package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.Optional;

/**
 * Base interface for adaptation of an Search Sort Parameters.
 * <p>
 * Instances should focus on the adaptation of the {@link SearchSortParameters}
 * to the Target class defined in the class generics.
 * <p>
 * The Target class is the object that another layer can work with.
 * Eg. Spring cannot understand {@link SearchSortParameters}, so we need to adapt to an
 * Pageable.Sort class instance.
 * <p>
 * Adapter Design Pattern: http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * @param <S> Class of the Search Sort Parameters
 * @param <T> Class of the Adapted Type; The output of the adapter.
 *
 * @see SearchSortParameters
 *
 */
public interface SearchSortParametersAdapter<S extends SearchSortParameters, T> {

	/**
	 * Adapts an {@link SearchSortParameters} to an Target type defined
	 * by class generics.
	 * <p>
	 *
	 *
	 * @param searchSortParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 *
	 */
	Optional<T> adaptSort(S searchSortParameters);

}
