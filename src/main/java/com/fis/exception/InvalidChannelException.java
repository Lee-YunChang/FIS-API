package com.fis.exception;

public class InvalidChannelException extends RuntimeException {

	public InvalidChannelException() {
        super("존재하지않는 유튜브 채널입니다.");
    }
	public InvalidChannelException(String msg) {
        super(msg);
    }
}