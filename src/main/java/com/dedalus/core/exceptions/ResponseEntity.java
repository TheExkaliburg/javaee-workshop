package com.dedalus.core.exceptions;

import lombok.Data;

import java.io.PrintWriter;
import java.io.StringWriter;

@Data
public class ResponseEntity {

    private String message;
    private String stackTrace;

    public ResponseEntity(RuntimeException e) {
        message = e.getMessage();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        stackTrace = sw.toString();
    }

}
