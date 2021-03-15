package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Abstraction for {@link SearchSortKeyAdapter} implementations that are backed by a {@link Map}.
 * <br><br>
 * Implementations should just specify HOW the adapter does his work by implementing {@link #getAvailableSearchSortKeysStream()}.
 *
 * @see SearchSortKey
 * @see SearchSortKeyAdapter
 * @see AbstractSortKeyAdapter
 * @see AbstractEnumBackedSearchSortKeyAdapter
 */
public abstract class AbstractMapBackedSearchSortKeyAdapter
        extends AbstractSortKeyAdapter
        implements SearchSortKeyAdapter {

    private Map<String, SearchSortKey> sortKeyCodeToSortKeyInstanceMap;

    @Override
    protected final Optional<SearchSortKey> discoverSearchSortKey(String code) {
        Map<String, SearchSortKey> map = this.getPopulatedSearchSortKeysMap();
        SearchSortKey searchSortKey = map.get(code);
        return Optional.ofNullable(searchSortKey);
    }

    private Map<String, SearchSortKey> getPopulatedSearchSortKeysMap() {
        if(Objects.isNull(this.sortKeyCodeToSortKeyInstanceMap)){
            this.sortKeyCodeToSortKeyInstanceMap = this.generateSearchSortKeyCodeToSortKeyInstanceMap();
        }

        return this.sortKeyCodeToSortKeyInstanceMap;
    }

    /**
     * Generates the adapter internal {@link Map} of {@link SearchSortKey#getCode()} to {@link SearchSortKey}.
     *
     * @return map relating search sort keys from its codes.
     */
    protected final Map<String, SearchSortKey> generateSearchSortKeyCodeToSortKeyInstanceMap() {
        return this.getAvailableSearchSortKeysStream()
            .collect(Collectors.toMap(
                SearchSortKey::getCode,
                Function.identity()
            ));
    }

    /**
     * Defines available {@link SearchSortKey} for this adapter.
     *
     * @return available search sort keys.
     */
    protected abstract Stream<SearchSortKey> getAvailableSearchSortKeysStream();

}
