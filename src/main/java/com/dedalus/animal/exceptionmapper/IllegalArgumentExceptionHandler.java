package com.dedalus.animal.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionHandler implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        int statusCode = Response.Status.BAD_REQUEST.getStatusCode();
        DedalusErrorObject errorObject = new DedalusErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStackTrace(e.getStackTrace().toString());
        errorObject.setDetail(e.getLocalizedMessage());

        return Response.status(statusCode)
                .entity(errorObject)
                .build();
    }
}
