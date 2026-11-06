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
	<h1>List Page</h1>
	<hr>
	<c:choose>
		<c:when test="${not empty sessionScope.userid}">
        ${sessionScope.username}님 환영합니다
        <a href="/user/logout">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="/user/login">로그인</a>
		</c:otherwise>
	</c:choose>
	<a href="/board/writeform">작성</a>
	<table>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성시간</th>
			<th>변경시간</th>
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<th><a href="view?bid=${s.bid}">${s.bid }</a></th>
				<th>${s.pid }</th>
				<th>${s.content }</th>
				<th>${s.createdat}</th>
				<th>${s.updatedat }</th>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<h1>댓글폼</h1>
	<hr>
	<form action="/reply/replyWrite" method="post">
		작성자: <input type="text" name="pid"><br>
		<textarea name="content" rows="5" cols="50"></textarea>
		<br> <input type="submit" value="등록">
	</form>
	<hr>
	<h1>댓글 목록</h1>
	<hr>
	<table>
		<tr>
			<th>작성자</th>
			<th>글</th>
			<th>작성시간</th>

		</tr>
		<c:forEach var="a" items="${replyList}">
			<tr>
				<th>${a.pid}</th>
				<th>${a.content }</th>
				<th>${a.createdat}</th>
				<td><c:if test="${sessionScope.userid == a.pid}">
						<form id="edit${a.rid}" action="/reply/replyUpdate" method="post">
							<input type="hidden" name="rid" value="${a.rid}"> <input
								type="text" name="content" value="${a.content}" hidden>
							<button type="button" onclick="edit(${a.rid},this)">수정하기</button>
						</form>
					</c:if></td>
				<td><c:if test="${sessionScope.userid == a.pid}">
						<button type="button"
							onclick="location.href ='/reply/replyDelete?rid=${a.rid}'">삭제하기</button>
					</c:if>
			</tr>
		</c:forEach>
	</table>
	<script>
	function edit(rid,btn){
		const formEvent =  document.getElementById("edit" + rid);
		/* 어렵네~ 네임 속성에 컨텐트 찾기~ */
		const inputEvent = formEvent.querySelector("input[name='content']");
		
		if(inputEvent.hidden){
			inputEvent.hidden =false;
			btn.innerText = "저장";
		}else{
			formEvent.submit();
		}
		
	}
</script>
</body>
</html>