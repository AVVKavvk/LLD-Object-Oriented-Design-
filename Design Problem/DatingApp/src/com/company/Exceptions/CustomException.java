package com.company.Exceptions;

public class CustomException extends  Exception{
    public CustomException() {
        super("User not found");
    }

    // Constructor that accepts a custom error message
    public CustomException(String message) {
        super(message);
    }
}
