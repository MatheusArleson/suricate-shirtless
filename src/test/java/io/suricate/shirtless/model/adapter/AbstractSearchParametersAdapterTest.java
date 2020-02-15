package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchParametersAdapterTest {

	private SearchParametersAdapter searchParametersAdapter;

	private SearchFilterParametersAdapter searchFilterParametersAdapter;
	private SearchPaginationParametersAdapter searchPaginationParametersAdapter;
	private SearchSortParametersAdapter searchSortParametersAdapter;

	private ArgumentCaptor<SearchFilterParameters> searchFilterParametersArgumentCaptor;
	private ArgumentCaptor<SearchPaginationParameters> searchPaginationParametersArgumentCaptor;
	private ArgumentCaptor<SearchSortParameters> searchSortParametersArgumentCaptor;

	@BeforeEach
	public void setup(){
		searchFilterParametersAdapter = Mockito.mock(SearchFilterParametersAdapter.class);
		searchPaginationParametersAdapter = Mockito.mock(SearchPaginationParametersAdapter.class);
		searchSortParametersAdapter = Mockito.mock(SearchSortParametersAdapter.class);

		searchParametersAdapter = new AbstractSearchParametersAdapter(
			searchFilterParametersAdapter,
			searchPaginationParametersAdapter,
			searchSortParametersAdapter
		) {};

		searchFilterParametersArgumentCaptor = ArgumentCaptor.forClass(SearchFilterParameters.class);
		searchPaginationParametersArgumentCaptor = ArgumentCaptor.forClass(SearchPaginationParameters.class);
		searchSortParametersArgumentCaptor = ArgumentCaptor.forClass(SearchSortParameters.class);
	}

	@Test
	void adaptFilter_shouldBeCalled_forNullParameter() {
		//given
		SearchFilterParameters fixtureFilterParameters = null;
		Optional<Object> fixtureAdaptedFilterParameters = Optional.empty();
		when(searchParametersAdapter.adaptFilter(any())).thenReturn(fixtureAdaptedFilterParameters);

		//when
		Optional adaptedFilterParameters = searchParametersAdapter.adaptFilter(fixtureFilterParameters);

		//then
		verify(searchFilterParametersAdapter).adaptFilter(searchFilterParametersArgumentCaptor.capture());
		verify(searchFilterParametersAdapter, times(1)).adaptFilter(fixtureFilterParameters);
		verifyNoMoreInteractions(searchFilterParametersAdapter);

		assertNull(fixtureFilterParameters);
		assertSame(fixtureFilterParameters, searchFilterParametersArgumentCaptor.getValue());
		assertEquals(fixtureAdaptedFilterParameters, adaptedFilterParameters);
	}

	@Test
	void adaptFilter_shouldBeCalled_forNotNullParameter() {
		//given
		SearchFilterParameters fixtureFilterParameters = mock(SearchFilterParameters.class);
		Optional<Object> fixtureAdaptedFilterParameters = Optional.empty();
		when(searchParametersAdapter.adaptFilter(any())).thenReturn(fixtureAdaptedFilterParameters);

		//when
		Optional adaptedFilterParameters = searchParametersAdapter.adaptFilter(fixtureFilterParameters);

		//then
		verify(searchFilterParametersAdapter).adaptFilter(searchFilterParametersArgumentCaptor.capture());
		verify(searchFilterParametersAdapter, times(1)).adaptFilter(fixtureFilterParameters);
		verifyNoMoreInteractions(searchFilterParametersAdapter);

		assertNotNull(fixtureFilterParameters);
		assertSame(fixtureFilterParameters, searchFilterParametersArgumentCaptor.getValue());
		assertEquals(fixtureAdaptedFilterParameters, adaptedFilterParameters);
	}

	@Test
	void adaptPagination_shouldBeCalled_forNullParameter() {
		//given
		SearchPaginationParameters fixturePaginationParameters = null;
		Optional<Object> fixtureAdaptedPaginationParameters = Optional.empty();
		when(searchParametersAdapter.adaptPagination(any())).thenReturn(fixtureAdaptedPaginationParameters);

		//when
		Optional adaptedPaginationParameters = searchParametersAdapter.adaptPagination(fixturePaginationParameters);

		//then
		verify(searchPaginationParametersAdapter).adaptPagination(searchPaginationParametersArgumentCaptor.capture());
		verify(searchPaginationParametersAdapter, times(1)).adaptPagination(fixturePaginationParameters);
		verifyNoMoreInteractions(searchPaginationParametersAdapter);

		assertNull(fixturePaginationParameters);
		assertSame(fixturePaginationParameters, searchPaginationParametersArgumentCaptor.getValue());
		assertEquals(fixtureAdaptedPaginationParameters, adaptedPaginationParameters);
	}

	@Test
	void adaptPagination_shouldBeCalled_forNotNullParameter(){
		SearchPaginationParameters fixturePaginationParameters = mock(SearchPaginationParameters.class);
		Optional<Object> fixtureAdaptedPaginationParameters = Optional.empty();
		when(searchParametersAdapter.adaptPagination(any())).thenReturn(fixtureAdaptedPaginationParameters);

		//when
		Optional adaptedPaginationParameters = searchParametersAdapter.adaptPagination(fixturePaginationParameters);

		//then
		verify(searchPaginationParametersAdapter).adaptPagination(searchPaginationParametersArgumentCaptor.capture());
		verify(searchPaginationParametersAdapter, times(1)).adaptPagination(fixturePaginationParameters);
		verifyNoMoreInteractions(searchPaginationParametersAdapter);

		assertNotNull(fixturePaginationParameters);
		assertSame(fixturePaginationParameters, searchPaginationParametersArgumentCaptor.getValue());
		assertEquals(fixtureAdaptedPaginationParameters, adaptedPaginationParameters);
	}

	@Test
	void adaptSort_shouldBeCalled_forNullParameter() {
		SearchSortParameters fixtureSortParameters = null;
		Optional<Object> fixtureAdaptedSortParameters = Optional.empty();
		when(searchParametersAdapter.adaptSort(any())).thenReturn(fixtureAdaptedSortParameters);

		//when
		Optional adaptedSortParameters = searchParametersAdapter.adaptSort(fixtureSortParameters);

		//then
		verify(searchSortParametersAdapter).adaptSort(searchSortParametersArgumentCaptor.capture());
		verify(searchSortParametersAdapter, times(1)).adaptSort(fixtureSortParameters);
		verifyNoMoreInteractions(searchSortParametersAdapter);

		assertNull(fixtureSortParameters);
		assertSame(fixtureSortParameters, searchSortParametersArgumentCaptor.getValue());
		assertEquals(fixtureAdaptedSortParameters, adaptedSortParameters);
	}

	@Test
	void adaptSort_shouldBeCalled_forNotNullParameter() {
		SearchSortParameters fixtureSortParameters = mock(SearchSortParameters.class);
		Optional<Object> fixtureAdaptedSortParameters = Optional.empty();
		when(searchParametersAdapter.adaptSort(any())).thenReturn(fixtureAdaptedSortParameters);

		//when
		Optional adaptedSortParameters = searchParametersAdapter.adaptSort(fixtureSortParameters);

		//then
		verify(searchSortParametersAdapter).adaptSort(searchSortParametersArgumentCaptor.capture());
		verify(searchSortParametersAdapter, times(1)).adaptSort(fixtureSortParameters);
		verifyNoMoreInteractions(searchSortParametersAdapter);

		assertNotNull(fixtureSortParameters);
		assertSame(fixtureSortParameters, searchSortParametersArgumentCaptor.getValue());
		assertEquals(fixtureAdaptedSortParameters, adaptedSortParameters);
	}
}