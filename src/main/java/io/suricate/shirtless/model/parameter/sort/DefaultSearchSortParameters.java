package io.suricate.shirtless.model.parameter.sort;

import io.suricate.shirtless.model.parameter.SearchParameters;

/**
 * Default Implementation of Search Sort Parameters.
 * <br/><br/>
 * This implementation aims to provide less generics overhead downstream,
 * while covering the most common cases.
 *
 * @see SearchSortParameters
 * @see AbstractSearchSortParameters
 * @see SearchParameters
 */
public class DefaultSearchSortParameters
		extends AbstractSearchSortParameters
		implements SearchSortParameters {

	/**
	 * No args constructor. <br/>
	 * Important in case of Dependency Injection or Serialization.
	 */
	public DefaultSearchSortParameters() {
	}

	/**
	 * All args constructor.
	 *
	 * @param sortCodes Values of Sort Codes
	 * @param sortDirections Values of Sort directions
	 */
	public DefaultSearchSortParameters(String[] sortCodes, String[] sortDirections) {
		super(sortCodes, sortDirections);
	}

	/**
	 * Static factory method for an empty instance.
	 *
	 * @return An empty instance (no parameters)
	 */
	public static DefaultSearchSortParameters empty() {
		return new DefaultSearchSortParameters();
	}

	/**
	 * Static factory method for an all args instance.
	 *
	 * @return An filled instance (all parameters).
	 */
	public static DefaultSearchSortParameters with(String[] sortCodes, String[] sortDirections) {
		return new DefaultSearchSortParameters(sortCodes, sortDirections);
	}

}
