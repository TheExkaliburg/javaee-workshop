package com.dedalus.setup.exception;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
@Slf4j
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException t) {
        log.error("Request failed", t);
        return Response.status(BAD_REQUEST.getStatusCode())
            .entity(GenericExceptionMapper.mapResponse(t))
            .build();
    }

}
