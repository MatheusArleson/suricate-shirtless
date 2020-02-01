package io.suricate.shirtless.model.adapter.filter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchFilterParametersAdapterTest {

	@Test
	void adaptFilter_shouldReturnEmptyOptional_forNullParameter(
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchFilterParametersAdapter fixtureParametersAdapter
	) {
		//given
		SearchFilterParameters fixtureParameters = null;

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptFilter(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void adaptFilter_shouldReturnEmptyOptional_forEmptyParameter(
		@Mock SearchFilterParameters fixtureParameters,
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchFilterParametersAdapter fixtureParametersAdapter
	) {
		//given
		when(fixtureParameters.isEmpty()).thenReturn(Boolean.TRUE);

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptFilter(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void adaptFilter_shouldReturnNotEmptyOptional_forNotEmptyParameter(
		@Mock SearchFilterParameters fixtureParameters,
		@Mock(answer = Answers.CALLS_REAL_METHODS) AbstractSearchFilterParametersAdapter fixtureParametersAdapter
	) {
		//given
		when(fixtureParameters.isEmpty()).thenReturn(Boolean.FALSE);
		when(fixtureParametersAdapter.generateAdapted(any())).thenReturn(Optional.of(anyString()));

		//when
		Optional fixtureResult = fixtureParametersAdapter.adaptFilter(fixtureParameters);

		//then
		assertNotNull(fixtureResult);
		assertTrue(fixtureResult.isPresent());
	}

}