package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base abstraction for Search Parameters implementations.
 * <br/><br/>
 * Extensions of this class can add behaviour
 * while keeping the interface contract intact.
 * <br/><br/>
 * <b>Note about constructors:</b> If Dependency Injection is used,
 * the No-Args constructor <b>SHOULD</b> be visible on the implementation.
 * This is due to construction/initialization on Dependency Inversion Frameworks
 * AND/OR Serialization usually happens after an Instance is created.
 *
 * @see SearchParameters
 * @see AbstractDefaultSearchParameters
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractSearchParameters<
			F extends SearchFilterParameters,
			P extends SearchPaginationParameters,
			S extends SearchSortParameters
		> implements SearchParameters<F, P, S> {

	private F filterParameters;
	private P paginationParameters;
	private S sortParameters;

}
