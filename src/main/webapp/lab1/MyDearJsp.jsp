<%@ page import="java.util.Enumeration" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 涛
  Date: 2022-05-20
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsingServlet</title>
</head>
<body>
<h1>2020211001000717------QiuHongtao</h1>
<h3>request.getParameter()、request.getParameterNames()、request.getWriter()</h3>
<%
    Enumeration p=request.getParameterNames();
    while(p.hasMoreElements()){
        String name=(String) p.nextElement();
        String value=request.getParameter(name);
        out.print(name + ":" + value);
        out.print("</br>");
    }
%>
<hr>
<h3>EL</h3>
name:${param.name}  </br>
class:${param.Class}    </br>
id:${param.ID}  </br>
submit:${param.submit}  </br>
</body>
</html>
