package io.suricate.shirtless.model.parameter.filter;

import io.suricate.shirtless.model.parameter.SearchParameters;

import java.util.Objects;

/**
 * Base interface for Filter Parameters of an Search.
 * <br><br>
 * Instances will hold the values to be used on Filter of the Search itself.
 * <br><br>
 * Filtering has a concept of <b>Presence</b> of the filter values.
 * In other words, the filter values are what you want the Search Results <b>to have</b>.
 * <br><br>
 * Example: User wants books with "Java" in the title, filter should have this as a value of an property.
 *
 * @see SearchParameters
 */
public interface SearchFilterParameters {

	/**
	 * Checks if the filter is empty or not.
	 * <br><br>
	 * Emptiness is defined by the implementation.
	 * <br><br>
	 * In the simplest case, its a check if is
	 * there at least one Not Null valued property,
	 * OR a check if a set of mandatory properties are Not Null.
	 * <br><br>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br><br>
	 * Example:
	 * Null/Empty filter parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @return True if Empty, False if Not Empty.
	 *
	 * @see #isEmpty(SearchFilterParameters)
	 * @see #isNotEmpty(SearchFilterParameters)
	 */
	boolean isEmpty();

	/**
	 * Checks if an instance of this interface is <b>Null</b>.
	 * <br><br>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br><br>
	 * Example:
	 * Null/Empty filter parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Null, False if Not Null.
	 *
	 * @see #isNotNull(SearchFilterParameters)
	 */
	static boolean isNull(SearchFilterParameters parameters) {
		return Objects.isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Not Null</b>.
	 * <br><br>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br><br>
	 * Example:
	 * Null/Empty filter parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Not Null, False if Null.
	 *
	 * @see #isNull(SearchFilterParameters)
	 */
	static boolean isNotNull(SearchFilterParameters parameters) {
		return !isNull(parameters);
	}

	/**
	 * Checks if an instance of this interface is <b>Empty</b>.
	 * <br><br>
	 * Emptiness is defined by: a null value OR when {@link #isEmpty()} returns true.
	 * <br><br>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br><br>
	 * Example:
	 * Null/Empty filter parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Empty, False if Not Empty.
	 *
	 * @see #isNotEmpty(SearchFilterParameters)
	 */
	static boolean isEmpty(SearchFilterParameters parameters) {
		return isNull(parameters) || parameters.isEmpty();
	}

	/**
	 * Checks if an instance of this interface is <b>Not Empty</b>.
	 * <br><br>
	 * Emptiness is defined by: a null value OR when {@link #isEmpty()} returns true.
	 * <br><br>
	 * This is used internally to do checks before
	 * an actual search is performed.
	 * <br><br>
	 * Example:
	 * Null/Empty filter parameters can be refused
	 * OR a fallback default could be set.
	 *
	 * @param parameters Instance to be checked.
	 * @return True if Not Empty, False if Empty.
	 *
	 * @see #isEmpty(SearchFilterParameters)
	 */
	static boolean isNotEmpty(SearchFilterParameters parameters) {
		return !isEmpty(parameters);
	}

}
