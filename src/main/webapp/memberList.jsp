<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/manager.js"></script>
</head>
<body>
	<div id="wrap" align="center">
	    <img src="upload/mini.png" alt="header">
		<h1 style="text-align: center;">회원 리스트</h1>
		<table class="list">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>가입일자</th>
				<th>게시글</th>
				<th>댓글</th>
				<th>수정</th>
			</tr>
			<c:forEach var="member" items="${memberList}">
				<tr class="record">
					<td>${member.id }</td>
					<td>${member.name }</td>
					<td>${member.phone }</td>
					<td>${member.join_date }</td>
					<td><a href="memberPost.do?code=${member.code}"
						class="update-link">열람</a></td>
					<td><a href="memberComment.do?code=${member.code}"
						class="update-link">열람</a></td>
					<td><a href="memberUpdate.do?code=${member.code}"
						class="update-link">수정</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>