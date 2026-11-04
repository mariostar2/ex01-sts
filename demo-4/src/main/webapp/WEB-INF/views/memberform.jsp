<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 회원등록</title>
</head>
<body>
<h1>쇼핑몰 등록페이지</h1>
<hr>
<form name="frm" action="/member" method="post">
	<table border="1">
		<tr>
			<td>회원번호(자동생성)</td>
			<td><input type="text" name="custno" readonly></td>
		</tr>
		<tr>
			<td>회원성명</td>
			<td><input type="text" name="custname"></td>
		</tr>
		<tr>
			<td>회원전화</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td>가입일자</td>
			<td><input type="text" name="joindate"></td>
		</tr>
		<tr>
			<td>고객등급</td>
			<td>
				<select name="grade">
					<option value="">등급선택</option>
					<option value="A">VIP</option>
					<option value="B">일반</option>
					<option value="C">직원</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
			</td>
		</tr>
	</table>
</form>

</body>
</html>