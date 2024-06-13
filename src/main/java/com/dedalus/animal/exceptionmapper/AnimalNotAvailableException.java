package com.dedalus.animal.exceptionmapper;

public class AnimalNotAvailableException extends IllegalArgumentException {
    public AnimalNotAvailableException() {
        super("Das Tier steht zur Adoption nicht zur Verfügung");
    }
}
