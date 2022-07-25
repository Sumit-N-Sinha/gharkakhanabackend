package com.Gharkakhana.exception;

public class VendorNotFoundException extends RuntimeException{
    public VendorNotFoundException(String message) {
        super(message);
    }
}
