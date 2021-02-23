package io.suricate.shirtless.model.parameter.sort;

import io.suricate.shirtless.model.parameter.SearchParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base abstraction for Search Sort Parameters implementation.
 * <br><br>
 * Extensions of this class can add behaviour while keeping
 * the interface contract intact.
 * <br><br>
 * <b>Note about constructors:</b> If Dependency Injection is used,
 * the No-Args constructor <b>SHOULD</b> be visible on the implementation.
 * This is due to construction/initialization on Dependency Inversion Frameworks
 * AND/OR Serialization usually happens after an Instance is created.
 *
 * @see SearchSortParameters
 * @see DefaultSearchSortParameters
 * @see SearchParameters
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractSearchSortParameters
		implements SearchSortParameters {

	private String[] sortCodes;
	private String[] sortDirections;

}
