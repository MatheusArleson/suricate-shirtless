package io.suricate.shirtless.service;

import io.suricate.shirtless.exceptions.search.parameters.EmptySearchFilterParametersNotAllowed;
import io.suricate.shirtless.exceptions.search.parameters.EmptySearchParametersNotAllowed;
import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSearchServiceTest {

	private AbstractSearchService fixtureSearchService;
	private ArgumentCaptor<SearchParameters> searchParametersArgumentCaptor;

	@BeforeEach
	void setup(){
		fixtureSearchService = mock(AbstractSearchService.class, CALLS_REAL_METHODS);
		searchParametersArgumentCaptor = ArgumentCaptor.forClass(SearchParameters.class);
	}

	private static Stream<Arguments> count_parametrized_argument_provider() {
		SearchFilterParameters mockedFilterParameters = mock(SearchFilterParameters.class, CALLS_REAL_METHODS);
		SearchPaginationParameters mockedPaginationParameters = mock(SearchPaginationParameters.class, CALLS_REAL_METHODS);
		SearchSortParameters mockedSortParameters = mock(SearchSortParameters.class, CALLS_REAL_METHODS);

		SearchParameters nullSearchParameters = null;
		SearchParameters mockedSearchParametersWithNoProperties = mock(SearchParameters.class, CALLS_REAL_METHODS);

		SearchParameters mockedSearchParametersWithOnlyFilterParams = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithOnlyFilterParams.getFilterParameters()).thenReturn(mockedFilterParameters);

		SearchParameters mockedSearchParametersWithOnlyPaginationParams = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithOnlyPaginationParams.getPaginationParameters()).thenReturn(mockedPaginationParameters);

		SearchParameters mockedSearchParametersWithOnlySortParams = mock(SearchParameters.class, CALLS_REAL_METHODS);
		when(mockedSearchParametersWithOnlySortParams.getSortParameters()).thenReturn(mockedSortParameters);

		return Stream.of(
			//case 1 - null search parameters - empty search parameters not allowed
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, false, null, false, null, false, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, false, null, false, null, true, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, false, null, true, null, false, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, false, null, true, null, true, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, true, null, false, null, false, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, true, null, false, null, true, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, true, null, true, null, false, null),
//			Arguments.of(nullSearchParameters, true, EmptySearchParametersNotAllowed.class, false, null, true, null, true, null, true, null),
			//case 2 - null search parameters - empty search parameters allowed
			Arguments.of(nullSearchParameters, true, EmptySearchFilterParametersNotAllowed.class, true, mockedSearchParametersWithNoProperties, false, null, false, null, false, null)
//			Arguments.of(nullSearchParameters, true, EmptySearchFilterParametersNotAllowed.class, true, false, false, true),
//			Arguments.of(nullSearchParameters, true, EmptySearchFilterParametersNotAllowed.class, true, false, true, false),
//			Arguments.of(nullSearchParameters, true, EmptySearchFilterParametersNotAllowed.class, true, false, true, true),
//			Arguments.of(nullSearchParameters, true, EmptySearchPaginationParametersNotAllowed.class, true, true, false, false),
//			Arguments.of(nullSearchParameters, true, EmptySearchPaginationParametersNotAllowed.class, true, true, false, true),
//			Arguments.of(nullSearchParameters, true, EmptySearchSortParametersNotAllowed.class, true, true, true, false)
//			Arguments.of(nullSearchParameters, false, null, true, true, true, true)
		);
	}

	//TODO junit only runs the setup method ONCE before executing this test
	//TODO solve problem on tracking invocations
	@ParameterizedTest(name = "{index} | Empty allowed: SP {3} F {4} P {5} S {6} | Exception Expected: {1}")
	@MethodSource(value = "count_parametrized_argument_provider")
	<K extends Class<Throwable>> void count_parametrized(
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
		if(isExceptionExpected){
			Throwable exception = assertThrows(exceptionClass, () -> fixtureSearchService.count(fixtureSearchParameters));
			assertNotNull(exception);
		} else {
			assertDoesNotThrow(() -> fixtureSearchService.count(fixtureSearchParameters));
		}

		//then
		verify(fixtureSearchService).count(searchParametersArgumentCaptor.capture());
		assertSame(fixtureSearchParameters, searchParametersArgumentCaptor.getValue());

		int searchParamsGetFilterInvokeTimes = 0;
		int searchParamsGetPaginationInvokeTimes = 0;
		int searchParamsGetSortInvokeTimes = 0;

		int isSearchWithEmptySearchParametersAllowedInvokeTimes = 0;
		int getFallbackSearchParametersInstanceInvokeTimes = 0;

		int isSearchWithEmptyFilterParametersAllowedInvokeTimes = 0;
		int getFallbackFilterParametersInstanceInvokeTimes = 0;

		int isSearchWithEmptyPaginationParametersAllowedInvokeTimes = 0;
		int getFallbackPaginationParametersInstanceInvokeTimes = 0;

		int isSearchWithEmptySortParametersAllowedInvokeTimes = 0;
		int getFallbackSortParametersInstanceInvokeTimes = 0;

		//compute invoke times
		if(Objects.nonNull(fixtureSearchParameters)){
			searchParamsGetFilterInvokeTimes = 1;
			searchParamsGetPaginationInvokeTimes = 1;
			searchParamsGetSortInvokeTimes = 1;
		}

		if(SearchParameters.isEmpty(fixtureSearchParameters)){
			isSearchWithEmptySearchParametersAllowedInvokeTimes = 1;
		}

		SearchParameters safeSearchParams = fixtureSearchParameters;
		if(isEmptySearchParametersAllowed){
			getFallbackSearchParametersInstanceInvokeTimes = 1;
			safeSearchParams = fixtureSearchService.getFallbackSearchParametersInstance();

			if(SearchFilterParameters.isEmpty(safeSearchParams.getFilterParameters()) && isEmptyFilterPropertyAllowed){
				isSearchWithEmptyFilterParametersAllowedInvokeTimes = 1;
				getFallbackFilterParametersInstanceInvokeTimes = 1;
			}

			if(SearchPaginationParameters.isEmpty(safeSearchParams.getPaginationParameters()) && isEmptyPaginationPropertyAllowed){
				isSearchWithEmptyPaginationParametersAllowedInvokeTimes = 1;
				getFallbackPaginationParametersInstanceInvokeTimes = 1;
			}

			if(SearchSortParameters.isEmpty(safeSearchParams.getSortParameters()) && isEmptySortPropertyAllowed){
				isSearchWithEmptySortParametersAllowedInvokeTimes = 1;
				getFallbackSortParametersInstanceInvokeTimes = 1;
			}
		}

		if(Objects.nonNull(fixtureSearchParameters)){
			verify(safeSearchParams, times(searchParamsGetFilterInvokeTimes)).getFilterParameters();
			verify(safeSearchParams, times(searchParamsGetPaginationInvokeTimes)).getPaginationParameters();
			verify(safeSearchParams, times(searchParamsGetSortInvokeTimes)).getSortParameters();
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