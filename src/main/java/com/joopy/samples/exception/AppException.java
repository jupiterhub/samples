package com.joopy.samples.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

public class AppException extends WebApplicationException {
    
    public AppException () {
        super(Response.status(Response.Status.BAD_REQUEST).entity("Sample").build());
    }
    
}