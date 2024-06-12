package com.dedalus.core.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DedalusExceptionMapper implements ExceptionMapper<DedalusHttpException> {
    @Override
    public Response toResponse(DedalusHttpException e) {
        return e.getResponse();
    }
}
