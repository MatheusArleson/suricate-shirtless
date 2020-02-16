package io.suricate.shirtless.util.reflection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Type;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class GenericsUtilsTest {

	@Test
	void getGenericArgumentClass_shouldThrowException_whenClassArgumentIsNull() {
		//given
		Class<?> fixtureClass = null;
		int fixtureGenericsIndex = 0;

		//when
		NullPointerException exception = assertThrows(
			NullPointerException.class,
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertNotNull(exception);
	}

	@Test
	void getGenericArgumentClass_shouldNotThrowException_whenClassArgumentIsNotNull() {
		//given
		Collection<Integer> aParametrizedType = Collections.singleton(1);
		Class<?> fixtureClass = aParametrizedType.getClass();
		int fixtureGenericsIndex = 0;

		//when
		Optional<Type> fixtureResult = assertDoesNotThrow(
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertTrue(fixtureResult.isPresent());
	}

	@Test
	void getGenericArgumentClass_shouldThrowException_whenGenericIndexArgumentIsLessThanZero() {
		//given
		Class<?> fixtureClass = Object.class;
		int fixtureGenericsIndex = -1;

		//when
		IllegalArgumentException exception = assertThrows(
			IllegalArgumentException.class,
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertTrue(fixtureGenericsIndex < 0);
		assertNotNull(exception);
	}

	@Test
	void getGenericArgumentClass_shouldNotThrowException_whenGenericIndexArgumentIsEqualToZero() {
		//given
		Collection<Integer> aParametrizedType = Collections.singleton(1);
		Class<?> fixtureClass = aParametrizedType.getClass();
		int fixtureGenericsIndex = 0;

		//when
		Optional<Type> fixtureResult = assertDoesNotThrow(
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertEquals(fixtureGenericsIndex, 0);
		assertTrue(fixtureResult.isPresent());
	}

	@Test
	void getGenericArgumentClass_shouldNotThrowException_whenGenericIndexArgumentIsGreaterThanZero() {
		//given
		Map<Integer, Integer> aDoubleParametrizedType = new LinkedHashMap<>();
		Class<?> fixtureClass = aDoubleParametrizedType.getClass();
		int fixtureGenericsIndex = 1;

		//when
		Optional<Type> fixtureResult = assertDoesNotThrow(
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertTrue(fixtureGenericsIndex > 0);
		assertTrue(fixtureResult.isPresent());
	}

	@Test
	void getGenericArgumentClass_shouldReturnEmptyOptional_whenGenericIndexArgumentIsOutOfClassGenericsCount() {
		//given
		Collection<Integer> aParametrizedType = Collections.singleton(1);
		Class<?> fixtureClass = aParametrizedType.getClass();
		int fixtureGenericsIndex = 1;

		//when
		Optional<Type> fixtureResult = assertDoesNotThrow(
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertTrue(fixtureGenericsIndex > 0);
		assertFalse(fixtureResult.isPresent());
	}

	@Test
	void getGenericArgumentClass_shouldNotReturnEmptyOptional_whenGenericIndexArgumentIsInsideOfClassGenericsCount() {
		//given
		Collection<Integer> aParametrizedType = Collections.singleton(1);
		Class<?> fixtureClass = aParametrizedType.getClass();
		int fixtureGenericsIndex = 0;

		//when
		Optional<Type> fixtureResult = assertDoesNotThrow(
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertEquals(fixtureGenericsIndex, 0);
		assertTrue(fixtureResult.isPresent());
	}

	@Test
	void getGenericArgumentClass_shouldReturnEmptyOptional_whenClassIsNotParametrized() {
		//given
		Class<?> fixtureClass = Object.class;
		int fixtureGenericsIndex = 0;

		//when
		Optional<Type> fixtureResult = assertDoesNotThrow(
			() -> GenericsUtils.getGenericArgumentClass(fixtureClass, fixtureGenericsIndex)
		);

		//then
		assertNotNull(fixtureClass);
		assertNotNull(fixtureGenericsIndex);
		assertEquals(fixtureGenericsIndex, 0);
		assertFalse(fixtureResult.isPresent());
	}

}