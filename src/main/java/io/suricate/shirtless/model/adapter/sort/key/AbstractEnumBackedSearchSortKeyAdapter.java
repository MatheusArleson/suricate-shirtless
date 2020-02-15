package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import io.suricate.shirtless.util.reflection.GenericsUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class AbstractEnumBackedSearchSortKeyAdapter<
			T extends Enum<? extends SearchSortKey> & SearchSortKey
		> implements SearchSortKeyAdapter {

	private static final int ENUM_CLASS_GENERICS_INDEX = 0;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private Map<String, SearchSortKey> codeToEnumMemberMap;

	@Override
	public Optional<SearchSortKey> adaptSortKeyCode(String code) {
		if (Objects.isNull(code) || code.isEmpty()) {
			return Optional.empty();
		} else {
			SearchSortKey enumMemberWithSameCode = this.getEnumMemberWithSameCode(code);
			return Optional.ofNullable(enumMemberWithSameCode);
		}
	}

	private SearchSortKey getEnumMemberWithSameCode(String code) {
		Map<String, SearchSortKey> codeToEnumMemberMap = this.getCodeToEnumMemberMap();
		return codeToEnumMemberMap.get(code);
	}

	private Map<String, SearchSortKey> getCodeToEnumMemberMap() {
		if (Objects.isNull(this.codeToEnumMemberMap)) {
			SearchSortKey[] enumMembers = this.getAllEnumMembers();
			Map<String, SearchSortKey> map = Arrays.stream(enumMembers).collect(Collectors.toMap(
					SearchSortKey::getCode,
					(searchSortKey -> searchSortKey)
			));

			this.codeToEnumMemberMap = map;
		}

		return this.codeToEnumMemberMap;
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
