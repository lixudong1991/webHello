<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/hello/SessionTest" method="post">
        用户名:<input type="text" name="username"/><br/>
        <input type="hidden" name="token" value="${token}"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
