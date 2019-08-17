
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>@SessionAttribute使用</title>
</head>
<body>
<%--  获取request域中的msg--%>
  msg:${msg} <br/>
<%--获取session域--%>
 session域：${sessionScope}<br/>
</body>
</html>
