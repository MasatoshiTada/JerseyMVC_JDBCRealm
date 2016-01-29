package com.example.rest.exception.mapper;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Provider
public class NotAuthorizedExceptionMapper implements ExceptionMapper<NotAuthorizedException> {

    @Override
    public Response toResponse(NotAuthorizedException exception) {
        return Response.status(exception.getResponse().getStatusInfo())
                .entity(new Viewable("/error/401")).build();
    }
    
}
