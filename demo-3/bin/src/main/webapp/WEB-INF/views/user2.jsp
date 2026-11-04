<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AJAX VERSION</h1>
	<hr>

	<div>
		아이디:<input type="text" id="userid" /> 
		성명: <input type="text" id="username" />
	</div>
	<div>
		<button type="button" id="selectUser">조회</button>
		<button type="button" id="updateUser">수정</button>
		<button type="button" id="deleteUser">삭제</button>
	</div>
	<table border="1">


		<tr>
			<th>no</th>
			<th>userid</th>
			<th>username</th>
		</tr>
		<tbody id="userTable"></tbody>
	</table>
	<script>
	function selectUser(){
		fetch('/s/users')
			.then(function(response){
				return response.json();
			})
			.then(function (users) {
				const tbbody = document.getElementById("userTable");
				tbbody.innerHTML = '';

				//DOM 트리 
				users.forEach(function (user,i){
					tbbody.innerHTML += '<tr>'
					+ '<td>' + (i + 1) + '</td>'
					+ '<td>' + user.userid +'</td>'
					+ '<td>' + user.username+'</td>'
					+ '</tr>';
				});
			});
	}
	
	function updateUser(){
		const userid = document.getElementById("userid").value;
		const username = document.getElementById("username").value;

		fetch('/s/update', {
			method: 'POST',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: new URLSearchParams({ userid: userid, username: username })
		})
			.then(function(response){
				return response.text();
			})
			.then(function (result){
				if(result === '수정 성공'){
					alert('수정 완료');
					selectUser();
				}
			});
	}
	
	function deleteUser(){
		const userid = document.getElementById("userid").value;
		const username = document.getElementById("username").value;
		
		fetch('/s/delete',{
			method: 'POST',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body: new URLSearchParams({ userid: userid, username: username })
		})
		.then(function(response){
			return response.text();
		});
		.then(function(result){
			if(result === '삭제 성공'){
				alert('삭제 완료');
				deleteUser();
			}
		});
	}
	</script>
</body>
</html>