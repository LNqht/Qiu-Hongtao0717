<%--
  Created by IntelliJ IDEA.
  User: 涛
  Date: 2022-05-20
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyJsp</title>
</head>
<body>
<h3>i am MyJsp.jsp</h3>
<form method="post" action="MyDearServletURL">
    name <input type="text" name="name"></br>
    class <input type="text" name="Class"></br>
    ID <input type="text" name="ID"></br>
    <button type="submit" name="submit" value="Send data to server">Send data to server</button>
</form>
<form method="post" action="MyDearJsp.jsp">
    name <input type="text" name="name"></br>
    class <input type="text" name="Class"></br>
    ID <input type="text" name="ID"></br>
    <button type="submit" name="submit" value="Send data to server">Send data to server</button>
</form>
</body>
</html>
