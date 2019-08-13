<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>绑定实体参数</title>
</head>
<body>
<form action="saveAccount" method="post">
    姓名：<input type="text" name="username" /> <br/>
    密码：<input type="password" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>
    用户姓名：<input type="text" name="user.uname" /> <br/>
    用户年龄：<input type="text" name="user.age" /> <br/>
    <input type="submit" value="提交" /> <br/>
</form>

</body>
</html>
