package com.spring.exception;

public class ErrorResponse extends Exception {

    private String errMsg;

    public ErrorResponse(String msg) {
        super(msg);
    }
}
