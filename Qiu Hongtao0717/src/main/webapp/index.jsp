<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<<<<<<< HEAD
<%@page import="java.util.*" %>
<%@include file="header.jsp"%>
<%!
    public void jspInit(){
        System.out.println("ininit()");
}
%>
<!-- service-->
=======
>>>>>>> 83ee8aca3d8128f1a9d628659b3a552cf40227b0
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<<<<<<< HEAD
<h1><%= "Hello World!" %><% System.out.println("service");%>
    Date and Time<%out.print(new Date());%>
=======
<h1><%= "Hello World!!!" %>
>>>>>>> 83ee8aca3d8128f1a9d628659b3a552cf40227b0
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
<<<<<<< HEAD
</html>
<!-- end of service-->
<%!
    public void jspDestroy(){
        System.out.println("jspDestroy()");
    }
%>
<%@include file="footer.jsp"%>
=======
</html>
>>>>>>> 83ee8aca3d8128f1a9d628659b3a552cf40227b0
