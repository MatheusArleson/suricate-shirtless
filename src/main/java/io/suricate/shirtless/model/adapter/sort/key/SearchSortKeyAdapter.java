package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;

import java.util.Optional;

/**
 * Base interface for adaptation of {@link SearchSortParameters#getSortCodes()} into know {@link SearchSortKey} instances.
 * <br><br>
 * <b>Example:</b> User wants to sort books by title. <br>
 * Sort parameters should have the code for book tile, eg. 'bt' as element on {@link SearchSortParameters#getSortCodes()}.
 * Implementation will then adapt the code to the know instance of the {@link SearchSortKey} that represents such intention.
 *
 * @see SearchSortKey
 */
public interface SearchSortKeyAdapter {

	/**
	 * Adapts an sort code to an {@link SearchSortKey}.
	 *
	 * @param code the instance to be adapted
	 * @return Empty Optional if the code is unknown OR cannot be adapted; Optional Containing the adapted object otherwise.
	 *
	 */
	Optional<SearchSortKey> adaptSortKeyCode(String code);

}
