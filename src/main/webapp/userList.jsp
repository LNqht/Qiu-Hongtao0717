<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 3/27/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ResultSet rs=(ResultSet) request.getAttribute("rsname");
    out.println("<html><title></title><body><table border=1><tr>");
    out.println("<td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td><tr/>");
    while(rs.next()){
//get one by one
        out.println("<tr>");
        out.println("<td>"+rs.getString("username")+"</td>");
        out.println("<td>"+rs.getString("password")+"</td>");
        out.println("<td>"+rs.getString("email")+"</td>");
        out.println("<td>"+rs.getString("gender")+"</td>");
        out.println("<td>"+rs.getString("birthdate")+"</td>");

        out.println("</tr>");


    }
    out.println("</table></body></html>");

%>

</body>
</html>
