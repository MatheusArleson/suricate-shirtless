package io.suricate.shirtless.model.parameter.pagination;

import io.suricate.shirtless.model.parameter.SearchParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base abstraction for Search Pagination Parameters implementations.
 * <br><br>
 * Extensions of this class can add behaviour
 * while keeping the interface contract intact.
 * <br><br>
 * <b>Note about constructors:</b> If Dependency Injection is used,
 * the No-Args constructor <b>SHOULD</b> be visible on the implementation.
 * This is due to construction/initialization on Dependency Inversion Frameworks
 * AND/OR Serialization usually happens after an Instance is created.
 *
 * @see SearchPaginationParameters
 * @see DefaultSearchPaginationParameters
 * @see SearchParameters
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractSearchPaginationParameters
		implements SearchPaginationParameters {

	private Integer pageNumber;
	private Integer pageSize;

}
