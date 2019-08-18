<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json响应示例</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn1").click(function () {
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax1",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"张三","password":"123456","age":"23"}',
                    dateType:"json",
                    type:"post",
                    success:function(data){
                        //data服务器端相应的json数据，进行解析
                    }
                })
            })
        })
    </script>

    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn2").click(function () {
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax2",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"张三","password":"123456","age":"23"}',
                    dateType:"json",
                    type:"post",
                    success:function(data){
                        //data服务器端相应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            })
        })
    </script>

</head>
<body>
<button id="btn1">发送ajax的请求</button>
<button id="btn2">发送ajax的请求，后台使用jackson解析</button>

</body>
</html>
