package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;

import java.util.Optional;

/**
 * Base interface for adaptation of an Search Pagination Parameters.
 * <p>
 * Instances should focus on the adaptation of the {@link SearchPaginationParameters}
 * to the Target class defined in the class generics.
 * <p>
 * The Target class is the object that another layer can work with.
 * Eg. Spring cannot understand {@link SearchPaginationParameters}, so we need to adapt to an
 * Pageable class instance.
 * <p>
 * Adapter Design Pattern: http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * @param <P> Class of the Search Pagination Parameters
 * @param <T> Class of the Adapted Type; The output of the adapter.
 *
 * @see SearchPaginationParameters
 *
 */
public interface SearchPaginationParametersAdapter<P extends SearchPaginationParameters, T> {

	/**
	 * Adapts from {@link SearchPaginationParameters} to an Target type defined
	 * by class generics.
	 * <p>
	 *
	 *
	 * @param searchPaginationParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 *
	 */
	Optional<T> adaptPagination(P searchPaginationParameters);

}
