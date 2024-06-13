package com.dedalus.setup.exception;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Provider
@Slf4j
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception t) {
        log.error("Request failed", t);
        return Response.status(INTERNAL_SERVER_ERROR.getStatusCode())
            .entity(mapResponse(t))
            .build();
    }

    public static ExceptionResponse mapResponse(Exception e) {
        return ExceptionResponse.builder()
            .message(e.getMessage())
            .build();
    }

}
