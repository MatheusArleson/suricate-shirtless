package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;

import java.util.Optional;

/**
 * Base interface for adaptation of an {@link SearchPaginationParameters}.
 * <br><br>
 * Instances should focus on the adaptation of the {@link SearchPaginationParameters}
 * to the Target class defined in the class generics.
 * <br><br>
 * The Target class is the object that another layer can work with.
 * Eg. Spring cannot understand {@link SearchPaginationParameters}, so we need to adapt to an
 * Pageable class instance.
 * <br><br>
 * More information on the <a href="http://www.tutorialspoint.com/design_pattern/adapter_pattern.htm">Adapter Design Pattern</a>.
 *
 * @param <P> Class of the Search Pagination Parameters
 * @param <AP> Class of the Adapted Type; The output of the adapter.
 *
 * @see SearchPaginationParameters
 *
 */
public interface SearchPaginationParametersAdapter<P extends SearchPaginationParameters, AP> {

	/**
	 * Adapts from {@link SearchPaginationParameters} to an Target type defined
	 * by class generics.
	 *
	 * @param searchPaginationParameters the instance to be adapted
	 * @return Empty Optional if parameter is empty OR cannot be adapted; Optional Containing the adapted object otherwise.
	 *
	 */
	Optional<AP> adaptPagination(P searchPaginationParameters);

}
