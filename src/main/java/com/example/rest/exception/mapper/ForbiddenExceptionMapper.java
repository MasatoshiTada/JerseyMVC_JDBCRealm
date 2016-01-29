package com.example.rest.exception.mapper;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Provider
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException exception) {
        return Response.status(exception.getResponse().getStatusInfo())
                .entity(new Viewable("/error/403")).build();
    }
    
}
