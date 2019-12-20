package io.suricate.shirtless.model.parameter.filter;

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
class SearchFilterParametersTest {

	@Test
	void isNull_shouldReturnTrue_forNullParameter() {
		//given
		SearchFilterParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchFilterParameters.isNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNull_shouldReturnFalse_forNotNullParameter(@Mock SearchFilterParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchFilterParameters.isNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnTrue_forNotNullParameter(@Mock SearchFilterParameters fixtureParameters) {
		//given

		//when
		boolean fixtureResult = SearchFilterParameters.isNotNull(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isNotNull_shouldReturnFalse_forNullParameter() {
		//given
		SearchFilterParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchFilterParameters.isNotNull(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNullParameter() {
		//given
		SearchFilterParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchFilterParameters.isEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullWithReturningTrueForEmptyMethod(@Mock SearchFilterParameters fixtureParameters) {
		//given
		when(fixtureParameters.isEmpty()).thenReturn(true);

		//when
		boolean fixtureResult = SearchFilterParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

	@Test
	void isEmpty_shouldReturnTrue_forNotNullWithReturningFalseForEmptyMethod(@Mock SearchFilterParameters fixtureParameters) {
		//given
		when(fixtureParameters.isEmpty()).thenReturn(false);

		//when
		boolean fixtureResult = SearchFilterParameters.isEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNullParameter() {
		//given
		SearchFilterParameters fixtureParameters = null;

		//when
		boolean fixtureResult = SearchFilterParameters.isNotEmpty(fixtureParameters);

		//then
		assertNull(fixtureParameters);
		assertFalse(fixtureResult);

	}

	@Test
	void isNotEmpty_shouldReturnFalse_forNotNullWithReturningTrueForEmptyMethod(@Mock SearchFilterParameters fixtureParameters) {
		//given
		when(fixtureParameters.isEmpty()).thenReturn(true);

		//when
		boolean fixtureResult = SearchFilterParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertFalse(fixtureResult);
	}

	@Test
	void isNotEmpty_shouldReturnTrue_forNotNullWithReturningFalseForEmptyMethod(@Mock SearchFilterParameters fixtureParameters) {
		//given
		when(fixtureParameters.isEmpty()).thenReturn(false);

		//when
		boolean fixtureResult = SearchFilterParameters.isNotEmpty(fixtureParameters);

		//then
		assertNotNull(fixtureParameters);
		assertTrue(fixtureResult);
	}

}