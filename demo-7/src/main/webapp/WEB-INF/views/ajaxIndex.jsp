<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ajax Index Page</h1>
<hr>
<p>Test0 -<span id ="test0"></span></p> 
<button type ="button" onclick="test0Run()">테스트0</button>

<p>Test1 -<span id ="test1"></span></p> 
<input type ="text" id="writer" value="Ann">
<input type ="text" id="message" value="Good!">
<button type ="button" onclick="test1Run()">테스트1</button>

<form id ="frm">
	<p>Test2 - <span id ="test2"></span></p> 
	<input type ="text" name="writer" value="Tom">
	<input type ="text" name="message" value="Bad!">
	<button type ="button" onclick="test2Run()">테스트2</button>
</form>

<form id ="frm">
	<p>Test3 - <span id ="test3"></span></p> 
	
	<button type ="button" onclick="test3Run()">테스트3</button>
</form>
<script src="/js/ajax_script.js">
	
</script>

</body>
</html>