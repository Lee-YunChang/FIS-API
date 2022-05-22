package com.fis.exception;

import com.fis.domain.response.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponsee =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponsee, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateAccountException.class)
    public final ResponseEntity<Object> handleInvalidAccountException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponsee =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponsee, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override //메서드를 재정의하겠다!
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

}