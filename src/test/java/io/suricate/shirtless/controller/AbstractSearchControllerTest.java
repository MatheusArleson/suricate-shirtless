package io.suricate.shirtless.controller;

import io.suricate.shirtless.exceptions.search.parameters.EmptyParameterNotAllowedException;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.service.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchControllerTest {

	private SearchService searchService;
	private AbstractSearchController searchController;
	private ArgumentCaptor<SearchParameters> argumentCaptor;

	@BeforeEach
	public void setup(){
		searchService = Mockito.mock(SearchService.class);
		searchController = new AbstractSearchController(searchService) {};

		argumentCaptor = ArgumentCaptor.forClass(SearchParameters.class);
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
	void count_shouldBeCalled_forNullParameter() throws EmptyParameterNotAllowedException {
		//given
		SearchParameters fixtureSearchParameters = null;
		Long fixtureSearchResultsCount = 77L;
		doReturn(fixtureSearchResultsCount).when(searchService).count(null);

		//when
		Long fixtureResult = searchController.count(fixtureSearchParameters);

		//then
		verify(searchService).count(argumentCaptor.capture());
		verify(searchService, times(1)).count(fixtureSearchParameters);
		verifyNoMoreInteractions(searchService);

		assertNull(fixtureSearchParameters);
		assertSame(fixtureSearchParameters, argumentCaptor.getValue());
		assertEquals(fixtureSearchResultsCount, fixtureResult);
	}

	@Test
	void count_shouldBeCalled_forNotNullParameter(@Mock SearchParameters fixtureSearchParameters) throws EmptyParameterNotAllowedException {
		//given
		Long fixtureSearchResultsCount = 99L;
		doReturn(fixtureSearchResultsCount).when(searchService).count(any(SearchParameters.class));

		//when
		Long fixtureResult = searchController.count(fixtureSearchParameters);

		//then
		verify(searchService).count(argumentCaptor.capture());
		verify(searchService, times(1)).count(fixtureSearchParameters);
		verifyNoMoreInteractions(searchService);

		assertNotNull(fixtureSearchParameters);
		assertSame(fixtureSearchParameters, argumentCaptor.getValue());
		assertEquals(fixtureSearchResultsCount, fixtureResult);
	}

	@Test
	void search_shouldBeCalled_forNullParameter() throws EmptyParameterNotAllowedException {
		//given
		SearchParameters fixtureSearchParameters = null;
		Collection fixtureSearchResults = Collections.emptyList();
		doReturn(fixtureSearchResults).when(searchService).search(null);

		//when
		Collection fixtureResult = searchController.search(fixtureSearchParameters);

		//then
		verify(searchService).search(argumentCaptor.capture());
		verify(searchService, times(1)).search(fixtureSearchParameters);
		verifyNoMoreInteractions(searchService);

		assertNull(fixtureSearchParameters);
		assertSame(fixtureSearchParameters, argumentCaptor.getValue());
		assertEquals(fixtureSearchResults, fixtureResult);
	}

	@Test
	void search_shouldBeCalled_forNotNullParameter(@Mock SearchParameters fixtureSearchParameters) throws EmptyParameterNotAllowedException {
		//given
		Collection fixtureSearchResults = Collections.emptyList();
		doReturn(fixtureSearchResults).when(searchService).search(fixtureSearchParameters);

		//when
		Collection fixtureResult = searchController.search(fixtureSearchParameters);

		//then
		verify(searchService).search(argumentCaptor.capture());
		verify(searchService, times(1)).search(fixtureSearchParameters);
		verifyNoMoreInteractions(searchService);

		assertNotNull(fixtureSearchParameters);
		assertSame(fixtureSearchParameters, argumentCaptor.getValue());
		assertEquals(fixtureSearchResults, fixtureResult);
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