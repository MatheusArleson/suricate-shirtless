package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class SearchParametersTest {

	@Test
	void isNull_shouldReturnTrue_forNullParameter() {
		//given
		SearchParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchParameters.isNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNull_shouldReturnFalse_forNotNullParameter(@Mock SearchParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchParameters.isNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnTrue_forNotNullParameter(@Mock SearchParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchParameters.isNotNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnFalse_forNullParameter() {
		//given
		SearchParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchParameters.isNotNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNullParameter() {
		//given
		SearchParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchParameters.isEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forAllParametersAreNull(@Mock SearchParameters fixtureParameters){
		//given
		when(fixtureParameters.getFilterParameters()).thenReturn(null);
		when(fixtureParameters.getPaginationParameters()).thenReturn(null);
		when(fixtureParameters.getSortParameters()).thenReturn(null);

		//when
		boolean fixtureResult = SearchParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnFalse_forNotEmptyFilterParameters(
		@Mock SearchParameters fixtureParameters,
		@Mock SearchFilterParameters fixtureFilterParameters
	) {
		//given
		when(fixtureFilterParameters.isEmpty()).thenReturn(false);
		when(fixtureParameters.getFilterParameters()).thenReturn(fixtureFilterParameters);

		//when
		boolean fixtureResult = SearchParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureFilterParameters);
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnFalse_forNotEmptyPaginationParameters(
		@Mock SearchParameters fixtureParameters,
		@Mock SearchPaginationParameters fixturePaginationParameters
	) {
		//given
		when(fixturePaginationParameters.getPageNumber()).thenReturn(0);
		when(fixturePaginationParameters.getPageSize()).thenReturn(1);
		when(fixtureParameters.getPaginationParameters()).thenReturn(fixturePaginationParameters);

		//when
		boolean fixtureResult = SearchParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixturePaginationParameters);
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnFalse_forNotEmptySortParameters(
		@Mock SearchParameters fixtureParameters,
		@Mock SearchSortParameters fixtureSortParameters
	) {
		//given
		when(fixtureSortParameters.getSortCodes()).thenReturn(new String[]{"aCode"});
		when(fixtureSortParameters.getSortDirections()).thenReturn(new String[]{"aDirection"});
		when(fixtureParameters.getSortParameters()).thenReturn(fixtureSortParameters);

		//when
		boolean fixtureResult = SearchParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureSortParameters);
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNullParameter() {
		//given
		SearchParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchParameters.isNotEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forAllParametersAreNull(@Mock SearchParameters fixtureParameters){
		//given
		when(fixtureParameters.getFilterParameters()).thenReturn(null);
		when(fixtureParameters.getPaginationParameters()).thenReturn(null);
		when(fixtureParameters.getSortParameters()).thenReturn(null);

		//when
		boolean fixtureResult = SearchParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnTrue_forNotEmptyFilterParameters(
		@Mock SearchParameters fixtureParameters,
		@Mock SearchFilterParameters fixtureFilterParameters
	) {
		//given
		when(fixtureFilterParameters.isEmpty()).thenReturn(false);
		when(fixtureParameters.getFilterParameters()).thenReturn(fixtureFilterParameters);

		//when
		boolean fixtureResult = SearchParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureFilterParameters);
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnTrue_forNotEmptyPaginationParameters(
		@Mock SearchParameters fixtureParameters,
		@Mock SearchPaginationParameters fixturePaginationParameters
	) {
		//given
		when(fixturePaginationParameters.getPageNumber()).thenReturn(0);
		when(fixturePaginationParameters.getPageSize()).thenReturn(1);
		when(fixtureParameters.getPaginationParameters()).thenReturn(fixturePaginationParameters);

		//when
		boolean fixtureResult = SearchParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixturePaginationParameters);
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnTrue_forNotEmptySortParameters(
		@Mock SearchParameters fixtureParameters,
		@Mock SearchSortParameters fixtureSortParameters
	) {
		//given
		when(fixtureSortParameters.getSortCodes()).thenReturn(new String[]{"aCode"});
		when(fixtureSortParameters.getSortDirections()).thenReturn(new String[]{"aDirection"});
		when(fixtureParameters.getSortParameters()).thenReturn(fixtureSortParameters);

		//when
		boolean fixtureResult = SearchParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureSortParameters);
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}
}