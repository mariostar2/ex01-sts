<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>VIEW PAGE</h1>
	<hr>
	<form action="/update" method="post">
		번호:<input type="text" name="id" value="${bbs.id}" readonly><br>
		작성자:<input type="text" name="write" value="${bbs.writer}" readonly><br>
		제목: <input type="text" name="title" value="${bbs.title}"><br>
		내용: <input type="text" name="content" value="${bbs.content}"><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>