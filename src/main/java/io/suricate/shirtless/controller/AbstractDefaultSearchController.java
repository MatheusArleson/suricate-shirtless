package io.suricate.shirtless.controller;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import io.suricate.shirtless.service.SearchService;
import lombok.NonNull;

/**
 * Abstraction of Search Controller using default implementations for Pagination and Sorting.
 * <br/><br/>
 * Extensions of this class will focus on the definition of the remaining Classes to be used,
 * leveraging the existent default implementation for pagination and sorting.
 * <br/><br/>
 *
 * @param <O> Output Class of Search Results
 * @param <F> Filter Class of Search Parameters
 * @param <SP> Sort Parameter Class
 * @param <SV> Search Service Class
 */
public abstract class AbstractDefaultSearchController<
			O,
			F extends SearchFilterParameters,
			SP extends SearchParameters<F, DefaultSearchPaginationParameters, DefaultSearchSortParameters>,
			SV extends SearchService<O, F, DefaultSearchPaginationParameters, DefaultSearchSortParameters, SP>
		> extends AbstractSearchController<
			O,
			F,
			DefaultSearchPaginationParameters,
			DefaultSearchSortParameters,
			SP,
			SV
		> {

	/**
	 * All args constructor.
	 * <br/><br/>
	 * Creates a instance of Search Controller with an Search Service.
	 *
	 * @param searchService an {@link SearchService} to be used by the Controller. Cannot be null.
	 */
	public AbstractDefaultSearchController(@NonNull SV searchService) {
		super(searchService);
	}

}
