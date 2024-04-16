package com.cliente.rest.CrudBasicRest.excepciones;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
