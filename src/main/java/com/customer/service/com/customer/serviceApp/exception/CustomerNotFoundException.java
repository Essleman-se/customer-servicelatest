package com.customer.service.com.customer.serviceApp.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super((message));
    }
}
