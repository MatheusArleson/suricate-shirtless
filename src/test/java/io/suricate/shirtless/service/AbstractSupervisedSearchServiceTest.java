package io.suricate.shirtless.service;

import io.suricate.shirtless.model.parameter.SearchParameters;
import io.suricate.shirtless.model.parameter.filter.SearchFilterParameters;
import io.suricate.shirtless.model.parameter.pagination.SearchPaginationParameters;
import io.suricate.shirtless.model.parameter.sort.SearchSortParameters;
import io.suricate.shirtless.service.params.supervisor.SearchParametersSupervisor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractSupervisedSearchServiceTest {

	private SearchParametersSupervisor supervisor;
	private AbstractSupervisedSearchService supervisedSearchService;

	@BeforeEach
	private void setup(){
		this.supervisor = mock(SearchParametersSupervisor.class, CALLS_REAL_METHODS);

		this.supervisedSearchService = mock(
			AbstractSupervisedSearchService.class,
			Mockito.withSettings()
				.useConstructor(this.supervisor)
				.defaultAnswer(CALLS_REAL_METHODS)
		);
	}

	@Test
	void isSearchWithEmptySearchParametersAllowed_shouldDelegateToSupervisor() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		fixtureService.isSearchWithEmptySearchParametersAllowed();

		//then
		verify(fixtureSupervisor, times(1)).isSearchWithEmptySearchParametersAllowed();
		verify(fixtureService, times(1)).isSearchWithEmptySearchParametersAllowed();
	}

	@Test
	void isSearchWithEmptySearchFilterParametersAllowed_shouldDelegateToSupervisor() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		fixtureService.isSearchWithEmptySearchFilterParametersAllowed();

		//then
		verify(fixtureSupervisor, times(1)).isSearchWithEmptySearchFilterParametersAllowed();
		verify(fixtureService, times(1)).isSearchWithEmptySearchFilterParametersAllowed();
	}

	@Test
	void isSearchWithEmptySearchPaginationParametersAllowed_shouldDelegateToSupervisor() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		fixtureService.isSearchWithEmptySearchPaginationParametersAllowed();

		//then
		verify(fixtureSupervisor, times(1)).isSearchWithEmptySearchPaginationParametersAllowed();
		verify(fixtureService, times(1)).isSearchWithEmptySearchPaginationParametersAllowed();
	}

	@Test
	void isSearchWithEmptySearchSortParametersAllowed_shouldDelegateToSupervisor() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		fixtureService.isSearchWithEmptySearchSortParametersAllowed();

		//then
		verify(fixtureSupervisor, times(1)).isSearchWithEmptySearchSortParametersAllowed();
		verify(fixtureService, times(1)).isSearchWithEmptySearchSortParametersAllowed();
	}

	@Test
	void getFallbackSearchParametersInstance_shouldDelegateToSupervisor() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		SearchParameters fallback = fixtureService.getFallbackSearchParametersInstance();

		//then
		verify(fixtureSupervisor, times(1)).getFallbackSearchParametersInstance();
		verify(fixtureService, times(1)).getFallbackSearchParametersInstance();
	}

	@Test
	void getFallbackSearchFilterParametersInstance() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		SearchFilterParameters fallback = fixtureService.getFallbackSearchFilterParametersInstance();

		//then
		verify(fixtureSupervisor, times(1)).getFallbackSearchFilterParametersInstance();
		verify(fixtureService, times(1)).getFallbackSearchFilterParametersInstance();
	}

	@Test
	void getFallbackSearchPaginationParametersInstance() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		SearchPaginationParameters fallback = fixtureService.getFallbackSearchPaginationParametersInstance();

		//then
		verify(fixtureSupervisor, times(1)).getFallbackSearchPaginationParametersInstance();
		verify(fixtureService, times(1)).getFallbackSearchPaginationParametersInstance();
	}

	@Test
	void getFallbackSearchSortParametersInstance() {
		//given
		SearchParametersSupervisor fixtureSupervisor = this.supervisor;
		AbstractSupervisedSearchService fixtureService = this.supervisedSearchService;

		//when
		SearchSortParameters fallback = fixtureService.getFallbackSearchSortParametersInstance();

		//then
		verify(fixtureSupervisor, times(1)).getFallbackSearchSortParametersInstance();
		verify(fixtureService, times(1)).getFallbackSearchSortParametersInstance();
	}
}