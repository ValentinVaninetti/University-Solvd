package com.solvd.exceptions;

public class StatusNotAllowedException extends RuntimeException{
    public StatusNotAllowedException(String message, Throwable cause){
        super(message ,cause);
    }
}
