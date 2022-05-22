package com.fis.exception;

public class InvalidUserException extends RuntimeException {

	public InvalidUserException() {
        super("존재하지 않는 사용자입니다.");
    }
	public InvalidUserException(String msg) {
        super(msg);
    }
}