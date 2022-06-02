package com.revature.CapitalTwo.util.custom_exceptions;

public class InvalidAddressException extends RuntimeException{
    public InvalidAddressException(String message){
        super(message);
    }
}
