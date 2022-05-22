package com.fis.exception;

public class InvalidAccountException extends RuntimeException {

	public InvalidAccountException() {
        super("존재하지않는 계좌입니다.");
    }
	public InvalidAccountException(String msg) {
        super(msg);
    }
}