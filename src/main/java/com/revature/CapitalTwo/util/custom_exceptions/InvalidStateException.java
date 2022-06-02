package com.revature.CapitalTwo.util.custom_exceptions;

public class InvalidStateException extends RuntimeException{
    public InvalidStateException(String message){
        super(message);
    }
}
