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
<h1>상세보기 페이지</h1>
<hr>
<c:choose>
	<c:when test="${sessionScope.userid == s.pid}">
<form action="/board/update" method="post">
    <input type="hidden" name="bid" value="${s.bid}">
    작성자: <input type="text" name="pid" value="${s.pid}" readonly><br>
    제목: <input type="text" name="title" value="${s.title}"><br>
    내용: <textarea name="content" rows="5" cols="40">${s.content}</textarea><br>
    작성날짜<input type="text" value="${s.createdat}" readonly>
    수정날짜<input type="text" value="${s.updatedat}" readonly>
    <input type="submit" value="수정">
    <a href="delete?bid=${s.bid}" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
	<a href="list">목록</a>
</form>
</c:when>
<c:otherwise>
	작성자: <input type="text" name="pid" value="${s.pid}" readonly><br>
    제목: <input type="text" name="title" value="${s.title}"><br>
    내용: <textarea name="content" rows="5" cols="40">${s.content}</textarea><br>
    작성날짜<input type="text" value="${s.createdat}" readonly>
    수정날짜<input type="text" value="${s.updatedat}" readonly>
    <a href="list">목록</a>
</c:otherwise>
</c:choose>
<h1>댓글</h1>
<hr>
</body>
</html>