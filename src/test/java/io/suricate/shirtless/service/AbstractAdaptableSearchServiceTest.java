package io.suricate.shirtless.service;

import io.suricate.shirtless.controller.AbstractDefaultSearchController;
import io.suricate.shirtless.exceptions.search.parameters.adapter.EmptyAdaptedSearchFilterParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.adapter.EmptyAdaptedSearchPaginationParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.adapter.EmptyAdaptedSearchSortParametersNotAllowed;
import io.suricate.shirtless.model.adapter.SearchParametersAdapter;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.AdaptedSearchParametersSupervisor;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractAdaptableSearchServiceTest {

	private SearchParameters searchParameters;
	private AdaptedSearchParametersSupervisor searchParametersSupervisor;
	private SearchParametersAdapter searchParametersAdapter;

	private AbstractAdaptableSearchService adaptableSearchService;

	@BeforeEach
	void setUp() {
		SearchFilterParameters mockedNotEmptyFilterParameters = mock(SearchFilterParameters.class, CALLS_REAL_METHODS);
		when(mockedNotEmptyFilterParameters.isEmpty()).thenReturn(Boolean.FALSE);

		SearchPaginationParameters mockedNotEmptyPaginationParameters = mock(SearchPaginationParameters.class, CALLS_REAL_METHODS);
		when(mockedNotEmptyPaginationParameters.getPageNumber()).thenReturn(1);
		when(mockedNotEmptyPaginationParameters.getPageSize()).thenReturn(1);

		SearchSortParameters mockedNotEmptySortParameters = mock(SearchSortParameters.class, CALLS_REAL_METHODS);
		when(mockedNotEmptySortParameters.getSortCodes()).thenReturn(new String[] {"code"});
		when(mockedNotEmptySortParameters.getSortDirections()).thenReturn(new String[] {"asc"});

		this.searchParameters = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(this.searchParameters.getFilterParameters()).thenReturn(mockedNotEmptyFilterParameters);
		when(this.searchParameters.getPaginationParameters()).thenReturn(mockedNotEmptyPaginationParameters);
		when(this.searchParameters.getSortParameters()).thenReturn(mockedNotEmptySortParameters);

		this.searchParametersSupervisor = mock(AdaptedSearchParametersSupervisor.class, CALLS_REAL_METHODS);
		this.searchParametersAdapter = mock(SearchParametersAdapter.class, CALLS_REAL_METHODS);

		this.adaptableSearchService = mock(
			AbstractAdaptableSearchService.class,
			Mockito.withSettings()
				.useConstructor(this.searchParametersSupervisor, this.searchParametersAdapter)
				.defaultAnswer(CALLS_REAL_METHODS)
		);
	}

	@Test
	void count_shouldThrowException_whenSearchWithEmptyAdaptedSearchFilter_isNotAllowed_andCouldNotGenerateAdaptedFilter() {
		//given
		SearchParameters fixtureSearchParameters = this.searchParameters;
		AbstractAdaptableSearchService fixtureSearchService = this.adaptableSearchService;
		SearchParametersAdapter fixtureSearchParametersAdapter = this.searchParametersAdapter;

		AdaptedSearchParametersSupervisor fixtureSearchSupervisor = this.searchParametersSupervisor;
		when(fixtureSearchSupervisor.isSearchWithEmptyAdaptedSearchFilterParametersAllowed()).thenReturn(Boolean.FALSE);

		//when
		EmptyAdaptedSearchFilterParametersNotAllowed exception = assertThrows(
			EmptyAdaptedSearchFilterParametersNotAllowed.class,
			() -> fixtureSearchService.count(fixtureSearchParameters)
		);

		//then
		verify(fixtureSearchService, times(1)).count(fixtureSearchParameters);
		verify(fixtureSearchParametersAdapter, times(1)).adaptFilter(fixtureSearchParameters.getFilterParameters());

		assertNotNull(exception);
	}

	@Test
	void count_shouldThrowException_whenSearchWithEmptyAdaptedSearchPagination_isNotAllowed_andCouldNotGenerateAdaptedPagination() {
		//given
		SearchParameters fixtureSearchParameters = this.searchParameters;
		AbstractAdaptableSearchService fixtureSearchService = this.adaptableSearchService;
		SearchParametersAdapter fixtureSearchParametersAdapter = this.searchParametersAdapter;

		AdaptedSearchParametersSupervisor fixtureSearchSupervisor = this.searchParametersSupervisor;
		when(fixtureSearchSupervisor.isSearchWithEmptyAdaptedSearchFilterParametersAllowed()).thenReturn(Boolean.TRUE);
		when(fixtureSearchSupervisor.isSearchWithEmptyAdaptedSearchPaginationParametersAllowed()).thenReturn(Boolean.FALSE);

		//when
		EmptyAdaptedSearchPaginationParametersNotAllowed exception = assertThrows(
			EmptyAdaptedSearchPaginationParametersNotAllowed.class,
			() -> fixtureSearchService.count(fixtureSearchParameters)
		);

		//then
		verify(fixtureSearchService, times(1)).count(fixtureSearchParameters);
		verify(fixtureSearchParametersAdapter, times(1)).adaptFilter(fixtureSearchParameters.getFilterParameters());
		verify(fixtureSearchParametersAdapter, times(1)).adaptPagination(fixtureSearchParameters.getPaginationParameters());

		assertNotNull(exception);
	}

	@Test
	void count_shouldThrowException_whenSearchWithEmptyAdaptedSearchSort_isNotAllowed_andCouldNotGenerateAdaptedSort() {
		//given
		SearchParameters fixtureSearchParameters = this.searchParameters;
		AbstractAdaptableSearchService fixtureSearchService = this.adaptableSearchService;
		SearchParametersAdapter fixtureSearchParametersAdapter = this.searchParametersAdapter;

		AdaptedSearchParametersSupervisor fixtureSearchSupervisor = this.searchParametersSupervisor;
		when(fixtureSearchSupervisor.isSearchWithEmptyAdaptedSearchFilterParametersAllowed()).thenReturn(Boolean.TRUE);
		when(fixtureSearchSupervisor.isSearchWithEmptyAdaptedSearchPaginationParametersAllowed()).thenReturn(Boolean.TRUE);
		when(fixtureSearchSupervisor.isSearchWithEmptyAdaptedSearchSortParametersAllowed()).thenReturn(Boolean.FALSE);

		//when
		EmptyAdaptedSearchSortParametersNotAllowed exception = assertThrows(
			EmptyAdaptedSearchSortParametersNotAllowed.class,
			() -> fixtureSearchService.count(fixtureSearchParameters)
		);

		//then
		verify(fixtureSearchService, times(1)).count(fixtureSearchParameters);
		verify(fixtureSearchParametersAdapter, times(1)).adaptFilter(fixtureSearchParameters.getFilterParameters());
		verify(fixtureSearchParametersAdapter, times(1)).adaptPagination(fixtureSearchParameters.getPaginationParameters());
		verify(fixtureSearchParametersAdapter, times(1)).adaptSort(fixtureSearchParameters.getSortParameters());

		assertNotNull(exception);
	}

	@Test
	void count_shouldNotThrowException_norCheckWithSupervisor_whenAdaptedObjectsCanBeGenerated() {
		//given
		SearchParameters fixtureSearchParameters = this.searchParameters;
		AbstractAdaptableSearchService fixtureSearchService = this.adaptableSearchService;

		SearchParametersAdapter fixtureSearchParametersAdapter = this.searchParametersAdapter;
		when(fixtureSearchParametersAdapter.adaptFilter(any(SearchFilterParameters.class))).thenReturn(Optional.of("mocked"));
		when(fixtureSearchParametersAdapter.adaptPagination(any(SearchPaginationParameters.class))).thenReturn(Optional.of("mocked"));
		when(fixtureSearchParametersAdapter.adaptSort(any(SearchSortParameters.class))).thenReturn(Optional.of("mocked"));

		AdaptedSearchParametersSupervisor fixtureSearchSupervisor = this.searchParametersSupervisor;

		//when
		fixtureSearchService.count(fixtureSearchParameters);

		//then
		verify(fixtureSearchService, times(1)).count(fixtureSearchParameters);
		verify(fixtureSearchParametersAdapter, times(1)).adaptFilter(fixtureSearchParameters.getFilterParameters());
		verify(fixtureSearchParametersAdapter, times(1)).adaptPagination(fixtureSearchParameters.getPaginationParameters());
		verify(fixtureSearchParametersAdapter, times(1)).adaptSort(fixtureSearchParameters.getSortParameters());
		verify(fixtureSearchSupervisor, times(0)).isSearchWithEmptyAdaptedSearchFilterParametersAllowed();
		verify(fixtureSearchSupervisor, times(0)).isSearchWithEmptyAdaptedSearchPaginationParametersAllowed();
		verify(fixtureSearchSupervisor, times(0)).isSearchWithEmptyAdaptedSearchSortParametersAllowed();
	}


}