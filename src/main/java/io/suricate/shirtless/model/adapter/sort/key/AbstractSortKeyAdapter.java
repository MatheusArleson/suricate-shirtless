package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;

import java.util.Objects;
import java.util.Optional;

/**
 * Base abstraction for {@link SearchSortKeyAdapter} implementations.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #discoverSearchSortKey(String)}.\
 *
 * @see SearchSortKey
 * @see SearchSortKeyAdapter
 * @see AbstractMapBackedSearchSortKeyAdapter
 * @see AbstractEnumBackedSearchSortKeyAdapter
 */
public abstract class AbstractSortKeyAdapter
        implements SearchSortKeyAdapter {

    @Override
    public final Optional<SearchSortKey> adaptSortKeyCode(String code) {
        if (Objects.isNull(code) || code.isEmpty()) {
            return Optional.empty();
        } else {
            return this.discoverSearchSortKey(code);
        }
    }

    /**
     * Discovers which {@link SearchSortKey} is represented by {@code code} argument.
     *
     * @param code contains the code to match to one {@link SearchSortKey#getCode()} value.
     * @return Empty Optional if the code is unknown OR cannot be adapted; Optional Containing the adapted object otherwise.
     */
    protected abstract Optional<SearchSortKey> discoverSearchSortKey(String code);

}
