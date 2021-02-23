package io.suricate.shirtless.model.adapter.sort;

import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchSortParametersAdapterTest {

	@Test
	void adaptFilter_shouldReturnEmptyOptional_forNullParameter(
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchSortParametersAdapter fixtureParametersAdapter
	) {
		//given
		SearchSortParameters fixtureParameters = null;

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptSort(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void adaptFilter_shouldReturnEmptyOptional_forEmptyParameter(
			@Mock SearchSortParameters fixtureParameters,
			@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchSortParametersAdapter fixtureParametersAdapter
	) {
		//given
		when(fixtureParameters.getSortCodes()).thenReturn(null);
		//when(fixtureParameters.getSortDirections()).thenReturn(null);

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptSort(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void adaptFilter_shouldReturnNotEmptyOptional_forNotEmptyParameter(
			@Mock SearchSortParameters fixtureParameters,
			@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchSortParametersAdapter fixtureParametersAdapter
	) {
		//given
		when(fixtureParameters.getSortCodes()).thenReturn(new String[]{"str"});
		when(fixtureParameters.getSortDirections()).thenReturn(new String[]{"str"});
		when(fixtureParametersAdapter.generateAdapted(fixtureParameters)).thenReturn(Optional.of("adapted"));

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptSort(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertTrue(fixtureResult.isPresent());
	}

}