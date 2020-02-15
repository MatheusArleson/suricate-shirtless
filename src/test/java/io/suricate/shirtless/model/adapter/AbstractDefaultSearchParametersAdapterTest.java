package io.suricate.shirtless.model.adapter;

import io.suricate.shirtless.model.adapter.filter.SearchFilterParametersAdapter;
import io.suricate.shirtless.model.adapter.pagination.SearchPaginationParametersAdapter;
import io.suricate.shirtless.model.adapter.sort.SearchSortParametersAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractDefaultSearchParametersAdapterTest {

	@Test
	void constructor_shouldThrowException_whenFilterAdapterArgumentIsNull(){
		//given
		final SearchFilterParametersAdapter filterAdapter = null;
		final SearchPaginationParametersAdapter paginationAdapter = mock(SearchPaginationParametersAdapter.class);
		final SearchSortParametersAdapter sortAdapter = mock(SearchSortParametersAdapter.class);

		//when
		NullPointerException exception = assertThrows(
			NullPointerException.class,
			() -> new AbstractDefaultSearchParametersAdapter(
				filterAdapter, paginationAdapter, sortAdapter
			){}
		);

		//then
		assertNull(filterAdapter);
		assertNotNull(paginationAdapter);
		assertNotNull(sortAdapter);
		assertNotNull(exception);
	}

	@Test
	void constructor_shouldThrowException_whenPaginationAdapterArgumentIsNull(){
		//given
		final SearchFilterParametersAdapter filterAdapter = mock(SearchFilterParametersAdapter.class);
		final SearchPaginationParametersAdapter paginationAdapter = null;
		final SearchSortParametersAdapter sortAdapter = mock(SearchSortParametersAdapter.class);

		//when
		NullPointerException exception = assertThrows(
			NullPointerException.class,
			() -> new AbstractDefaultSearchParametersAdapter(
					filterAdapter, paginationAdapter, sortAdapter
			){}
		);

		//then
		assertNull(paginationAdapter);
		assertNotNull(filterAdapter);
		assertNotNull(sortAdapter);
		assertNotNull(exception);
	}

	@Test
	void constructor_shouldThrowException_whenSortAdapterArgumentIsNull(){
		//given
		final SearchFilterParametersAdapter filterAdapter = mock(SearchFilterParametersAdapter.class);
		final SearchPaginationParametersAdapter paginationAdapter = mock(SearchPaginationParametersAdapter.class);
		final SearchSortParametersAdapter sortAdapter = null;

		//when
		NullPointerException exception = assertThrows(
			NullPointerException.class,
			() -> new AbstractDefaultSearchParametersAdapter(
					filterAdapter, paginationAdapter, sortAdapter
			){}
		);

		//then
		assertNull(sortAdapter);
		assertNotNull(filterAdapter);
		assertNotNull(paginationAdapter);
		assertNotNull(exception);
	}

	@Test
	void constructor_shouldNotThrowException_whenAllArgumentsAreNotNull(){
		//given
		final SearchFilterParametersAdapter filterAdapter = mock(SearchFilterParametersAdapter.class);
		final SearchPaginationParametersAdapter paginationAdapter = mock(SearchPaginationParametersAdapter.class);
		final SearchSortParametersAdapter sortAdapter = mock(SearchSortParametersAdapter.class);

		//when
		AbstractDefaultSearchParametersAdapter searchParametersAdapter = assertDoesNotThrow(
			() -> new AbstractDefaultSearchParametersAdapter(
					filterAdapter, paginationAdapter, sortAdapter
			) {}
		);

		//then
		assertNotNull(filterAdapter);
		assertNotNull(paginationAdapter);
		assertNotNull(sortAdapter);
		assertNotNull(searchParametersAdapter);
	}

}