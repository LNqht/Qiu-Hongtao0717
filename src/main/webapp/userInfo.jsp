<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/5/2021
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<h1> User Info</h1>

<table>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr><tr>
        <td>Password:</td><td><%=request.getAttribute("password")%></td>
</tr><tr>
        <td>Email:</td><td><%=request.getAttribute("email")%></td>
</tr><tr>
    <td>Gender:</td><td><%=request.getAttribute("gender")%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=request.getAttribute("birthDate")%></td>
</tr>

</table>

<%@include file="footer.jsp"%>
