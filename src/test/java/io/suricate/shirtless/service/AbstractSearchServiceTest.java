package io.suricate.shirtless.service;

import io.suricate.shirtless.exceptions.search.parameters.EmptySearchFilterParametersNotAllowedException;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchPaginationParametersNotAllowedException;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchParametersNotAllowedException;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchSortParametersNotAllowedException;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchServiceTest {

	private static Stream<Arguments> generateParameterStream(BiConsumer<SearchService, SearchParameters> action) {
		SearchFilterParameters mockedEmptyFilterParameters = mock(SearchFilterParameters.class, CALLS_REAL_METHODS);
		when(mockedEmptyFilterParameters.isEmpty()).thenReturn(Boolean.TRUE);

		SearchFilterParameters mockedNotEmptyFilterParameters = mock(SearchFilterParameters.class, CALLS_REAL_METHODS);
		when(mockedNotEmptyFilterParameters.isEmpty()).thenReturn(Boolean.FALSE);

		SearchPaginationParameters mockedEmptyPaginationParameters = mock(SearchPaginationParameters.class, CALLS_REAL_METHODS);
		when(mockedEmptyPaginationParameters.getPageNumber()).thenReturn(null);
		when(mockedEmptyPaginationParameters.getPageSize()).thenReturn(null);

		SearchPaginationParameters mockedNotEmptyPaginationParameters = mock(SearchPaginationParameters.class, CALLS_REAL_METHODS);
		when(mockedNotEmptyPaginationParameters.getPageNumber()).thenReturn(1);
		when(mockedNotEmptyPaginationParameters.getPageSize()).thenReturn(1);

		SearchSortParameters mockedEmptySortParameters = mock(SearchSortParameters.class, CALLS_REAL_METHODS);
		when(mockedEmptySortParameters.getSortCodes()).thenReturn(null);
		when(mockedEmptySortParameters.getSortDirections()).thenReturn(null);

		SearchSortParameters mockedNotEmptySortParameters = mock(SearchSortParameters.class, CALLS_REAL_METHODS);
		when(mockedNotEmptySortParameters.getSortCodes()).thenReturn(new String[] {"code"});
		when(mockedNotEmptySortParameters.getSortDirections()).thenReturn(new String[] {"asc"});

		SearchParameters nullSearchParameters = null;
		SearchParameters mockedSearchParametersWithNoProperties = mock(SearchParameters.class, CALLS_REAL_METHODS);

		SearchParameters mockedSearchParametersWithFilterProperties = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithFilterProperties.getFilterParameters()).thenReturn(mockedNotEmptyFilterParameters);
		when(mockedSearchParametersWithFilterProperties.getPaginationParameters()).thenReturn(mockedEmptyPaginationParameters);
		when(mockedSearchParametersWithFilterProperties.getSortParameters()).thenReturn(mockedEmptySortParameters);

		SearchParameters mockedSearchParametersWithPaginationProperties = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithPaginationProperties.getFilterParameters()).thenReturn(mockedEmptyFilterParameters);
		when(mockedSearchParametersWithPaginationProperties.getPaginationParameters()).thenReturn(mockedNotEmptyPaginationParameters);
		when(mockedSearchParametersWithPaginationProperties.getSortParameters()).thenReturn(mockedEmptySortParameters);

		SearchParameters mockedSearchParametersWithSortProperties = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithSortProperties.getFilterParameters()).thenReturn(mockedEmptyFilterParameters);
		when(mockedSearchParametersWithSortProperties.getPaginationParameters()).thenReturn(mockedEmptyPaginationParameters);
		when(mockedSearchParametersWithSortProperties.getSortParameters()).thenReturn(mockedNotEmptySortParameters);

		SearchParameters mockedSearchParametersWithAllProperties = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithAllProperties.getFilterParameters()).thenReturn(mockedNotEmptyFilterParameters);
		when(mockedSearchParametersWithAllProperties.getPaginationParameters()).thenReturn(mockedNotEmptyPaginationParameters);
		when(mockedSearchParametersWithAllProperties.getSortParameters()).thenReturn(mockedNotEmptySortParameters);

		return Stream.of(
			//case: null search parameters - empty search parameters not allowed
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, false, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, false, null, true, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, true, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, true, null, true, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, false, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, false, null, true, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, true, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, true, null, true, null),

			//case: null search parameters - empty search parameters allowed
			Arguments.of(action, nullSearchParameters, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, nullSearchParameters, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, nullSearchParameters, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, nullSearchParameters, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, nullSearchParameters, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: null search parameters - empty search parameters allowed - bad fallbacks
			Arguments.of(action, nullSearchParameters, true, EmptySearchParametersNotAllowedException.class, true, null, false, null, false, null, false, null),
			Arguments.of(action, nullSearchParameters, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedEmptySortParameters),
			Arguments.of(action, nullSearchParameters, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, nullSearchParameters, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null but empty search parameters - empty search parameters not allowed
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, false, null, true, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, true, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, false, null, true, null, true, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, false, null, true, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, true, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, false, null, true, null, true, null, true, null),

			//case: not null but empty search parameters - empty search parameters allowed
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null but empty search parameters - empty search parameters allowed - bad fallbacks
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchParametersNotAllowedException.class, true, null, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithNoProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with filter search parameters - empty search parameters not allowed
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, false, null, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, false, null, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchSortParametersNotAllowedException.class, false, null, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, false, null, false, null, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, false, null, true, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, false, null, true, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchSortParametersNotAllowedException.class, false, null, true, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, false, null, false, null, true, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with filter search parameters - empty search parameters allowed
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, false, null, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithFilterProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with pagination search parameters - empty search parameters not allowed
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchSortParametersNotAllowedException.class, false, null, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchSortParametersNotAllowedException.class, false, null, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with pagination search parameters - empty search parameters allowed
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, true, EmptySearchSortParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithPaginationProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with sort search parameters - empty search parameters not allowed
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, false, null, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchPaginationParametersNotAllowedException.class, false, null, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchPaginationParametersNotAllowedException.class, false, null, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithSortProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with sort search parameters - empty search parameters allowed
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchFilterParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, true, EmptySearchPaginationParametersNotAllowedException.class, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithSortProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithSortProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with all search parameters - empty search parameters not allowed
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, false, null, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),

			//case: not null with all search parameters - empty search parameters allowed
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, false, null, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, false, null, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, false, null, true, mockedNotEmptySortParameters),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, false, null),
			Arguments.of(action, mockedSearchParametersWithAllProperties, false, null, true, mockedSearchParametersWithNoProperties, true, mockedNotEmptyFilterParameters, true, mockedNotEmptyPaginationParameters, true, mockedNotEmptySortParameters)
		);
	}

	private static Stream<Arguments> count_parametrized_argument_provider(){
		return generateParameterStream((searchService, searchParameters) -> searchService.count(searchParameters));
	}

	private static Stream<Arguments> search_parametrized_argument_provider(){
		return generateParameterStream((searchService, searchParameters) -> searchService.search(searchParameters));
	}

	@ParameterizedTest(name = "{index} | Empty allowed: SP {3} F {5} P {7} S {9} | Exception Expected: {1}")
	@MethodSource(value = {"count_parametrized_argument_provider", "search_parametrized_argument_provider"})
	<K extends Class<Throwable>> void do_with_parameters(
		BiConsumer<SearchService, SearchParameters> action,
		final SearchParameters fixtureSearchParameters,
		boolean isExceptionExpected,
		final K exceptionClass,
		boolean isEmptySearchParametersAllowed,
		SearchParameters fallbackSearchParameters,
		boolean isEmptyFilterPropertyAllowed,
		SearchFilterParameters fallbackFilterParameters,
		boolean isEmptyPaginationPropertyAllowed,
		SearchPaginationParameters fallbackPaginationParameters,
		boolean isEmptySortPropertyAllowed,
		SearchSortParameters fallbackSortParameters
	) {
		AbstractSearchService fixtureSearchService = mock(AbstractSearchService.class, CALLS_REAL_METHODS);

		//given
		lenient().when(fixtureSearchService.isSearchWithEmptySearchParametersAllowed()).thenReturn(isEmptySearchParametersAllowed);
		lenient().when(fixtureSearchService.getFallbackSearchParametersInstance()).thenReturn(fallbackSearchParameters);

		lenient().when(fixtureSearchService.isSearchWithEmptySearchFilterParametersAllowed()).thenReturn(isEmptyFilterPropertyAllowed);
		lenient().when(fixtureSearchService.getFallbackSearchFilterParametersInstance()).thenReturn(fallbackFilterParameters);

		lenient().when(fixtureSearchService.isSearchWithEmptySearchPaginationParametersAllowed()).thenReturn(isEmptyPaginationPropertyAllowed);
		lenient().when(fixtureSearchService.getFallbackSearchPaginationParametersInstance()).thenReturn(fallbackPaginationParameters);

		lenient().when(fixtureSearchService.isSearchWithEmptySearchSortParametersAllowed()).thenReturn(isEmptySortPropertyAllowed);
		lenient().when(fixtureSearchService.getFallbackSearchSortParametersInstance()).thenReturn(fallbackSortParameters);

		//when
		Executable executable = () -> action.accept(fixtureSearchService, fixtureSearchParameters);

		if(isExceptionExpected){
			Throwable exception = assertThrows(exceptionClass, executable);
			assertNotNull(exception);
		} else {
			assertDoesNotThrow(executable);
		}

		//then

		int isSearchWithEmptySearchParametersAllowedInvokeTimes = 0;
		int getFallbackSearchParametersInstanceInvokeTimes = 0;

		int isSearchWithEmptyFilterParametersAllowedInvokeTimes = 0;
		int getFallbackFilterParametersInstanceInvokeTimes = 0;

		int isSearchWithEmptyPaginationParametersAllowedInvokeTimes = 0;
		int getFallbackPaginationParametersInstanceInvokeTimes = 0;

		int isSearchWithEmptySortParametersAllowedInvokeTimes = 0;
		int getFallbackSortParametersInstanceInvokeTimes = 0;

		SearchParameters safeSearchParams = fixtureSearchParameters;

		boolean isSearchParametersEmpty = SearchParameters.isEmpty(fixtureSearchParameters);
		if(isSearchParametersEmpty){
			isSearchWithEmptySearchParametersAllowedInvokeTimes = 1;

			if(isEmptySearchParametersAllowed) {
				safeSearchParams = fixtureSearchService.getFallbackSearchParametersInstance();
				getFallbackSearchParametersInstanceInvokeTimes = 2; //one for the method, one for us
			}
		}

		boolean validationContinues = !isSearchParametersEmpty || (isEmptySearchParametersAllowed && SearchParameters.isNotNull(safeSearchParams));
		if(validationContinues){
			SearchFilterParameters filterParameters = safeSearchParams.getFilterParameters();
			boolean isFilterEmpty = SearchFilterParameters.isEmpty(filterParameters);

			if(isFilterEmpty){
				isSearchWithEmptyFilterParametersAllowedInvokeTimes = 1;

				if(isEmptyFilterPropertyAllowed){
					filterParameters = fixtureSearchService.getFallbackSearchFilterParametersInstance();
					getFallbackFilterParametersInstanceInvokeTimes = 2;
				}
			}

			validationContinues = !isFilterEmpty || (isEmptyFilterPropertyAllowed && SearchFilterParameters.isNotEmpty(filterParameters));
			if(validationContinues){
				SearchPaginationParameters paginationParameters = safeSearchParams.getPaginationParameters();
				boolean isPaginationEmpty = SearchPaginationParameters.isEmpty(paginationParameters);

				if(isPaginationEmpty){
					isSearchWithEmptyPaginationParametersAllowedInvokeTimes = 1;

					if(isEmptyPaginationPropertyAllowed){
						paginationParameters = fixtureSearchService.getFallbackSearchPaginationParametersInstance();
						getFallbackPaginationParametersInstanceInvokeTimes = 2;
					}
				}

				validationContinues = !isPaginationEmpty || (isEmptyPaginationPropertyAllowed && SearchPaginationParameters.isNotEmpty(paginationParameters));
				if(validationContinues){
					SearchSortParameters sortParameters = safeSearchParams.getSortParameters();
					boolean isSortEmpty = SearchSortParameters.isEmpty(sortParameters);

					if(isSortEmpty){
						isSearchWithEmptySortParametersAllowedInvokeTimes = 1;

						if(isEmptySortPropertyAllowed){
							getFallbackSortParametersInstanceInvokeTimes = 1;
						}
					}
				}
			}
		}

		verify(fixtureSearchService, times(isSearchWithEmptySearchParametersAllowedInvokeTimes)).isSearchWithEmptySearchParametersAllowed();
		verify(fixtureSearchService, times(getFallbackSearchParametersInstanceInvokeTimes)).getFallbackSearchParametersInstance();

		verify(fixtureSearchService, times(isSearchWithEmptyFilterParametersAllowedInvokeTimes)).isSearchWithEmptySearchFilterParametersAllowed();
		verify(fixtureSearchService, times(getFallbackFilterParametersInstanceInvokeTimes)).getFallbackSearchFilterParametersInstance();

		verify(fixtureSearchService, times(isSearchWithEmptyPaginationParametersAllowedInvokeTimes)).isSearchWithEmptySearchPaginationParametersAllowed();
		verify(fixtureSearchService, times(getFallbackPaginationParametersInstanceInvokeTimes)).getFallbackSearchPaginationParametersInstance();

		verify(fixtureSearchService, times(isSearchWithEmptySortParametersAllowedInvokeTimes)).isSearchWithEmptySearchSortParametersAllowed();
		verify(fixtureSearchService, times(getFallbackSortParametersInstanceInvokeTimes)).getFallbackSearchSortParametersInstance();
	}

}