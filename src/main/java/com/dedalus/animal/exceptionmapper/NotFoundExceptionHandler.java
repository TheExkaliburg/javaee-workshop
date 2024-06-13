package com.dedalus.animal.exceptionmapper;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        int statusCode = Response.Status.NOT_FOUND.getStatusCode();
        DedalusErrorObject errorObject = new DedalusErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStackTrace(e.getStackTrace().toString());
        errorObject.setDetail(e.getLocalizedMessage());

        return Response.status(statusCode)
                .entity(errorObject)
                .build();
    }
}
