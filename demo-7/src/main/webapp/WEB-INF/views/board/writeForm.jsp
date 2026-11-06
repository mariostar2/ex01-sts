<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<c:choose>
<h1>작성 폼</h1>
<hr>
<c:when test="${sessionScope.userid == pid}">
<form action="/board/write" method="post">
    작성자: <input type="text" name="pid"><br>
    제목: <input type="text" name="title"><br>
    내용: <input type="text" name="content"><br>
    <input type="submit" value="등록">
</form>
</c:when>
</c:choose>
</body>
</html>