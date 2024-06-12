package com.dedalus.animal.exceptions;

import com.dedalus.core.exceptions.DedalusHttpException;

import javax.ws.rs.core.Response;

public class AlreadyAdoptedException extends DedalusHttpException {

    public AlreadyAdoptedException(String message) {
        super(message, Response.Status.CONFLICT);
    }
}
