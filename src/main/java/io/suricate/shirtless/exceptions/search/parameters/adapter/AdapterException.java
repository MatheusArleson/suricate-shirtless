package io.suricate.shirtless.exceptions.search.parameters.adapter;

import lombok.NonNull;

public class AdapterException extends RuntimeException {

	public AdapterException(@NonNull String message) {
		super(message);
	}

	public AdapterException(@NonNull String message, @NonNull Throwable cause) {
		super(message, cause);
	}

}
