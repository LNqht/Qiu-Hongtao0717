<%@ page import="com.qiuhongtao.lab3.CalServlet" %><%--
  Created by IntelliJ IDEA.
  User: 涛
  Date: 2022-05-29
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>2020211001000717-QiuHongtao</h2>
<script>
    function judg(){
        if(isNaN(document.getElementById("first").value) || isNaN((document.getElementById("second")).value)){
            myForm.action="";
            myForm.submit();
            alert("not number");
        }
    }
    function judg1(){
        if( !isNaN(document.getElementById("name").value)){
            myForm.action="";
            myForm.submit();
            alert("not string");
        }
    }
</script>
<form id="myForm" name="myForm" method="post" action="CalServlet">
    <table>
        <tr>
            <td>First Val:</td>
            <td><input type="text" id="first" name="first" value="${cookie.first.value}"></td>
            <td>Enter a Name:</td>
            <td><input type="text" id="name" name="name" value="${cookie.name.value}"></td>
        </tr>
        <tr>
            <td>Second Val:</td>
            <td><input type="text" id="second" name="second" value="${cookie.second.value}"></td>
            <td>Length:</td>
            <td><input type="text" name="length" value="${cookie.length.value}"></td>
        </tr>
        <tr>
            <td>Result:</td>
            <td><input type="text" name="result" value="${cookie.result.value}"></td>
        </tr>
    </table>
    <input type="submit" name="action" value="Add" onclick="judg()">
    <input type="submit" name="action" value="Subtract" onclick="judg()">
    <input type="submit" name="action" value="Multiply" onclick="judg()">
    <input type="submit" name="action" value="Divide" onclick="judg()">
    <input type="submit" name="action" value="Compute Length" onclick="judg1()">
</form>
<input type="submit" name="action" value="Reset" onclick="document.getElementById('myForm').reset()">
</body>
</html>
