package io.suricate.shirtless.model.adapter.pagination;

import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchPaginationParametersAdapterTest {

	@Test
	void adaptFilter_shouldReturnEmptyOptional_forNullParameter(
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchPaginationParametersAdapter fixtureParametersAdapter
	) {
		//given
		SearchPaginationParameters fixtureParameters = null;

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptPagination(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void adaptFilter_shouldReturnEmptyOptional_forEmptyParameter(
		@Mock SearchPaginationParameters fixtureParameters,
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchPaginationParametersAdapter fixtureParametersAdapter
	) {
		//given
		when(fixtureParameters.getPageNumber()).thenReturn(null);
		//when(fixtureParameters.getPageSize()).thenReturn(null);

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptPagination(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void adaptFilter_shouldReturnNotEmptyOptional_forNotEmptyParameter(
		@Mock SearchPaginationParameters fixtureParameters,
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchPaginationParametersAdapter fixtureParametersAdapter
	) {
		//given
		when(fixtureParameters.getPageNumber()).thenReturn(9);
		when(fixtureParameters.getPageSize()).thenReturn(9);
		when(fixtureParametersAdapter.generateAdapted(fixtureParameters)).thenReturn(Optional.of("adapted"));

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptPagination(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertTrue(fixtureResult.isPresent());
	}

}