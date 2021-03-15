package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import io.suricate.shirtless.util.reflection.GenericsUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Abstraction for {@link SearchSortKeyAdapter} implementations that are backed by a {@link Enum}.
 * <br><br>
 * Implementations should just specify the Enum target class in the generics.
 * <br><br>
 * NOTE: In order for the Enum to honor the generic contract, make the enum implement {@link SearchSortKey}.
 *
 * @see SearchSortKey
 * @see SearchSortKeyAdapter
 * @see AbstractSortKeyAdapter
 * @see AbstractMapBackedSearchSortKeyAdapter
 *
 * @param <E> Class of the Enum that will back this adapter.
 */
@RequiredArgsConstructor
public abstract class AbstractEnumBackedSearchSortKeyAdapter<
			E extends Enum<? extends SearchSortKey> & SearchSortKey
		> extends AbstractMapBackedSearchSortKeyAdapter {

	private static final int ENUM_CLASS_GENERICS_INDEX = 0;

	@Override
	protected Stream<SearchSortKey> getAvailableSearchSortKeysStream() {
		SearchSortKey[] enumMembers = this.getAllEnumMembers();
		return Stream.of(enumMembers);
	}

	private SearchSortKey[] getAllEnumMembers() {
		Optional<SearchSortKey[]> enumMembersOpt = GenericsUtils.getAllEnumMembers(this.getClass(), ENUM_CLASS_GENERICS_INDEX);
		SearchSortKey[] enumMembers = enumMembersOpt.orElse(null);

		if (Objects.nonNull(enumMembers) && enumMembers.length > 0) {
			return enumMembers;
		} else {
			throw new IllegalStateException("Unable to get enum members from class on generics.");
		}
	}

}
