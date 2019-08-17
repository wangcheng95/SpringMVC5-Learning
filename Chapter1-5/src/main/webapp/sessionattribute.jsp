
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>@SessionAttribute使用</title>
</head>
<body>
<%--  获取request域中的msg--%>
  ${msg}
<%--获取session域--%>
 ${sessionScope}

<a href="/anno8/getmsg">获取sessionAttribute的共享值</a>
<a href="/anno8/del_session">清除session</a>
</body>
</html>
