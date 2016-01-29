package com.example.rest.resource;

import java.net.URI;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tada
 */
@Path("logout")
public class LogoutResource {
    
    @Context
    private HttpServletRequest httpServletRequest;
    @Context
    private UriInfo uriInfo;
    
    @POST
    public Response logout() throws ServletException {
        // ログアウト
        httpServletRequest.logout();
        // セッション破棄
        HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            session.invalidate();
        }
        // ログイン画面にリダイレクト
        URI loginPage = uriInfo.getBaseUriBuilder()
                .path(LoginResource.class)
                .build();
        return Response.status(Response.Status.SEE_OTHER)
                .location(loginPage)
                .build();
    }
}
