<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>インデックス画面</title>
    </head>
    <body>
        <h1>ようこそ、${pageContext.request.userPrincipal.name}さん！</h1>
        <a href="./admin">管理者専用画面へ</a>
        <hr>
        <form action="${pageContext.request.contextPath}/api/logout" method="post">
            <input type="submit" value="ログアウト">
        </form>
    </body>
</html>
