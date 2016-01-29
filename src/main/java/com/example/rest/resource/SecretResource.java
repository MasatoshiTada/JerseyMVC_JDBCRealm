package com.example.rest.resource;

import com.example.rest.filter.binding.Authenticated;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Path("secret")
@Authenticated
public class SecretResource {
    
    @GET
    @Path("index")
    @PermitAll
    public Viewable index() {
        return new Viewable("index");
    }
    
    @GET
    @Path("admin")
    @RolesAllowed("ADMINISTRATOR")
    public Viewable admin() {
        return new Viewable("admin");
    }
    
}
