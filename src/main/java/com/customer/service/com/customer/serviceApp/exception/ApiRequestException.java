package com.customer.service.com.customer.serviceApp.exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message){
        super(message);
    }
    public ApiRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
