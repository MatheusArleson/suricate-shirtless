package io.suricate.shirtless.util.reflection;

import lombok.NonNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public class GenericsUtils {

	public static Optional<Type> getGenericType(@NonNull Class<?> aClass, int genericsIndex) {
		if(genericsIndex < 0){
			throw new IllegalArgumentException("Generics index must be greater than zero.");
		}

		ParameterizedType genericSuperclass = (ParameterizedType) aClass.getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();

		if(genericsIndex > actualTypeArguments.length){
			throw new IllegalArgumentException("Generics index is out of bounds.");
		}

		Type actualTypeArgument = actualTypeArguments[genericsIndex];
		return Optional.of(actualTypeArgument);
	}
}
