<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User List Page</h1>
	<hr>
	<table>
		<tr>
			<th>no</th>
			<th>userid</th>
			<th>username</th>
			<th>삭제</th>
		</tr>
		<!-- 반복 시작  -->
		<c:forEach var="user" items="${userList}" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.userid}</td>
				<td>${user.username}</td>
				<td><button type="button" onclick="location.href='/updateform?userid=${user.userid}'">수정</button></td>  
				<td><form action="/delete" method="post" onsubmit="return confirm('삭제하시겠습니까?')">
    <input type="hidden" name="userid" value="${user.userid}">
    <input type="submit" value="삭제">
</form></td>
			</tr>
		</c:forEach> 
		<!--반복 끝  -->
	</table>
</body>
</html>