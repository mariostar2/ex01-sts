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
<h1>List page (총${count}개)</h1>
<hr>
<a href="writeform">글쓰기</a>
<table>
	<tr>
		<th>번호</th><th>작성자</th><th>제목</th><th>내용</th><th>삭제</th>
<c:forEach var ="dto" items="${bbsList }">
	<tr>
		<td><a href="/view?id=${dto.id}">${dto.id }</a></td> 
		<td>${dto.writer }</td>		
		<td>${dto.title }</td>
		<td>${dto.content }</td>
		<td><a href="/delete?id=${dto.id}">삭제</a></td>
	</tr>
</c:forEach>
	</tr>
</table>
<hr>
<form action = "writeCom" method="get" >
	<select name ="type">
		<option value="title">제목</option>
		<option value="writer">작성자</option>
		<option value="content">내용</option>
	</select>
	<input type ="text" name = "kxeyword">
	<input type ="submit" value= "검색">	
</form>
</body>
</html>