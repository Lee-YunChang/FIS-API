package com.fis.exception;

public class InvalidContractInformationException extends RuntimeException{
    public InvalidContractInformationException() {
        super("등록된 계약정보가 없습니다.");
    }
    public InvalidContractInformationException(String msg) {
        super(msg);
    }
}
