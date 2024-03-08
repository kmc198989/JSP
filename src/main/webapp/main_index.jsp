<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="script/calendar.js"></script>
<script type="text/javascript" src="script/submitcheck.js"></script>
<script>
<% 
String message = (String)request.getAttribute("message");
String success = (String)request.getAttribute("success");
if (message != null) { %>
    alert("<%= message %>");
<% } else if (success != null) { %>
    alert("<%= success %>");
<% } %>
</script> 
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>
	<div class='header'>핑크피그</div>
	<div class='main1'>
		<div id='comu_form'>
			<h2>커뮤니티</h2>
			<form action="comu_info"></form>
		</div>
		<div class="login-container">
			<h2>로그인</h2>
			<form class="login-form" action="sign.do" method="post">
				<input type="text" class="form-control" name="username" placeholder="아이디" required>
				<input type="password" class="form-control" name="password" placeholder="비밀번호" required>
				<button type="submit" class="btn btn-login">로그인</button>
			</form>
			<div class="signup-link">
	            <button onclick="location.href='mainjoin.do'">회원가입</button> 
	            <button onclick="location.href='mypage.jsp'">마이페이지</button>  
	            <button onclick="location.href='#'">관리자</button>
			</div>
		</div>
	</div>
	<div class='main2'>
		<div id='calendar'></div>
		<div id='cashbook'>
			<h2>가계부 입력 란<h2>
				<form method="post" action="cashListAdd.do" name="frm">
					<table border="2" height=600 width=600 bordercolor="pink" 
					cellspacing="2" bordercolor="pink">
						<input type="hidden" name="code" value="1">
						<tr>
							<td>입력 일자</td>
							<td><input type="date" name="in_date"
								" style="width: 300px; height: 20px; font-size: 16px;"></td>
						</tr>

						<tr>
							<td>수입/지출</td>
							<td><input type="radio" name="in_out" value="수입" checked>수입
								<input type="radio" name="in_out" value="지출">지출</td>
						</tr>

						<tr>
							<td>금 액</td>
							<td><input type="text" name="amount"
								style="width: 300px; height: 20px; font-size: 16px;"> <br>(*숫자로만
								입력해 주세요*)</td>

						</tr>

						<tr>
							<td>결제수단</td>
							<td><input type="radio" name="payment" value="카드" checked>카드
								<input type="radio" name="payment" value="현금">현금 <input
								type="radio" name="payment" value="계좌이체">계좌이체</td>
						</tr>



						<tr>
							<td>내 용</td>
							<td><input type="text" name="content""></td>
						</tr>

						<tr>
							<td colspan="2">
							<input type="submit" value="등록" onclick="return submitCheck()">
							<input type="reset" value="취소">
							<td>
						</tr>
					</table>
				</form>
		</div>
	</div>
</body>
</html>