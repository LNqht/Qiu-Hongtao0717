<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 4/5/2021
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
<h1> User Info</h1>
<%
    /*Cookie [] allCookies=request.getCookies();
    for(Cookie c:allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+" --- "+c.getValue());
    }*/
    User u=(User) session.getAttribute("user");

%>
<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr><tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
</tr><tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
</tr><tr>
    <td>Gender:</td><td><%=u.getGender()%></td>
</tr><tr>
    <td>Birth Date:</td><td><%=u.getBirthDate()%></td>
</tr>

</table>
<a href="updateUser.jsp">Update</a>

<%@include file="footer.jsp"%>