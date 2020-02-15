package io.suricate.shirtless.model.adapter.sort.key;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSortKeyBackedDefaultSearchSortParametersAdapterTest {

	@Test
	void constructor_shouldThrowException_whenSortKeyAdapterArgumentIsNull(){
		//given
		final SearchSortKeyAdapter sortKeyAdapter = null;

		//when
		NullPointerException exception = assertThrows(
			NullPointerException.class,
			() -> new AbstractSortKeyBackedDefaultSearchSortParametersAdapter(
					sortKeyAdapter
			) {
				@Override
				protected Optional generateAdaptedFromSearchSortKeysValues(String[] searchSortKeysValues, String[] sortDirections) {
					return Optional.empty();
				}
			}
		);

		//then
		assertNull(sortKeyAdapter);
		assertNotNull(exception);
	}

	@Test
	void constructor_shouldNotThrowException_whenAllArgumentsAreNotNull(){
		//given
		final SearchSortKeyAdapter sortKeyAdapter = mock(SearchSortKeyAdapter.class);

		//when
		AbstractSortKeyBackedDefaultSearchSortParametersAdapter searchSortParametersAdapter = assertDoesNotThrow(
			() -> new AbstractSortKeyBackedDefaultSearchSortParametersAdapter(
				sortKeyAdapter
			) {
				@Override
				protected Optional generateAdaptedFromSearchSortKeysValues(String[] searchSortKeysValues, String[] sortDirections) {
					return Optional.empty();
				}
			}
		);

		//then
		assertNotNull(sortKeyAdapter);
		assertNotNull(searchSortParametersAdapter);
	}

}