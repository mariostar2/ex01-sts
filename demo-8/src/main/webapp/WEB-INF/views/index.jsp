<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ajax page</h1>
<hr>
<form id ="test01">
	아아디:<input type= "text" name = "id">
	비밀번호:<input type ="password" name= "pw">
	<hr>
	<button type="button" onclick ="select()">버튼!</button>
<script src="${pageContext.request.contextPath}/js/testjsp.js"></script>

<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>		
	</tr>
</table>

<div id="result"></div>
</form>
</body>
</html>