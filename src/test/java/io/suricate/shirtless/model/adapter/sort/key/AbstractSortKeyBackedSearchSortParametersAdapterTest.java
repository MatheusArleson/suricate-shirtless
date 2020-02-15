package io.suricate.shirtless.model.adapter.sort.key;

import io.suricate.shirtless.exceptions.search.parameters.InvalidSortKeyException;
import io.suricate.shirtless.model.parameter.sort.key.SearchSortKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSortKeyBackedSearchSortParametersAdapterTest {

	private AbstractSortKeyBackedSearchSortParametersAdapter fixtureAdapter;

	private SearchSortKeyAdapter fixtureSortKeyAdapter;
	private ArgumentCaptor<String> stringArgumentCaptor;

	@BeforeEach
	void setUp(){
		fixtureSortKeyAdapter = mock(SearchSortKeyAdapter.class, CALLS_REAL_METHODS);
		fixtureAdapter = Mockito.mock(
			AbstractSortKeyBackedSearchSortParametersAdapter.class,
			withSettings()
				.useConstructor(fixtureSortKeyAdapter)
				.defaultAnswer(CALLS_REAL_METHODS)
		);

		stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
	}


	@Test
	void generateAdapted() {

	}

	@Test
	void generateAdapted_shouldThrowException_whenSortKeyCodeIsInvalid() {
		//given
		String invalidSortKeyCode = "aInvalidKeyCode";
		String invalidSortDirection = "aInvalidDirection";
		String[] sortCodes = {invalidSortKeyCode};
		String[] sortDirections = {invalidSortDirection};
		when(fixtureSortKeyAdapter.adaptSortKeyCode(invalidSortKeyCode)).thenReturn(Optional.empty());

		//when
		InvalidSortKeyException exception = assertThrows(
			InvalidSortKeyException.class,
			() -> {
				fixtureAdapter.generateAdapted(sortCodes, sortDirections);
			}
		);

		//then
		verify(fixtureSortKeyAdapter).adaptSortKeyCode(stringArgumentCaptor.capture());
		verify(fixtureSortKeyAdapter, times(1)).adaptSortKeyCode(invalidSortKeyCode);
		verifyNoMoreInteractions(fixtureSortKeyAdapter);

		assertSame(invalidSortKeyCode, stringArgumentCaptor.getValue());
		assertNotNull(exception);
	}

	@Test
	void generateAdapted_shouldNotThrowException_whenSortKeyCodeIsValid() {
		//given
		String validSortKeyCode = "aValidKeyCode";
		String validDirection = "aValidDirection";
		String[] sortCodes = {validSortKeyCode};
		String[] sortDirections = {validDirection};

		Optional<SearchSortKey> mockedSortKey = Optional.of(mock(SearchSortKey.class));
		when(fixtureSortKeyAdapter.adaptSortKeyCode(validSortKeyCode)).thenReturn(mockedSortKey);

		//when
		assertDoesNotThrow(
			() -> {
				return fixtureAdapter.generateAdapted(sortCodes, sortDirections);
			}
		);

		//then
		verify(fixtureSortKeyAdapter).adaptSortKeyCode(stringArgumentCaptor.capture());
		verify(fixtureSortKeyAdapter, times(1)).adaptSortKeyCode(validSortKeyCode);
		verifyNoMoreInteractions(fixtureSortKeyAdapter);

		assertSame(validSortKeyCode, stringArgumentCaptor.getValue());
	}
}