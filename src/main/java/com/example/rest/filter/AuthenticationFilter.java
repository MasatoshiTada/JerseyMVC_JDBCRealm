package com.example.rest.filter;

import com.example.rest.filter.binding.Authenticated;
import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author tada
 */
@Provider
@Authenticated // このアノテーションが付いているメソッドにのみ、このフィルターが適用される
@Priority(Priorities.AUTHENTICATION) // 優先度をAUTHENTICATION(=1000)にする
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext securityContext = requestContext.getSecurityContext();
        if (securityContext.getUserPrincipal() == null) {
            throw new NotAuthorizedException("not login");
        }
    }
    
}
