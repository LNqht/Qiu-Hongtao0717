<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09-03-2022
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post" action="register"><!--action to link jsp  to servlet -->
    Username <input type="text" name="username" /><br/>
    password <input type="password" name="password" /><br/>
    Email <input type="text" name="email" /><br/>

    Gender <input type="radio" name="gender" value="male">male <input type="radio" name="gender" value="female">Female <br/>
    Birth Date <input type="text" name="birthDate" />(yyyy-mm-dd)<br/>
    <input type="submit" value="Register"/>

</form>
<%@ include file="footer.jsp"%>
