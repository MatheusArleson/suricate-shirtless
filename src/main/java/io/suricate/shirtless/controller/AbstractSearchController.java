package io.suricate.shirtless.controller;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.SearchService;
import lombok.*;

import java.util.Collection;
import java.util.Map;

/**
 * Base abstraction for Search Controller implementations.
 * <br/><br/>
 * Extensions of this class can add behaviour
 * while keeping the interface contract intact.
 * <br/><br/>
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

	@Getter(AccessLevel.PROTECTED)
	@Setter(AccessLevel.NONE)
	@NonNull
	private SV searchService;

	@Override
	public Long total() {
		return this.getSearchService().total();
	}

	@Override
	public Long count(SP searchParameters) {
		return this.getSearchService().count(searchParameters);
	}

	@Override
	public Collection<O> search(SP searchParameters) {
		return this.getSearchService().search(searchParameters);
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
