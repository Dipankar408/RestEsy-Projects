<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" import="com.db.Customer" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/UserInfo/save" method="post">
	ID:<input type="text" name="id"/>
	Name:<input type="text" name="name"/>
	Age:<input type="text" name="age"/>
	Number:<input type="text" name="number"/><br><br>
	City:<input type="text" name="city"/>
	District:<input type="text" name="dist"/>
	State:<input type="text" name="state"/>
	PinCode:<input type="text" name="pin"/><br>
	Password:<input type="text" name="pass"/><br>
 	<input type="submit">
	</form>
	<a href="/UserInfo/login/${1}">Login</a>
	<br><br><br>
	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Contact</th>
			<th>City</th>
			<th>District</th>
			<th>State</th>
			<th>PinCode</th>
		</tr>
		<c:forEach items="${clist}" var="customer">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.age}</td>
			<td>${customer.number}</td>
			<td>${customer.getAdr().city}</td>
			<td>${customer.getAdr().district}</td>
			<td>${customer.getAdr().state}</td>
			<td>${customer.getAdr().pincode}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>