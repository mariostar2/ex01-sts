<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index page</h1>
<hr>
<a href="writeform">등록</a>
<table>
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>작성자</td>
		<td>제목</td>
	</tr>
		<c:forEach var ="s" items="${list}">
			<tr>
				<td><a href="updateform?id=${s.id}">${s.id}</a></td>
				<td>${s.writer }</td>
				<td>${s.title}</td>
				<td>${s.content}</td>
			</tr>
		</c:forEach>
</table>
</body>
</html>