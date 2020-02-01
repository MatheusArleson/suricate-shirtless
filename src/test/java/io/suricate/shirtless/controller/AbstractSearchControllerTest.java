package io.suricate.shirtless.controller;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.service.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchControllerTest {

	private SearchService searchService;
	private AbstractSearchController searchController;

	@BeforeEach
	public void setup(){
		searchService = Mockito.mock(SearchService.class, CALLS_REAL_METHODS);
		searchController = new AbstractSearchController(searchService) {};
	}

	@Test
	void total() {
		//given
		Long fixtureSearchResultsCount = 99L;
		when(searchService.total()).thenReturn(fixtureSearchResultsCount);

		//when
		Long fixtureResult = searchController.total();

		//then
		verify(searchService, times(1)).total();
		verifyNoMoreInteractions(searchService);
		assertEquals(fixtureSearchResultsCount, fixtureResult);
	}

	@Test
	void count(@Mock SearchParameters fixtureSearchParameters) {
		//given
		Long fixtureSearchResultsCount = 99L;
		doReturn(fixtureSearchResultsCount).when(searchService).count(any(SearchParameters.class));

		//when
		Long fixtureResult = searchController.count(fixtureSearchParameters);

		//then
		verify(searchService, times(1)).count(fixtureSearchParameters);
		verifyNoMoreInteractions(searchService);
		assertEquals(fixtureSearchResultsCount, fixtureResult);
	}

	@Test
	void search() {
	}

	@Test
	void filterMetaModel() {
	}

	@Test
	void paginationMetaModel() {
	}

	@Test
	void sortMetaModel() {
	}
}