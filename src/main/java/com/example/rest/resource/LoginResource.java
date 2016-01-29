package com.example.rest.resource;

import java.net.URI;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Path("login")
public class LoginResource {
    
    @Context
    private SecurityContext securityContext;
    @Context
    private UriInfo uriInfo;
    @Context
    private HttpServletRequest httpServletRequest;
    
    @GET
    public Viewable index() {
        return new Viewable("login");
    }
    
    @POST
    public Response login(@FormParam("loginId") String loginId,
            @FormParam("password") String password) {
        // 未ログインならばログイン処理を行う
        if (securityContext.getUserPrincipal() == null) {
            System.out.println("ログイン処理開始...");
            try {
                // コンテナにログイン
                httpServletRequest.login(loginId, password);
                System.out.println("ログイン処理成功！！");
            } catch (ServletException ex) {
                System.out.println("ログイン失敗");
                // ログイン失敗時はログイン画面に戻る
                URI loginPage = uriInfo.getBaseUriBuilder()
                        .path(this.getClass())
                        .queryParam("retry", Boolean.TRUE)
                        .build();
                return Response.status(Response.Status.SEE_OTHER)
                        .location(loginPage)
                        .build();
            }
        }
        // ログイン成功時はインデックス画面に遷移
        URI indexPage = uriInfo.getBaseUriBuilder()
                .path(SecretResource.class)
                .path("index")
                .build();
        return Response.status(Response.Status.FOUND)
                .location(indexPage)
                .build();
    }

}
