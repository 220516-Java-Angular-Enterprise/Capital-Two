package com.revature.CapitalTwo.util.custom_exceptions;

public class InvalidPaswordException extends RuntimeException{
    public InvalidPaswordException(String message){
        super(message);
    }
}
