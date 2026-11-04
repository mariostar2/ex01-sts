<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>User Update Form</h1>
<hr>
<form action="/update" method="post">
	번호:<input type ="text" name = "userid" value="${user.userid}" >
	이름:<input type="text" name ="username" value="${user.username }">
	<input type="submit" value="수정">
</form>
</body>
</html>