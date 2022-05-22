package com.fis.exception;

public class DuplicateAccountException extends RuntimeException {

	public DuplicateAccountException() {
        super("이미 존재하는 계좌번호입니다.");
    }
	public DuplicateAccountException(String msg) {
        super(msg);
    }
}