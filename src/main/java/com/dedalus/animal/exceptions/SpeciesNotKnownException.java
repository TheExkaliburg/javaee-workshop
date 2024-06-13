package com.dedalus.animal.exceptions;

import com.dedalus.core.exceptions.DedalusHttpException;

import javax.ws.rs.core.Response;

public class SpeciesNotKnownException extends DedalusHttpException {
    public SpeciesNotKnownException(String message) {
        super(message, Response.Status.BAD_REQUEST);
    }
}
