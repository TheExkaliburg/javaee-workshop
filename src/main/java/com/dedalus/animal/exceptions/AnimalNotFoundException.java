package com.dedalus.animal.exceptions;

import com.dedalus.core.exceptions.DedalusHttpException;

import javax.ws.rs.core.Response;

public class AnimalNotFoundException extends DedalusHttpException {

    public AnimalNotFoundException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }
}
