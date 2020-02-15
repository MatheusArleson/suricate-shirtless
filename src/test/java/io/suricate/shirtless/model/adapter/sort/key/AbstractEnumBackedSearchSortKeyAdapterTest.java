package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractEnumBackedSearchSortKeyAdapterTest {

	private enum FixtureSortKeys implements SearchSortKey {
		SORT_KEY_1("aLabel", "aCode", "aValue");

		private String label;
		private String code;
		private String value;

		FixtureSortKeys(String label, String code, String value) {
			this.label = label;
			this.code = code;
			this.value = value;
		}

		@Override
		public String getLabel() {
			return label;
		}

		@Override
		public String getCode() {
			return code;
		}

		@Override
		public String getValue() {
			return value;
		}
	}

	private enum EmptyFixtureSortKeys implements SearchSortKey {
		;

		@Override
		public String getLabel() {
			return null;
		}

		@Override
		public String getCode() {
			return null;
		}

		@Override
		public String getValue() {
			return null;
		}
	}

	private AbstractEnumBackedSearchSortKeyAdapter<FixtureSortKeys> fixtureAdapter;
	private AbstractEnumBackedSearchSortKeyAdapter<EmptyFixtureSortKeys> fixtureAdapterWithEmptySortKeysEnum;
	private AbstractEnumBackedSearchSortKeyAdapter fixtureAdapterWithNoEnumGenerics;
	private AbstractEnumBackedSearchSortKeyAdapter mockedFixtureAdapter;

	@BeforeEach
	void setup(){
		fixtureAdapter = new AbstractEnumBackedSearchSortKeyAdapter<FixtureSortKeys>() {};
		fixtureAdapterWithEmptySortKeysEnum = new AbstractEnumBackedSearchSortKeyAdapter<EmptyFixtureSortKeys>() {};
		fixtureAdapterWithNoEnumGenerics = new AbstractEnumBackedSearchSortKeyAdapter() {};
		mockedFixtureAdapter = mock(AbstractEnumBackedSearchSortKeyAdapter.class, CALLS_REAL_METHODS);
	}

	@Test
	void adaptSortKeyCode_shouldReturnEmptyOptional_whenCodeIsNull() {
		//given
		String fixtureSortKeyCode = null;

		//when
		Optional<SearchSortKey> adaptedSortKey = fixtureAdapter.adaptSortKeyCode(fixtureSortKeyCode);

		//then
		assertNull(fixtureSortKeyCode);
		assertFalse(adaptedSortKey.isPresent());
	}

	@Test
	void adaptSortKeyCode_shouldReturnEmptyOptional_whenCodeIsEmptyString() {
		//given
		String fixtureSortKeyCode = "";

		//when
		Optional<SearchSortKey> adaptedSortKey = fixtureAdapter.adaptSortKeyCode(fixtureSortKeyCode);

		//then
		assertNotNull(fixtureSortKeyCode);
		assertTrue(fixtureSortKeyCode.isEmpty());
		assertFalse(adaptedSortKey.isPresent());
	}

	@Test
	void adaptSortKeyCode_shouldReturnEmptyOptional_whenCodeIsNotNullOrEmptyString_andCodeDoesNotExist() {
		//given
		String fixtureSortKeyCode = "thisCodeDoesNotExistOnAnyEnumMember";

		//when
		Optional<SearchSortKey> adaptedSortKey = fixtureAdapter.adaptSortKeyCode(fixtureSortKeyCode);

		//then
		assertNotNull(fixtureSortKeyCode);
		assertFalse(fixtureSortKeyCode.isEmpty());
		assertFalse(adaptedSortKey.isPresent());
	}

	@Test
	void adaptSortKeyCode_shouldReturnEmptyOptional_whenCodeIsNotNullOrEmptyString_andCodeExist() {
		//given
		FixtureSortKeys fixtureSortKey = FixtureSortKeys.SORT_KEY_1;
		String fixtureSortKeyCode = fixtureSortKey.getCode();

		//when
		Optional<SearchSortKey> adaptedSortKey = fixtureAdapter.adaptSortKeyCode(fixtureSortKeyCode);

		//then
		assertNotNull(fixtureSortKeyCode);
		assertFalse(fixtureSortKeyCode.isEmpty());
		assertTrue(adaptedSortKey.isPresent());
		assertEquals(adaptedSortKey.get(), fixtureSortKey);
	}

	@Test
	void adaptSortKeyCode_shouldThrowException_whenClassIsNotExtendedAsSuperclass(){
		//given
		String fixtureSortKeyCode = "aSortKeyCode";

		//when
		IllegalStateException exception = assertThrows(
			IllegalStateException.class,
			() -> {
				mockedFixtureAdapter.adaptSortKeyCode(fixtureSortKeyCode);
			}
		);

		//then
		assertNotNull(fixtureSortKeyCode);
		assertFalse(fixtureSortKeyCode.isEmpty());
		assertNotNull(exception);
	}

	@Test
	void adaptSortKeyCode_shouldThrowException_whenClassEnumGenericsAreNotSet(){
		//given
		String fixtureSortKeyCode = "aSortKeyCode";

		//when
		IllegalStateException exception = assertThrows(
			IllegalStateException.class,
			() -> {
				fixtureAdapterWithNoEnumGenerics.adaptSortKeyCode(fixtureSortKeyCode);
			}
		);

		//then
		assertNotNull(fixtureSortKeyCode);
		assertFalse(fixtureSortKeyCode.isEmpty());
		assertNotNull(exception);
	}

	@Test
	void adaptSortKeyCode_shouldThrowException_whenClassEnumGenericsDoesNotHaveAnyMembers(){
		//given
		String fixtureSortKeyCode = "aSortKeyCode";

		//when
		IllegalStateException exception = assertThrows(
			IllegalStateException.class,
			() -> {
				fixtureAdapterWithEmptySortKeysEnum.adaptSortKeyCode(fixtureSortKeyCode);
			}
		);

		//then
		assertNotNull(fixtureSortKeyCode);
		assertFalse(fixtureSortKeyCode.isEmpty());
		assertNotNull(exception);
	}

}