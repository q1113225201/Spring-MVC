<%--
  Created by IntelliJ IDEA.
  User: SJL
  Date: 2019/2/26
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
GET:<br>
name = ${requestScope.name}<br>
${requestScope.time}
<br>
Path:<br>
id = ${requestScope.id}
<br>
Post Query:<br>
username = ${requestScope.username}<br>
password = ${requestScope.password}<br>
<br>
<br>
${requestScope.user.username}----
user = ${requestScope.user}<br>
<br>
</body>
</html>
