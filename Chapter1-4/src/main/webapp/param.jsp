
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数绑定</title>
</head>
<body>

<a href="/test1">请求参数绑定入门</a><br/>
 <a href="/test2?name=zhangsan&&id=8">传入普通变量</a><br/>
<h3>saveAccount</h3>
<form action="/saveAccount" method="post">
    姓名：<input type="text" name="username" /> <br/>
    密码：<input type="password" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>
    用户姓名：<input type="text" name="user.uname" /> <br/>
    用户年龄：<input type="text" name="user.age" /> <br/>
    <input type="submit" value="提交" /> <br/>
</form>

<a href="/date?date=2019-08-11">自定义类型转换器</a><br/>

</body>
</html>
