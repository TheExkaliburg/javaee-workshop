package com.dedalus.core.exceptions;

import lombok.Getter;

import javax.ws.rs.core.Response;

@Getter
public class DedalusHttpException extends RuntimeException {
    private Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;

    public DedalusHttpException(String message) {
        super(message);
    }

    public DedalusHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public DedalusHttpException(Throwable cause) {
        super(cause);
    }

    public DedalusHttpException(Response.Status httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }

    public DedalusHttpException(String message, Response.Status httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public DedalusHttpException(String message, Throwable cause, Response.Status httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public DedalusHttpException(Throwable cause, Response.Status httpStatus) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    public Response getResponse() {
        return Response.status(httpStatus)
                .entity(new ResponseEntity(this))
                .build();
    }
}
