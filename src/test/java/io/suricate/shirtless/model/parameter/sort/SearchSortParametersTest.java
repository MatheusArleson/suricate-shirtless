package io.suricate.shirtless.model.parameter.sort;

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
class SearchSortParametersTest {

	@Test
	void isNull_shouldReturnTrue_forNullParameter() {
		//given
		SearchSortParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchSortParameters.isNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNull_shouldReturnFalse_forNotNullParameter(@Mock SearchSortParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchSortParameters.isNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnTrue_forNotNullParameter(@Mock SearchSortParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchSortParameters.isNotNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnFalse_forNullParameter() {
		//given
		SearchSortParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchSortParameters.isNotNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNullParameter() {
		//given
		SearchSortParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchSortParameters.isEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullParameterButNullSortCodes(@Mock SearchSortParameters fixtureParameters) {
		//given
		when(fixtureParameters.getSortCodes()).thenReturn(null);
		when(fixtureParameters.getSortDirections()).thenReturn(new String[]{"aDirections"});

		//when
		boolean fixtureResult = SearchSortParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getSortCodes());
		assertNotNull(fixtureParameters.getSortDirections());
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullParameterButNullSortDirections(@Mock SearchSortParameters fixtureParameters) {
		//given
		when(fixtureParameters.getSortCodes()).thenReturn(new String[]{"aCode"});
		when(fixtureParameters.getSortDirections()).thenReturn(null);

		//when
		boolean fixtureResult = SearchSortParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertNotNull(fixtureParameters.getSortCodes());
		assertNull(fixtureParameters.getSortDirections());
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullParameterButDifferentSizedSortCodesAndDirections(@Mock SearchSortParameters fixtureParameters) {
		//given
		String[] fixtureSortCodes = {"aCode"};
		String[] fixtureSortDirections = {"aDirection1", "aDirection2"};

		when(fixtureParameters.getSortCodes()).thenReturn(fixtureSortCodes);
		when(fixtureParameters.getSortDirections()).thenReturn(fixtureSortDirections);

		//when
		boolean fixtureResult = SearchSortParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureSortCodes);
		assertNotNull(fixtureSortDirections);
		assertNotEquals(fixtureSortCodes.length, fixtureSortDirections.length);
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getSortCodes(), fixtureSortCodes);
		assertEquals(fixtureParameters.getSortDirections(), fixtureSortDirections);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnFalse_forNotNullParameterWithSameSizeSortCodesAndDirections(@Mock SearchSortParameters fixtureParameters){
		//given
		String[] fixtureSortCodes = {"aCode", "bCode"};
		String[] fixtureSortDirections = {"aDirection1", "aDirection2"};

		when(fixtureParameters.getSortCodes()).thenReturn(fixtureSortCodes);
		when(fixtureParameters.getSortDirections()).thenReturn(fixtureSortDirections);

		//when
		boolean fixtureResult = SearchSortParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureSortCodes);
		assertNotNull(fixtureSortDirections);
		assertEquals(fixtureSortCodes.length, fixtureSortDirections.length);
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getSortCodes(), fixtureSortCodes);
		assertEquals(fixtureParameters.getSortDirections(), fixtureSortDirections);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNullParameter() {
		//given
		SearchSortParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchSortParameters.isNotEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNotNullParameterButNullSortCodes(@Mock SearchSortParameters fixtureParameters) {
		//given
		when(fixtureParameters.getSortCodes()).thenReturn(null);
		when(fixtureParameters.getSortDirections()).thenReturn(new String[]{"aDirection"});

		//when
		boolean fixtureResult = SearchSortParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getSortCodes());
		assertNotNull(fixtureParameters.getSortDirections());
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNotNullParameterButNullSortDirections(@Mock SearchSortParameters fixtureParameters) {
		//given
		when(fixtureParameters.getSortCodes()).thenReturn(new String[]{"aCode"});
		when(fixtureParameters.getSortDirections()).thenReturn(null);

		//when
		boolean fixtureResult = SearchSortParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertNotNull(fixtureParameters.getSortCodes());
		assertNull(fixtureParameters.getSortDirections());
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNotNullParameterButDifferentSizedSortCodesAndDirections(@Mock SearchSortParameters fixtureParameters) {
		//given
		String[] fixtureSortCodes = {"aCode"};
		String[] fixtureSortDirections = {"aDirection1", "aDirection2"};

		when(fixtureParameters.getSortCodes()).thenReturn(fixtureSortCodes);
		when(fixtureParameters.getSortDirections()).thenReturn(fixtureSortDirections);

		//when
		boolean fixtureResult = SearchSortParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureSortCodes);
		assertNotNull(fixtureSortDirections);
		assertNotEquals(fixtureSortCodes.length, fixtureSortDirections.length);
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getSortCodes(), fixtureSortCodes);
		assertEquals(fixtureParameters.getSortDirections(), fixtureSortDirections);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnTrue_forNotNullParameterWithSameSizeSortCodesAndDirections(@Mock SearchSortParameters fixtureParameters){
		//given
		String[] fixtureSortCodes = {"aCode", "bCode"};
		String[] fixtureSortDirections = {"aDirection1", "aDirection2"};

		when(fixtureParameters.getSortCodes()).thenReturn(fixtureSortCodes);
		when(fixtureParameters.getSortDirections()).thenReturn(fixtureSortDirections);

		//when
		boolean fixtureResult = SearchSortParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureSortCodes);
		assertNotNull(fixtureSortDirections);
		assertEquals(fixtureSortCodes.length, fixtureSortDirections.length);
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getSortCodes(), fixtureSortCodes);
		assertEquals(fixtureParameters.getSortDirections(), fixtureSortDirections);
		assertTrue(fixtureResult);
	}

}