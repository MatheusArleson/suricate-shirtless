package io.suricate.shirtless.controller;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.SearchService;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Base abstraction for Search Controller implementations.
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
 * @param <SV> Search Service Class
 */
@AllArgsConstructor
public abstract class AbstractSearchController<
			O,
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters,
			SP extends SearchParameters<F, P, S>,
			SV extends SearchService<O, F, P, S, SP>
		> implements SearchController<O, F, P, S, SP, SV> {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	/**
	 * The service that will perform the search operation and provide data to the controller.
	 * <p>
	 *
	 * @see SearchService
	 */
	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.NONE)
	@NonNull
	private SV searchService;

	@Override
	public Long total() {
		LOGGER.debug("Executing: total operation.");

		Long total = this.getSearchService().total();

		LOGGER.debug("Return: " + total);
		return total;
	}

	@Override
	public Long count(SP searchParameters) {
		LOGGER.debug("Executing: count operation.");
		LOGGER.debug("Arguments: " + (Objects.nonNull(searchParameters) ? searchParameters.toString() : "null"));

		Long count = this.getSearchService().count(searchParameters);

		LOGGER.debug("Return: " + count);
		return count;
	}

	@Override
	public List<O> search(SP searchParameters) {
		LOGGER.debug("Executing count operation.");
		LOGGER.debug("Arguments: " + (Objects.nonNull(searchParameters) ? searchParameters.toString() : "null"));

		List<O> searchResults = this.getSearchService().search(searchParameters);

		LOGGER.debug("Return: " + searchResults);
		return searchResults;
	}

	@Override
	public Map<String, String> filterMetaModel() {
		return this.getSearchService().filterMetaModel();
	}

	@Override
	public Map<String, String> paginationMetaModel() {
		return this.getSearchService().paginationMetaModel();
	}

	@Override
	public Map<String, String> sortMetaModel() {
		return this.getSearchService().sortMetaModel();
	}
}
