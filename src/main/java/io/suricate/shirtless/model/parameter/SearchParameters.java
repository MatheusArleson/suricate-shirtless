package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.Objects;

/**
 * Base interface for Search Parameters.
 * <p>
 * Instances will hold filter, pagination and sort information to be used on the Search.
 * <p>
 * Search parameters uses the concept of <b>Generics.</b>
 * In other words, implementations can vary the actual type of each aspect (filter, pagination and sort)
 * as long as the base interfaces are implemented by the custom objects.
 * <p>
 * Search parameters has the concept of <b>ignore</b>.
 * If any parameter is null, it means that search parameter does not want that aspect to be used.
 * Implementations should not forbid null parameters to be passed. Consumers of the Search Parameters instance are
 * the ones responsible for defining if a particular instance is acceptable of not.
 * Eg. If sort parameters are null, means that search should not be sorted.
 * Eg. If service A accepts empty sorting, than it should accept a search with null sort parameters.
 * <p>
 *
 * @param <F> Type of the Filter - Anything that extends {@link SearchFilterParameters}
 * @param <P> Type of the Pagination - Anything that extends {@link SearchPaginationParameters}
 * @param <S> Type of the Sort - Anything that extends {@link SearchSortParameters}
 *
 * @see AbstractSearchParameters
 * @see AbstractDefaultSearchParameters
 * @see SearchFilterParameters
 * @see SearchPaginationParameters
 * @see SearchSortParameters
 *
 */
public interface SearchParameters<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters
		> {

	/**
	 * Gets the instance of Filter Parameters to be used on this Search Parameters.
	 * Null value means that Search should not consider filtering.
	 *
	 * @return the current Filter Parameters.
	 */
	F getFilterParameters();

	/**
	 * Sets the instance of Filter Parameters to be used on this Search Parameters.
	 * Null value means that Search should not consider filtering.
	 *
	 * @param filterParameters an Filter Parameters instance.
	 */
	void setFilterParameters(F filterParameters);

	/**
	 * Gets the instance of Pagination Parameters to be used on this Search Parameters.
	 * Null value means that Search should not consider pagination.
	 *
	 * @return the current Pagination Parameters.
	 */
	P getPaginationParameters();

	/**
	 * Sets the instance of Pagination Parameters to be used on this Search Parameters.
	 * Null value means that Search should not consider pagination.
	 *
	 * @param paginationParameters an Pagination Parameters instance.
	 */
	void setPaginationParameters(P paginationParameters);

	/**
	 * Gets the instance of Sort Parameters to be used on this Search Parameters.
	 * Null value means that Search should not consider sorting.
	 *
	 * @return the current Sort Parameters.
	 */
	S getSortParameters();

	/**
	 * Sets the instance of Sort Parameters to be used on this Search Parameters.
	 * Null value means that Search should not consider sorting.
	 *
	 * @param sortParameters an Sort Parameters instance.
	 */
	void setSortParameters(S sortParameters);

	/**
	 * Checks if an instance of this interface is <b>Null</b>.
	 * <p>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <p>
	 * Example:
	 * Null/Empty sort parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Null, False if Not Null.
	 *
	 * @see #isNotNull(SearchParameters)
	 */
	static boolean isNull(SearchParameters parameters) {
		return Objects.isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Not Null</b>.
	 * <p>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <p>
	 * Example:
	 * Null/Empty sort parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Not Null, False if Null.
	 *
	 * @see #isNull(SearchParameters)
	 */
	static boolean isNotNull(SearchParameters parameters) {
		return !isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Empty</b>.
	 * <p>
	 * Is Empty if null OR all properties are null (filter, pagination, sort).
	 * <p>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <p>
	 * Example:
	 * Null/Empty sort parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Empty, False if Not Empty.
	 *
	 * @see #isNotEmpty(SearchParameters)
	 * @see #setFilterParameters(SearchFilterParameters)
	 * @see #setPaginationParameters(SearchPaginationParameters)
	 * @see #setSortParameters(SearchSortParameters)
	 * @see SearchFilterParameters#isEmpty(SearchFilterParameters)
	 * @see SearchPaginationParameters#isEmpty(SearchPaginationParameters)
	 * @see SearchSortParameters#isEmpty(SearchSortParameters)
	 *
	 */
	static boolean isEmpty(SearchParameters parameters) {
		return isNull(parameters) || (
			SearchFilterParameters.isEmpty(parameters.getFilterParameters())
			&& SearchPaginationParameters.isEmpty(parameters.getPaginationParameters())
			&& SearchSortParameters.isEmpty(parameters.getSortParameters())
		);
	}

	/**
	 * Checks if an instance of this interface is <b>Not Empty</b>.
	 * <p>
	 * Is Not Empty if not null OR one of properties are not null (filter, pagination, sort).
	 * <p>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <p>
	 * Example:
	 * Null/Empty sort parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Not Empty, False if Empty.
	 *
	 * @see #isNotEmpty(SearchParameters)
	 * @see #setFilterParameters(SearchFilterParameters)
	 * @see #setPaginationParameters(SearchPaginationParameters)
	 * @see #setSortParameters(SearchSortParameters)
	 * @see SearchFilterParameters#isEmpty(SearchFilterParameters)
	 * @see SearchPaginationParameters#isEmpty(SearchPaginationParameters)
	 * @see SearchSortParameters#isEmpty(SearchSortParameters)
	 *
	 */
	static boolean isNotEmpty(SearchParameters parameters) {
		return !isEmpty(parameters);
	}

}
