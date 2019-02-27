<%--
  Created by IntelliJ IDEA.
  User: 10886
  Date: 2019/2/27
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            console.log("ready")
            $("#btn_post").click(function () {
                console.log("click")
                $.post("${pageContext.request.contextPath}/json/list",null,function (data) {
                    $.each(data,function () {
                        $("#result").append(this.username+","+this.password+"<br>");
                    })
                },"json");
            })
        });

    </script>
</head>
<body>
<button id="btn_post">post</button>
<p id="result"></p>
</body>
</html>
