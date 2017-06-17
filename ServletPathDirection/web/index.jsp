<%--
  Created by IntelliJ IDEA.
  User: localhost
  Date: 17-6-15
  Time: 下午3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>Servlet路径跳转</title>
  </head>
  <body>
  <h1>Servlet路径跳转</h1>
  <hr>
  <!--使用相对路径访问HelloServlet-->
  <!-- /servlet/HelloServlet 第一个/表示服务器的根目录 -->
  <a href="servlet/HelloServlet" >访问HelloServlet</a><br>
  <!-- 使用绝对路径 访问HelloServlet,可以使用path变量:path变量表示项目的根目录-->
  path为<%=path%> basepath为<%=basePath%><br>
  <a href="<%=path%>/servlet/HelloServlet">访问HelloServlet!</a><br>
  <!--表单中action的URL地址写法，与超链接方式完全相同。 -->
  <a href="servlet/TestServlet">访问TestServlet,跳转到Test.jsp</a>
  </body>
</html>
