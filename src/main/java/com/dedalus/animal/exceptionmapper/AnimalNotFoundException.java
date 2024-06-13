package com.dedalus.animal.exceptionmapper;

import javax.ws.rs.NotFoundException;

public class AnimalNotFoundException extends NotFoundException {
    public AnimalNotFoundException() {
        super("Das Tier wurde nicht gefunden");
    }
}
