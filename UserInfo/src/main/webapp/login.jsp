<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/UserInfo/loggingIn" method="post">
ID:<input type="text" name="id" value="${id}"/>
Password:<input type="text" name="pass" />
<input type="submit" value="login"> 
</form>
</body>
</html>