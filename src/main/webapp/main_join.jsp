<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="script/member.js"></script>

</head>
<body>
	<h2>회원 가입 페이지</h2>
	*표시 항목은 필수 입력 사항 입니다.
	<form action="mainjoin.do" method="post" name="frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20">*</td>
			</tr>

			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20" id="id">*
				<input type="hidden" name="reid" size="20">
					<input type="button"value="중복체크" onclick="idCheck()"></td>
			</tr>

			<tr>
				<td>암호</td>
				<td><input type="password" name="pass" size="20">*</td>
			</tr>

			<tr height="30">
				<td width="80">암 호 확 인</td>
				<td><input type="password" name="pass_check" size="20"></td>
			</tr>

			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>

			<tr>
				<td>가입일자</td>
				<td><input type="date" id="join_date" name="join_date" readonly></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="확인" onclick="return joinCheck()"> &nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="reset" value="취소"></td>
			</tr>

			<tr>
				<td colspan="2">${message}</td>
			</tr>

		</table>
	</form>
	<script>document.getElementById('join_date').value = new Date().toISOString().substring(0, 10)</script>
</body>
</html>