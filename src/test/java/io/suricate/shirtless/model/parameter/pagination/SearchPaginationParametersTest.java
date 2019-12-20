package io.suricate.shirtless.model.parameter.pagination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class SearchPaginationParametersTest {

	@Test
	void isNull_shouldReturnTrue_forNullParameter() {
		//given
		SearchPaginationParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchPaginationParameters.isNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNull_shouldReturnFalse_forNotNullParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchPaginationParameters.isNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnTrue_forNotNullParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchPaginationParameters.isNotNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnFalse_forNullParameter() {
		//given
		SearchPaginationParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchPaginationParameters.isNotNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNullParameter() {
		//given
		SearchPaginationParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchPaginationParameters.isEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullButEmptyPageNumberParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given
		when(fixtureParameters.getPageNumber()).thenReturn(null);

		//when
		boolean fixtureResult = SearchPaginationParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullButEmptyPageSizeParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given
		when(fixtureParameters.getPageSize()).thenReturn(null);

		//when
		boolean fixtureResult = SearchPaginationParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnFalse_forNotNullAndNotEmptyParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given
		when(fixtureParameters.getPageNumber()).thenReturn(1);
		when(fixtureParameters.getPageSize()).thenReturn(2);

		//when
		boolean fixtureResult = SearchPaginationParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNullParameter() {
		//given
		SearchPaginationParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchPaginationParameters.isNotEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);

	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNotNullButEmptyPageNumberParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given
		when(fixtureParameters.getPageNumber()).thenReturn(null);

		//when
		boolean fixtureResult = SearchPaginationParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNotNullButEmptyPageSizeParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given
		when(fixtureParameters.getPageSize()).thenReturn(null);

		//when
		boolean fixtureResult = SearchPaginationParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnTrue_forNotNullAndNotEmptyParameter(@Mock SearchPaginationParameters fixtureParameters) {
		//given
		when(fixtureParameters.getPageNumber()).thenReturn(1);
		when(fixtureParameters.getPageSize()).thenReturn(2);

		//when
		boolean fixtureResult = SearchPaginationParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}
}