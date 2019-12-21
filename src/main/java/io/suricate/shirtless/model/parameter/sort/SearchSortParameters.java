package io.suricate.shirtless.model.parameter.sort;

import java.util.Objects;

/**
 * Base interface for Sort Parameters of an Search.
 * <p>
 * Instances will hold values to be used on the Sort of the Search itself.
 * <p>
 * Sorting has a concept of <b>codes</b>. <br>
 * In other words, the sort values require translation
 * from the code to the values itself (indirection). <br>
 * <b>Example:</b> User wants to sort books by title. <br>
 * Sort parameters should have the code for book tile, eg. 'bt'
 * <p>
 * Sorting has a concept of <b>directions</b>. <br>
 * In other words, the sort values require an direction to be
 * applied, usually <i>ascending</i> or <i>descending</i>. <br>
 * <b>Example:</b> User wants to sort books by title, ascending. <br>
 * Sort parameters should have the code for ascending, eg 'asc'
 * <p>
 * Sorting has a concept of <b>index sliding column</b>. <br>
 * In other words, a single sort will be processed using the same
 * index of both arrays (like a sliding column). <br>
 * <b>Example:</b> The first sort will processed on index 0 of both <b>codes and directions</b>.
 * <p>
 * Design decision note: Why arrays?
 * <p>
 * This is due to the way HTTP GET query string works. https://tools.ietf.org/html/rfc3986 <br>
 * If a parameter is a list, the same parameter will be repeat
 * over and over in the order that it was sent. <br>
 * <i>/search?sort.code=foo%26sort.code=bar </i> <br>
 * Complex objects here requires serialization that is
 * outside of the scope of this code. <br>
 * To maximize compatibility, using separate arrays fits nicely on HTTP itself,
 * requiring the minimum serialization possible.
 *
 */
public interface SearchSortParameters {

	/**
	 * Gets the values of Sort Codes.
	 * Codes will be evaluated and
	 * translated to values to be used on the Search.
	 *
	 * @return Sort Codes values.
	 */
	String[] getSortCodes();

	/**
	 * Sets the values of Sort Codes.
	 * Codes will be evaluated and
	 * translated to values to be used on the Search.
	 *
	 * @param sortCodes Sort Codes values.
	 */
	void setSortCodes(String[] sortCodes);

	/**
	 * Gets the values of Sort Directions.
	 * Directions will be evaluated and
	 * translated to values to be used on the Search.
	 *
	 * @return Sort Directions values.
	 */
	String[] getSortDirections();

	/**
	 * Sets the values of Sort Directions.
	 * Directions will be evaluated and
	 * translated to values to be used on the Search.
	 *
	 * @param sortDirections Sort Directions values.
	 */
	void setSortDirections(String[] sortDirections);

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
	 * @see #isNotNull(SearchSortParameters)
	 */
	static boolean isNull(SearchSortParameters parameters) {
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
	 * @see #isNull(SearchSortParameters)
	 */
	static boolean isNotNull(SearchSortParameters parameters) {
		return !isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Empty</b>.
	 * <p>
	 * Is Empty if both codes and directions arrays: <br>
	 * - are null or empty. <br>
	 * - have different sizes. <br>
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
	 * @see #isNotEmpty(SearchSortParameters)
	 * @see #setSortCodes(String[])
	 * @see #setSortDirections(String[])
	 */
	static boolean isEmpty(SearchSortParameters parameters) {
		if (isNull(parameters)) {
			return Boolean.TRUE;
		} else {
			String[] sortCodes = parameters.getSortCodes();
			String[] sortDirections = parameters.getSortDirections();
			return Objects.isNull(sortCodes)
				|| Objects.isNull(sortDirections)
				|| sortCodes.length != sortDirections.length;
		}
	}

	/**
	 * Checks if an instance of this interface is <b>Not Empty</b>.
	 * <p>
	 * Is not Empty if both codes and directions arrays: <br>
	 * - are not null and not empty. <br>
	 * - have same sizes <br>
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
	 * @see #isEmpty(SearchSortParameters)
	 * @see #setSortCodes(String[])
	 * @see #setSortDirections(String[])
	 */
	static boolean isNotEmpty(SearchSortParameters parameters) {
		return !isEmpty(parameters);
	}

}
