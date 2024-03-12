<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty loginUser }">
		<div class="login-container">
			<h2>로그인</h2>
			<form class="login-form" action="sign.do" method="post">
				<input type="text" class="form-control" name="id" placeholder="아이디"
					required> <input type="password" class="form-control"
					name="pass" placeholder="비밀번호" required>
				<button type="submit" class="btn btn-login">로그인</button>
			</form>
			<div class="signup-link">
				<button onclick="location.href='mainjoin.do'">회원가입</button>
			</div>
		</div>
	</c:if>
	<c:if test="${!empty loginUser }">
		<%-- success 변수를 받아와서 메시지를 표시 
		<%
		String success = (String) request.getAttribute("success");
		%>
		<script>
			// 메시지 형식으로 성공 메시지를 표시
			alert("${success}");
		</script>						--%>
		<div class="login-container">
			<c:choose>
				<c:when test="${not empty loginUser.id}">
					<h1>${loginUser.name}님<small> 반갑습니다.</small></h1>
				</c:when>
				<c:otherwise>
					<h1>${success}</h1>
				</c:otherwise>
			</c:choose>
			<button type="submit" class="btn btn-login"
				onclick="location.href='logout.do'">로그아웃</button>
			<div class="signup-link">
				<button onclick="location.href='mypage.jsp'">마이페이지</button>
				<c:if test="${loginUser.id eq 'admin'}">				
					<button onclick="location.href='#'">관리자</button>
				</c:if>
			</div>
		</div>
	</c:if>








</body>
</html>