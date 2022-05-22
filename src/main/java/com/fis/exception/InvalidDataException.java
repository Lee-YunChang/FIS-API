package com.fis.exception;

public class InvalidDataException extends RuntimeException {

	public InvalidDataException() {
        super("유효하지 않은 데이터입니다.");
    }
	public InvalidDataException(String msg) {
        super(msg);
    }
}