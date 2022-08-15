<%--
  Created by IntelliJ IDEA.
  User: jiaji
  Date: 2020/7/12
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数绑定--%>
<%--<a href="parma/test?username=mixin">请求参数绑定</a>--%>
<%--<a href="parma/test2?username=mixin&password=123456">请求参数绑定获取账号密码</a>--%>

        <%--把数据封装Account类中--%>
<%--    <form action="parma/test3" method="post">
        姓名: <input type="text" name="username"><br>&lt;%&ndash;name  的值跟实体类的名字要一致&ndash;%&gt;
        密码: <input type="text" name="password"><br>
        金额: <input type="text" name="money"><br>
        用户姓名: <input type="text" name="user.uname"><br>&lt;%&ndash;这个用  user.   是因为account表中有user表所以想获取user表的就需要 . &ndash;%&gt;
        用户年龄: <input type="text" name="user.age"><br>
        <input type="submit" value="提交">
    </form>--%>

<%--把数据封装Account类中,类中存再List和map集合--%>
<form action="parma/test3" method="post">
    姓名: <input type="text" name="username"><br><%--name  的值跟实体类的名字要一致--%>
    密码: <input type="text" name="password"><br>
    金额: <input type="text" name="money"><br>

    用户姓名: <input type="text" name="list[0].uname"><br><%--这个是存list集合的  list[0].uname--%>
    用户年龄: <input type="text" name="list[0].age"><br>

    用户姓名: <input type="text" name="map['one'].uname"><br>
    用户年龄: <input type="text" name="map['one'].age"><br>
    日期: <input type="text" name="date"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
