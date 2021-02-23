package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;

/**
 * Abstraction of Search Parameters using default implementations for Pagination and Sorting.
 * <br><br>
 * Extensions of this class will focus on the definition of the Search Filter Class to be used,
 * leveraging the existent default implementation for pagination and sorting.
 * <br><br>
 * <b>Note about constructors:</b> If Dependency Injection is used,
 * the No-Args constructor <b>SHOULD</b> be visible on the implementation.
 * This is due to construction/initialization on Dependency Inversion Frameworks
 * AND/OR Serialization usually happens after an Instance is created.
 *
 * @param <F> Defines the class of the Filter to be us the Search Parameter.
 *
 * @see SearchParameters
 * @see AbstractSearchParameters
 * @see DefaultSearchPaginationParameters
 * @see DefaultSearchSortParameters
 */
public abstract class AbstractDefaultSearchParameters<F extends SearchFilterParameters>
		extends AbstractSearchParameters<
			F,
			DefaultSearchPaginationParameters,
			DefaultSearchSortParameters
		> {

	/**
	 * No args constructor.
	 * All aspects are set to null (filter, pagination, sort), but can be set later.
	 *
	 */
	public AbstractDefaultSearchParameters() {
		super();
	}

	/**
	 * All args constructor.
	 * Provide way to set all/any parameter. Null values mean to ignore a particular aspect of the search.
	 *
	 * @param filterParameters an filter instance to be used.
	 * @param paginationParameters an pagination instance to be used.
	 * @param sortParameters an sort instance to be used.
	 */
	public AbstractDefaultSearchParameters(
		F filterParameters,
		DefaultSearchPaginationParameters paginationParameters,
		DefaultSearchSortParameters sortParameters
	) {
		super(filterParameters, paginationParameters, sortParameters);
	}
}
