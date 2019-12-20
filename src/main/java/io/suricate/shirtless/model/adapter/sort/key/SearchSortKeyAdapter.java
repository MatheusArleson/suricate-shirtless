package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;

import java.util.Optional;

public interface SearchSortKeyAdapter {

	Optional<SearchSortKey> adaptSortKeyCode(String code);

}
