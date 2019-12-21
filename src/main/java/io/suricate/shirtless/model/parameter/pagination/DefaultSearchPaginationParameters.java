package io.suricate.shirtless.model.parameter.pagination;

import io.suricate.shirtless.model.parameter.SearchParameters;

/**
 * Default Implementation of Search Pagination Parameters.
 * <p>
 * This implementation aims to provide less generics overhead downstream,
 * while covering the most common cases.
 *
 * @see SearchPaginationParameters
 * @see AbstractSearchPaginationParameters
 * @see SearchParameters
 */
public class DefaultSearchPaginationParameters
		extends AbstractSearchPaginationParameters
		implements SearchPaginationParameters {

	/**
	 * No args constructor.
	 * Important in case of Dependency Injection or Serialization.
	 */
	public DefaultSearchPaginationParameters() {
		super();
	}

	/**
	 * All args constructor.
	 *
	 * @param pageNumber Value for the Page Number
	 * @param pageSize Value for the Page Size
	 */
	public DefaultSearchPaginationParameters(Integer pageNumber, Integer pageSize) {
		super(pageNumber, pageSize);
	}

	/**
	 * Static factory method for an empty instance.
	 *
	 * @return An empty instance (no parameters)
	 */
	public static DefaultSearchPaginationParameters empty() {
		return new DefaultSearchPaginationParameters();
	}

	/**
	 * Static factory method for an all args instance.
	 *
	 * @return An filled instance (all parameters).
	 */
	public static DefaultSearchPaginationParameters all() {
		return new DefaultSearchPaginationParameters(0, Integer.MAX_VALUE);
	}

	/**
	 * Static factory method for an all args instance.
	 *
	 * @param pageNumber Value for the Page Number
	 * @param pageSize Value for the Page Size
	 * @return An filled instance (all parameters).
	 */
	public static DefaultSearchPaginationParameters with(Integer pageNumber, Integer pageSize) {
		return new DefaultSearchPaginationParameters(pageNumber, pageSize);
	}



}
