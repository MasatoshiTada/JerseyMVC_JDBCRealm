<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>401エラー</title>
    </head>
    <body>
        <p>ログインしていません。</p>
        <a href="${pageContext.request.contextPath}/api/login">ログイン画面へ</a>
    </body>
</html>
