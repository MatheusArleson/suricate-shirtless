package io.suricate.shirtless.service;

import io.suricate.shirtless.exceptions.search.parameters.*;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;

import java.util.List;
import java.util.Map;

/**
 * Base interface for Search Services.
 * <p>
 * Instances will provide to upstream a single point for all search related functionality.
 * <p>
 * Search Service uses the concept of <b>Generics.</b> <br>
 * In other words, implementations can vary the actual type of each aspect
 * as long as the base interfaces are implemented by the custom objects.
 * <p>
 *
 * @param <O> Output Class of Search Results
 * @param <F> Filter Class of Search Parameters
 * @param <P> Pagination Class of Search Parameters
 * @param <S> Sort Class of Search Parameters
 * @param <SP> Sort Parameter Class
 *
 */
public interface SearchService<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> {

	/**
	 * Expose the total number of Search Results Possible.
	 * <p>
	 * For this method, does not make sense to pass any parameters.
	 *
	 * @return the total number of Search Results possible.
	 */
	Long total();

	/**
	 * Counts the number of Search Results that match the Search Parameters.
	 * <p>
	 * For this method, only the filter aspect of the Search Parameters is important.
	 * Other aspects, pagination/sorting, should not be considered.
	 *
	 * @param searchParameters an Search Parameters to be used.
	 * @return the total number of Search Results that match the Search Parameters.
	 * @throws EmptyParameterNotAllowedException In case emptiness is detected and its not allowed by this service.
	 */
	Long count(SP searchParameters) throws EmptyParameterNotAllowedException;

	/**
	 * Gets the Search Results that match the Search Parameters.
	 * <p>
	 * For this method, all aspects of the Search Parameters should be evaluated.
	 * <p>
	 * The type of the Search Results are defined be the generic parameter of this interface.
	 * Allowing implementations to pass any desired class.
	 *
	 * @param searchParameters an Search Parameters to be used.
	 * @return {@link List} of Search Results.
	 * @throws EmptyParameterNotAllowedException In case emptiness is detected and its not allowed by this service.
	 */
	List<O> search(SP searchParameters) throws EmptyParameterNotAllowedException;

	/**
	 * Exposes the model of the Search Filter Parameters in key-value format.
	 * <p>
	 * This method provides the meta model of the search filter parameters for upstream. <br>
	 * Eg. A Controller can ask for the service to provide the meta model information.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> filterMetaModel();

	/**
	 * Exposes the model of the Search Pagination Parameters in key-value format.
	 * <p>
	 * This method provides the meta model of the search pagination parameters for upstream. <br>
	 * Eg. A Controller can ask for the service to provide the meta model information.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> paginationMetaModel();

	/**
	 * Exposes the model of the Search Sort Parameters in key-value format.
	 * <p>
	 * This method provides the meta model of the search sort parameters for upstream. <br>
	 * Eg. A Controller can ask for the service to provide the meta model information.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> sortMetaModel();

	boolean isSearchWithEmptySearchParametersAllowed();

	SP getFallbackSearchParametersInstance();

	boolean isSearchWithEmptySearchFilterParametersAllowed();

	F getFallbackSearchFilterParametersInstance();

	boolean isSearchWithEmptySearchPaginationParametersAllowed();

	P getFallbackSearchPaginationParametersInstance();

	boolean isSearchWithEmptySearchSortParametersAllowed();

	S getFallbackSearchSortParametersInstance();

}
