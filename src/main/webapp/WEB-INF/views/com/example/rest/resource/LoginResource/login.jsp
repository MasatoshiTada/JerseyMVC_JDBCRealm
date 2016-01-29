<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
        <c:if test="${not empty param['retry']}">
            <p>ログインIDまたはパスワードが違います。</p>
        </c:if>
        <form action="./login" method="post">
            ログインID:<input type="text" name="loginId"><br>
            パスワード:<input type="password" name="password"><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
