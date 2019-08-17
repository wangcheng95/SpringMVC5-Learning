<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用请求注解测试</title>
</head>
<body>

<h3>testRequestParam</h3><br/>
<a href="/testRequestParam?name=张三">testRequestParam</a> <br/>

<h3>testRequestBody</h3><br/>
<form action="/testRequestBody" method="post">
    用户姓名：<input type="text" name="name" /> <br>
    用户年龄：<input type="text" name="age" /> <br>
    <input type="submit" value = "提交"/>
</form>

<h3>testRequestBody</h3><br/>
<a href="/testPathVariable/5">testPathVariable</a>

<h3>testRequestHeader</h3>  <br/>
<a href="/testRequestHeader">testRequestHeader</a>

<h3>testCookieValue</h3>  <br/>
<a href="/testCookieValue">testCookieValue</a>

<h3>testModelAttribute1</h3>  <br/>
<form action="/testModelAttribute1" method="post">
    用户姓名：<input type="text" name="name" /> <br>
    用户年龄：<input type="text" name="age" /> <br>
    <input type="submit" value = "提交"/>
</form>
<h3>testModelAttribute2</h3>  <br/>
<form action="/testModelAttribute2" method="post">
    用户姓名：<input type="text" name="name" /> <br>
    用户年龄：<input type="text" name="age" /> <br>
    <input type="submit" value = "提交"/>
</form>

<h3>testSessionAttribute</h3>  <br/>
<a href="/testSessionAttribute">产生sessionAttribute</a>
<a href="/testSessionAttribute/getmsg">获取sessionAttribute的共享值</a>
<a href="/testSessionAttribute/del_session">清除session</a>

</body>
</html>
