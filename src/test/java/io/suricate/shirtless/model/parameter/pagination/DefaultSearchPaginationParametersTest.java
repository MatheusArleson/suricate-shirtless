package io.suricate.shirtless.model.parameter.pagination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class DefaultSearchPaginationParametersTest {

	@Test
	void empty_shouldReturnNotNullInstance() {
		//given

		//when
		DefaultSearchPaginationParameters fixtureParameters = DefaultSearchPaginationParameters.empty();

		//then
		assertNotNull(fixtureParameters);
	}

	@Test
	void empty_shouldReturnInstanceWithNullPageNumberAndNullPageSize() {
		//given

		//when
		DefaultSearchPaginationParameters fixtureParameters = DefaultSearchPaginationParameters.empty();

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getPageNumber());
		assertNull(fixtureParameters.getPageSize());
	}

	@Test
	void all_shouldReturnNotNullInstance() {
		//given

		//when
		DefaultSearchPaginationParameters fixtureParameters = DefaultSearchPaginationParameters.all();

		//then
		assertNotNull(fixtureParameters);
	}

	@Test
	void all_shouldReturnInstanceWithPageNumberWithValueZeroAndPageSizeWithValueIntegerMaxValue() {
		//given

		//when
		DefaultSearchPaginationParameters fixtureParameters = DefaultSearchPaginationParameters.all();

		//then
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getPageNumber(), 0);
		assertEquals(fixtureParameters.getPageSize(), Integer.MAX_VALUE);
	}

	@Test
	void with_shouldReturnNotNullInstance() {
		//given
		int fixturePageNumber = 9;
		int fixturePageSize = 99;

		//when
		DefaultSearchPaginationParameters fixtureParameters = DefaultSearchPaginationParameters.with(fixturePageNumber, fixturePageSize);

		//then
		assertNotNull(fixtureParameters);
	}

	@Test
	void with_shouldReturnInstanceWithPassedPageNumberAndPageSize() {
		//given
		int fixturePageNumber = 9;
		int fixturePageSize = 99;

		//when
		DefaultSearchPaginationParameters fixtureParameters = DefaultSearchPaginationParameters.with(fixturePageNumber, fixturePageSize);

		//then
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getPageNumber(), fixturePageNumber);
		assertEquals(fixtureParameters.getPageSize(), fixturePageSize);
	}

	@Test
	void noArgsConstructor_shouldReturnInstanceWithNullPageNumberAndNullPageSize(){
		//given

		//when
		DefaultSearchPaginationParameters fixtureParameters = new DefaultSearchPaginationParameters();

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getPageNumber());
		assertNull(fixtureParameters.getPageSize());
	}

	@Test
	void allArgsConstructor_shouldReturnInstanceWithProvidedPageNumberAndNullPageSize(){
		//given
		Integer fixturePageNumber = 9;
		Integer fixturePageSize = 99;

		//when
		DefaultSearchPaginationParameters fixtureParameters = new DefaultSearchPaginationParameters(fixturePageNumber, fixturePageSize);

		//then
		assertNotNull(fixtureParameters);
		assertEquals(fixtureParameters.getPageNumber(), fixturePageNumber);
		assertEquals(fixtureParameters.getPageSize(), fixturePageSize);
	}
}