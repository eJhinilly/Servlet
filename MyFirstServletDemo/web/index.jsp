<%--
  Created by IntelliJ IDEA.
  User: localhost
  Date: 17-6-12
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>第一个servlet小例子</title>
</head>
<body>
<h1>第一个servlet小例子</h1>
<hr />
<a href="servlet/HelloServlet">Get方式请求HelloServlet</a><br />
<form action="servlet/HelloServlet" method="post">
  <input type="submit" value="Post方式提交HelloServlet"/>
</form>
</body>
</html>