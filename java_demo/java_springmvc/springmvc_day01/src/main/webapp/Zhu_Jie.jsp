<%--
  Created by IntelliJ IDEA.
  User: jiaji
  Date: 2020/7/13
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注解</title>
</head>
<body>
<%--
常用的注解
                           因为用了RequestParam注解必须传值                                                --%>
<a href="zhujie/RequestParam?name=哈哈">RequestParam</a><br>
<form action="zhujie/RequestBody" method="post">
    姓名: <input type="text" name="name"><br>
    年龄: <input type="text" name="age"><br>
    <input type="submit" value="提交">

</form>
<a href="zhujie/PathVariable/10">PathVariable</a><br>
</body>
</html>
