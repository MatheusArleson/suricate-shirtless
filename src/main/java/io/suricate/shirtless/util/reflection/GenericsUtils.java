package io.suricate.shirtless.util.reflection;

import lombok.NonNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Optional;

public final class GenericsUtils {

	private GenericsUtils() {}

	public static Optional<Type> getGenericType(@NonNull Class<?> clazz, int genericsIndex) {
		if (genericsIndex < 0) {
			throw new IllegalArgumentException("Generics index must be greater than zero.");
		}

		Type genericSuperclass = clazz.getGenericSuperclass();
		if(!(genericSuperclass instanceof ParameterizedType)){
			return Optional.empty();
		}

		ParameterizedType genericSuperclassParameterizedType = (ParameterizedType) genericSuperclass;
		Type[] actualTypeArguments = genericSuperclassParameterizedType.getActualTypeArguments();

		if (genericsIndex > actualTypeArguments.length) {
			return Optional.empty();
		}

		Type actualTypeArgument = actualTypeArguments[genericsIndex];
		return Optional.of(actualTypeArgument);
	}

	@SuppressWarnings("unchecked")
	public static <T> Optional<T[]> getAllEnumMembers(@NonNull Class<?> clazz, int genericsIndex) {
		Optional<Type> declaredEnumTypeOpt = getGenericType(clazz, genericsIndex);
		if (!declaredEnumTypeOpt.isPresent()) {
			throw new IllegalStateException("Unable to get enum class from generics.");
		}

		Type declaredEnumType = declaredEnumTypeOpt.get();
		Class<T> declaredEnumClass = (Class<T>) declaredEnumType;
		T[] enumConstants = declaredEnumClass.getEnumConstants();

		return Optional.ofNullable(enumConstants);
	}


}
