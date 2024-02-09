package com.chele.workshopmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    
    public ObjectNotFoundException() {
        super("Oject not found");
    }
}
