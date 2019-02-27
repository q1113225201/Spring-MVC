<%--
  Created by IntelliJ IDEA.
  User: 10886
  Date: 2019/2/27
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" enctype="multipart/form-data" method="post">
    <input type="text" placeholder="desc" name="desc"/><br>
    <input type="file" name="file"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
