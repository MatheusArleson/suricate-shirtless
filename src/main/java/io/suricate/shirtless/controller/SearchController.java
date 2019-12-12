package io.suricate.shirtless.controller;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.SearchService;

import java.util.Collection;
import java.util.Map;

/**
 * Base interface for Search Controllers.
 * <br/><br/>
 * Instances will have methods to cover most of search use cases out of the box. <br/>
 * Search Controller uses the concept of <b>Generics.</b> <br/>
 * In other words, implementations can vary the actual type of each aspect (filter, pagination and sort)
 * as long as the base interfaces are implemented by the custom objects.
 * <br/><br/>
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
	 * <br/><br/>
	 * For this method, does not make sense to pass any parameters.
	 *
	 * @return the total number of Search Results possible.
	 */
	Long total();

	/**
	 * Counts the number of Search Results that match the Search Parameters.
	 * <br/><br/>
	 * For this method, only the filter aspect of the Search Parameters is important. <br/>
	 * Other aspects, pagination/sorting, should not be considered.
	 *
	 * @return the total number of Search Results that match the Search Parameters.
	 */
	Long count(SP searchParameters);

	/**
	 * Gets the Search Results that match the Search Parameters.
	 * <br/><br/>
	 * For this method, all aspects of the Search Parameters should be evaluated. <br/>
	 * <br/><br/>
	 * The type of the Search Results are defined be the generic parameter of this interface. <br/>
	 * Allowing implementations to pass any desired class.
	 *
	 * @param searchParameters an Search Parameters to be used.
	 * @return {@link Collection} of Search Results.
	 */
	Collection<O> search(SP searchParameters);

	/**
	 * Exposes the model of the Search Filter Parameters in key-value format.
	 * <br/><br/>
	 * This method allows introspection of the available filter by clients. <br/>
	 * Eg. A Client that never used the API should be able to get information about the available filter parameters.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> filterMetaModel();

	/**
	 * Exposes the model of the Search Pagination Parameters in key-value format.
	 * <br/><br/>
	 * This method allows introspection of the available pagination by clients. <br/>
	 * Eg. A Client that never used the API should be able to get information about the available pagination parameters.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> paginationMetaModel();

	/**
	 * Exposes the model of the Search Sort Parameters in key-value format.
	 * <br/><br/>
	 * This method allows introspection of the available sort by clients. <br/>
	 * Eg. A Client that never used the API should be able to get information about the available sort parameters.
	 *
	 * @return {@link Map} of parameter name to parameter description.
	 */
	Map<String, String> sortMetaModel();

}
