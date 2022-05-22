package com.fis.exception;

public class AuthorizationHeaderNotExistsException extends RuntimeException {
	private static final long serialVersionUID = -7285236784084776913L;

	public AuthorizationHeaderNotExistsException(String message) {
        super(message);
    }
}