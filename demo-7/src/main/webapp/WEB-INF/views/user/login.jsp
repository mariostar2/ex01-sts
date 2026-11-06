<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 폼</h1>
	<p style="color: red">${msg}</p>
	<hr>
	<form action="/login" method="post">
		아이디:<input type="text" name="id"> 
		비밀번호<input type="password" name="pw"> 
		<input type="submit" value="로그인">
	</form>
	<a href="/user/signUpForm">회원 가입 하러가기</a>
</body>
</html>