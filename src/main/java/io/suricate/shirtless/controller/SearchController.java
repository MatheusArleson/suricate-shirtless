package io.suricate.shirtless.controller;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.SearchService;

import java.util.List;
import java.util.Map;

/**
 * Base interface for Search Controllers.
 * <p>
 * Instances will have methods to cover most of search use cases out of the box.
 * <p>
 * Search Controller uses the concept of <b>Generics.</b>
 * In other words, implementations can vary the actual type of each aspect (filter, pagination and sort)
 * as long as the base interfaces are implemented by the custom objects.
 * <p>
 * Search Controller delegates operations - by default - to the Search Service Class provided on generics.
 *
 * @param <O> Output Class of Search Results
 * @param <F> Filter Class of Search Parameters
 * @param <P> Pagination Class of Search Parameters
 * @param <S> Sort Class of Search Parameters
 * @param <SP> Sort Parameter Class
 * @param <SV> Search Service Class
 *
 */
public interface SearchController<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F,P,S>,
			SV extends SearchService<O, F, P, S, SP>
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
	 */
	Long count(SP searchParameters);

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
	 */
	List<O> search(SP searchParameters);

	/**
	 * Exposes the model of the Search Filter Parameters in key-value format.
	 * <p>
	 * This method allows introspection of the available filter by clients.
	 * Eg. A Client that never used the API should be able to get information about the available filter parameters.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> filterMetaModel();

	/**
	 * Exposes the model of the Search Pagination Parameters in key-value format.
	 * <p>
	 * This method allows introspection of the available pagination by clients.
	 * Eg. A Client that never used the API should be able to get information about the available pagination parameters.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> paginationMetaModel();

	/**
	 * Exposes the model of the Search Sort Parameters in key-value format.
	 * <p>
	 * This method allows introspection of the available sort by clients.
	 * Eg. A Client that never used the API should be able to get information about the available sort parameters.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> sortMetaModel();

}
