package io.suricate.shirtless.model.parameter.pagination;

import io.suricate.shirtless.model.parameter.SearchParameters;

import java.util.Objects;

/**
 * Base interface for Pagination Parameters of an Search.
 * <br/><br/>
 * Instances will hold the values of pagination be used on the Search itself.
 * <br/><br/>
 * Pagination has a concept of Page, and requests can be done
 * for a specific page of an specific size. <br/>
 * Offsets can be achieved by adjusting both page properties.
 * <br/><br/>
 * <b>Example:</b> A request for the 10th record can be done as:
 * Page 1 of Size 10 <br/>
 * OR Page 2 of size 5 <br/>
 * OR Page 10 of Size 1.
 *
 * @see AbstractSearchPaginationParameters
 * @see DefaultSearchPaginationParameters
 * @see SearchParameters
 */
public interface SearchPaginationParameters {

	/**
	 * Gets the value of Page Number property.
	 *
	 * @return Page Number value
	 */
	Integer getPageNumber();


	/**
	 * Sets the value of Page Number property.
	 *
	 * @param pageNumber New value for Page Number.
	 */
	void setPageNumber(Integer pageNumber);

	/**
	 * Gets the value of Page Size property.
	 *
	 * @return Page Size value
	 */
	Integer getPageSize();

	/**
	 * Sets the value of Page Size property.
	 *
	 * @param pageSize New value for Page Size.
	 */
	void setPageSize(Integer pageSize);

	/**
	 * Checks if an instance of this interface is <b>Null</b>.
	 * <br/><br/>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br/><br/>
	 * Example:
	 * Null/Empty pagination parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Null, False if Not Null.
	 *
	 * @see #isNotNull(SearchPaginationParameters)
	 */
	static boolean isNull(SearchPaginationParameters parameters) {
		return Objects.isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Not Null</b>.
	 * <br/><br/>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br/><br/>
	 * Example:
	 * Null/Empty pagination parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Not Null, False if Null.
	 *
	 * @see #isNull(SearchPaginationParameters)
	 */
	static boolean isNotNull(SearchPaginationParameters parameters) {
		return !isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Empty</b>.
	 * <br/><br/>
	 * Is Empty if at least one of the Pagination Parameters is null.
	 * <br/><br/>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br/><br/>
	 * Example:
	 * Null/Empty pagination parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Empty, False if Not Empty.
	 *
	 * @see #isNotEmpty(SearchPaginationParameters)
	 * @see #setPageNumber(Integer)
	 * @see #setPageSize(Integer)
	 */
	static boolean isEmpty(SearchPaginationParameters parameters) {
		return isNull(parameters) || (
			Objects.isNull(parameters.getPageNumber())
			|| Objects.isNull(parameters.getPageSize())
		);
	}

	/**
	 * Checks if an instance of this interface is <b>Not Empty</b>.
	 * <br/><br/>
	 * Is Not Empty if all of the Pagination Parameters is not null and have values.
	 * <br/><br/>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br/><br/>
	 * Example:
	 * Null/Empty pagination parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Not Empty, False if Empty.
	 *
	 * @see #isEmpty(SearchPaginationParameters)
	 * @see #setPageNumber(Integer)
	 * @see #setPageSize(Integer)
	 */
	static boolean isNotEmpty(SearchPaginationParameters parameters) {
		return !isEmpty(parameters);
	}

}
