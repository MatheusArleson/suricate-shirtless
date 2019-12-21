package io.suricate.shirtless.model.parameter;

import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.DefaultSearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.DefaultSearchSortParameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractDefaultSearchParametersTest {

	@Test
	void noArgsConstructor_shouldReturnInstanceWithNullFilterPaginationSortParameters(){
		//given

		//when
		AbstractSearchParameters fixtureParameters = mock(
				AbstractDefaultSearchParameters.class,
				Mockito.withSettings()
						.useConstructor()
						.defaultAnswer(CALLS_REAL_METHODS)
		);

		//then
		assertNotNull(fixtureParameters);
		assertNull(fixtureParameters.getFilterParameters());
		assertNull(fixtureParameters.getPaginationParameters());
		assertNull(fixtureParameters.getSortParameters());
	}

	@Test
	void allArgsConstructor_shouldReturnInstanceWithProvidedFilterPaginationSortParameters(){
		//given
		SearchFilterParameters filter = mock(SearchFilterParameters.class);
		DefaultSearchPaginationParameters pagination = mock(DefaultSearchPaginationParameters.class);
		DefaultSearchSortParameters sort = mock(DefaultSearchSortParameters.class);

		//when
		AbstractSearchParameters fixtureParameters = mock(
			AbstractDefaultSearchParameters.class,
			Mockito.withSettings()
				.useConstructor(filter, pagination, sort)
				.defaultAnswer(CALLS_REAL_METHODS)
		);

		//then
		assertNotNull(fixtureParameters);

		assertNotNull(fixtureParameters.getFilterParameters());
		assertSame(fixtureParameters.getFilterParameters(), filter);

		assertNotNull(fixtureParameters.getPaginationParameters());
		assertSame(fixtureParameters.getPaginationParameters(), pagination);

		assertNotNull(fixtureParameters.getSortParameters());
		assertSame(fixtureParameters.getSortParameters(), sort);
	}

}