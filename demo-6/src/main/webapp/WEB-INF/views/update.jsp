<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세페이지</h1>
	<hr>
	<form action="/update" method="post">
		번호:<input type="text" name="id" value="${s.id}"> 
		작성자:<input type="text" name="writer" value="${s.writer}"> 
		제목<input type="text" name="title" value="${s.title }">
		글<input type="text" name="content" value="${s.content}">
		<input type="submit" value="이동">
	</form>
</body>
</html>