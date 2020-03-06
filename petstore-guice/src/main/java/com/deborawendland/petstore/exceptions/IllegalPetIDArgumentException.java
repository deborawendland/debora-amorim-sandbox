package com.deborawendland.petstore.exceptions;

public class IllegalPetIDArgumentException extends RuntimeException {

    public IllegalPetIDArgumentException (String error) {
        super(error);
    }
}
