package io.suricate.shirtless.exceptions.search.parameters;

import lombok.NonNull;

public class EmptyParameterNotAllowedException extends RuntimeException {

	public EmptyParameterNotAllowedException(@NonNull String message) {
		super(message);
	}

	public EmptyParameterNotAllowedException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}
}
