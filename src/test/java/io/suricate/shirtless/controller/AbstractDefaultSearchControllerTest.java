package io.suricate.shirtless.controller;

import io.suricate.shirtless.service.SearchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class AbstractDefaultSearchControllerTest {

	@Test
	void noArgsConstructor_shouldThrowException_whenServiceArgumentIsNull(){
		//given
		final SearchService fixtureSearchService = null;

		//when
		NullPointerException exception = assertThrows(
			NullPointerException.class,
			() -> new AbstractDefaultSearchController(fixtureSearchService){}
		);

		//then
		assertNull(fixtureSearchService);
		assertNotNull(exception);
	}

	@Test
	void noArgsConstructor_shouldThrowException_whenServiceArgumentIsNotNull(@Mock SearchService fixtureSearchService){
		//given

		//when
		AbstractDefaultSearchController controller = assertDoesNotThrow(
			() -> new AbstractDefaultSearchController(fixtureSearchService) {}
		);

		//then
		assertNotNull(fixtureSearchService);
		assertNotNull(controller);
	}

}