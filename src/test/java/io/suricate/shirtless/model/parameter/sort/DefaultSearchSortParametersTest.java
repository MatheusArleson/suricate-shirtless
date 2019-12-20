package io.suricate.shirtless.model.parameter.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class DefaultSearchSortParametersTest {

	@Test
	void empty_shouldReturnNotNullInstance() {
		//given

		//when
		DefaultSearchSortParameters fixtureParameters = DefaultSearchSortParameters.empty();

		//then
		assertNotNull(fixtureParameters);
	}

	@Test
	void empty_shouldReturnInstanceWithNullSortCodesAndNullSortDirections() {
		//given

		//when
		DefaultSearchSortParameters fixtureParameters = DefaultSearchSortParameters.empty();

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getSortCodes());
		assertNull(fixtureParameters.getSortDirections());
	}

	@Test
	void with_shouldReturnNotNullInstance() {
		//given
		String[] fixtureSortCodes = {};
		String[] fixtureSortDirections = {};

		//when
		DefaultSearchSortParameters fixtureParameters = DefaultSearchSortParameters.with(fixtureSortCodes, fixtureSortDirections);

		//then
		assertNotNull(fixtureParameters);
	}

	@Test
	void with_shouldReturnInstanceWithPassedSortCodesAndSortDirections() {
		//given
		String[] fixtureSortCodes = {"aCode"};
		String[] fixtureSortDirections = {"aDirection"};

		//when
		DefaultSearchSortParameters fixtureParameters = DefaultSearchSortParameters.with(fixtureSortCodes, fixtureSortDirections);

		//then
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getSortCodes(), fixtureSortCodes);
		assertEquals(fixtureParameters.getSortDirections(), fixtureSortDirections);
	}

	@Test
	void noArgsConstructor_shouldReturnInstanceWithNullSortCodesAndNullSortDirections(){
		//given

		//when
		DefaultSearchSortParameters fixtureParameters = new DefaultSearchSortParameters();

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getSortCodes());
		assertNull(fixtureParameters.getSortDirections());
	}

	@Test
	void allArgsConstructor_shouldReturnInstanceWithProvidedPageNumberAndNullPageSize(){
		//given
		String[] fixtureSortCodes = {"aCode"};
		String[] fixtureSortDirections = {"aDirection"};

		//when
		DefaultSearchSortParameters fixtureParameters = new DefaultSearchSortParameters(fixtureSortCodes, fixtureSortDirections);

		//then
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getSortCodes(), fixtureSortCodes);
		assertEquals(fixtureParameters.getSortDirections(), fixtureSortDirections);
	}
}