package com.example.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 *
 * @author tada
 */
@ApplicationPath("api")
public class MyResourceConfig extends ResourceConfig {
    public MyResourceConfig() {
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/views/");
        packages(true, this.getClass().getPackage().getName());
        register(RolesAllowedDynamicFeature.class);
    }
}
