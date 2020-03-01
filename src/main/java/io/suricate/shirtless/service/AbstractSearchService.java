package io.suricate.shirtless.service;

import io.suricate.shirtless.exceptions.search.parameters.*;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * Base abstraction for Search Service implementations.
 * <p>
 * Extensions of this class can add behaviour
 * while keeping the interface contract intact.
 * <p>
 * <b>Note about constructors:</b> If Dependency Injection is used,
 * the No-Args constructor <b>SHOULD</b> be visible on the implementation.
 * This is due to construction/initialization on Dependency Inversion Frameworks
 * AND/OR Serialization usually happens after an Instance is created.
 *
 * @param <O> Output Class of Search Results
 * @param <F> Filter Class of Search Parameters
 * @param <P> Pagination Class of Search Parameters
 * @param <S> Sort Class of Search Parameters
 * @param <SP> Sort Parameter Class
 */
@RequiredArgsConstructor
public abstract class AbstractSearchService<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>
		> implements SearchService<O, F, P, S, SP> {

	@Override
	public Long count(SP searchParameters) throws EmptyParameterNotAllowedException {
		SP safeSearchParameters = this.safeGetSearchParameters(searchParameters);
		F filterParameters = this.safeGetFilterParameters(safeSearchParameters);
		P paginationParameters = this.safeGetPaginationParameters(safeSearchParameters);
		S sortParameters = this.safeGetSortParameters(safeSearchParameters);

		return this.count(filterParameters, paginationParameters, sortParameters);
	}

	/**
	 * Counts the Search Results that match the Search Parameters - after emptiness on parameters is evaluated
	 * (and fallbacks are applied on them).
	 * <p>
	 * The type of the Filter/Pagination/Sort Parameters are defined be the generic parameter of this interface.
	 * Allowing implementations to pass any desired class.
	 *
	 * @param filterParameters filters of the search.
	 * @param paginationParameters pagination of the search.
	 * @param sortParameters sort of the search.
	 * @return Total number of Search Results that match the Search Parameters.
	 */
	protected abstract Long count(F filterParameters, P paginationParameters, S sortParameters);

	@Override
	public List<O> search(SP searchParameters) throws EmptyParameterNotAllowedException {
		SP safeSearchParameters = this.safeGetSearchParameters(searchParameters);
		F filterParameters = this.safeGetFilterParameters(safeSearchParameters);
		P paginationParameters = this.safeGetPaginationParameters(safeSearchParameters);
		S sortParameters = this.safeGetSortParameters(safeSearchParameters);

		return this.search(filterParameters, paginationParameters, sortParameters);
	}

	/**
	 * Gets the Search Results that match the Search Parameters - after emptiness on parameters is evaluated
	 * (and fallbacks are applied on them).
	 * <p>
	 * The type of the Filter/Pagination/Sort Parameters are defined be the generic parameter of this interface.
	 * Allowing implementations to pass any desired class.
	 *
	 * @param filterParameters filters of the search.
	 * @param paginationParameters pagination of the search.
	 * @param sortParameters sort of the search.
	 * @return {@link List} of Search Results.
	 */
	protected abstract List<O> search(F filterParameters, P paginationParameters, S sortParameters);

	/**
	 * Method responsible for the handling of whole search parameters passed for the search operation.
	 * <p>
	 * It introspects the search parameters for emptiness,
	 * checks if service allows it (applies fallback)
	 * or not (throws an exception).
	 *
	 * @param searchParameters parameters passed for the search operation.
	 * @return an instance of search parameters to perform the search.
	 *
	 * @throws EmptySearchParametersNotAllowed if empty search parameters are not allowed and either the passed parameter or fallback is empty.
	 */
	private SP safeGetSearchParameters(SP searchParameters) throws EmptySearchParametersNotAllowed {
		if (SearchParameters.isNotEmpty(searchParameters)) {
			return searchParameters;
		} else {
			boolean isEmptySearchParametersAllowed = this.isSearchWithEmptySearchParametersAllowed();
			if (isEmptySearchParametersAllowed) {
				SP fallback = this.getFallbackSearchParametersInstance();
				if(SearchParameters.isNotNull(fallback)){
					return fallback;
				} else {
					throw new EmptySearchParametersNotAllowed("Empty Fallback for Search with empty parameters is not allowed.");
				}
			} else {
				throw new EmptySearchParametersNotAllowed("Search with empty parameters is not allowed.");
			}
		}
	}

	/**
	 * Method responsible for the handling of filter parameters of the whole search parameters.
	 * <p>
	 * It introspects the search parameters filter property for emptiness,
	 * checks if service allows it (applies fallback)
	 * or not (throws an exception).
	 *
	 * @param searchParameters search parameters passed to search operation.
	 * @return an instance of filter parameters to perform the search.
	 *
	 * @throws EmptySearchFilterParametersNotAllowed if empty filter parameters are not allowed and either the passed parameter or fallback is empty.
	 */
	private F safeGetFilterParameters(SP searchParameters) throws EmptySearchFilterParametersNotAllowed {
		if(SearchFilterParameters.isNotEmpty(searchParameters.getFilterParameters()) ){
			return searchParameters.getFilterParameters();
		} else {
			boolean isEmptyFilterAllowed = this.isSearchWithEmptySearchFilterParametersAllowed();
			if (isEmptyFilterAllowed) {
				F fallback = this.getFallbackSearchFilterParametersInstance();
				if(SearchFilterParameters.isNotEmpty(fallback)){
					return fallback;
				} else {
					throw new EmptySearchFilterParametersNotAllowed("Null Fallback for Search with empty filter parameters is not allowed.");
				}
			} else {
				throw new EmptySearchFilterParametersNotAllowed("Search with empty filter parameters is not allowed.");
			}
		}
	}

	/**
	 * Method responsible for the handling of pagination parameters of the whole search parameters.
	 * <p>
	 * It introspects the search parameters pagination property for emptiness,
	 * checks if service allows it (applies fallback)
	 * or not (throws an exception).
	 *
	 * @param searchParameters search parameters passed to search operation.
	 * @return an instance of pagination parameters to perform the search.
	 *
	 * @throws EmptySearchPaginationParametersNotAllowed if empty pagination parameters are not allowed and either the passed parameter or fallback is empty.
	 */
	private P safeGetPaginationParameters(SP searchParameters) throws EmptySearchPaginationParametersNotAllowed {
		if (SearchPaginationParameters.isNotEmpty(searchParameters.getPaginationParameters())) {
			return searchParameters.getPaginationParameters();
		} else {
			boolean isEmptyPaginationAllowed = this.isSearchWithEmptySearchPaginationParametersAllowed();
			if (isEmptyPaginationAllowed) {
				P fallback = this.getFallbackSearchPaginationParametersInstance();
				if(SearchPaginationParameters.isNotEmpty(fallback)){
					return fallback;
				} else {
					throw new EmptySearchPaginationParametersNotAllowed("Empty fallback for empty pagination parameters is not allowed.");
				}
			} else {
				throw new EmptySearchPaginationParametersNotAllowed("Search with empty pagination parameters is not allowed.");
			}
		}
	}

	/**
	 * Method responsible for the handling of sort parameters of the whole search parameters.
	 * <p>
	 * It introspects the search parameters sort property for emptiness,
	 * checks if service allows it (applies fallback)
	 * or not (throws an exception).
	 *
	 * @param searchParameters search parameters passed to search operation.
	 * @return an instance of sort parameters to perform the search.
	 *
	 * @throws EmptySearchSortParametersNotAllowed if empty sort parameters are not allowed and either the passed parameter or fallback is empty.
	 */
	private S safeGetSortParameters(SP searchParameters) throws EmptySearchSortParametersNotAllowed {
		if (SearchSortParameters.isNotEmpty(searchParameters.getSortParameters())) {
			return searchParameters.getSortParameters();
		} else {
			boolean isEmptySortAllowed = this.isSearchWithEmptySearchSortParametersAllowed();
			if (isEmptySortAllowed) {
				S fallback = this.getFallbackSearchSortParametersInstance();
				if(SearchSortParameters.isNotEmpty(fallback)){
					return fallback;
				} else {
					throw new EmptySearchSortParametersNotAllowed("Empty fallback for Search with empty sort parameters is not allowed.");
				}
			} else {
				throw new EmptySearchSortParametersNotAllowed("Search with empty sort parameters is not allowed.");
			}
		}
	}
}
