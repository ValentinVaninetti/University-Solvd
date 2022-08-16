package com.solvd.exceptions;

public class UnknownBookException extends RuntimeException{
    public UnknownBookException(){
        super("Book doesn't belongs to this library");
    }
}
