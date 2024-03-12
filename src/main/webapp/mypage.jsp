<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mypageEdit.do" method="post" name="frm">
<table align="center" width="550">
	<input type="hidden" name="code" value=${loginUser.code }>
	<tr>
		<td colspan="2" align="center"> 마이페이지</td>
	</tr>
	<tr>
		<td id="front">아이디</td>
		<td><input type="text" name="id" value=${loginUser.id } readonly></td>
	</tr>
	<tr>
		<td id="front">이름</td>
		<td><input type="text" name="name" value=${loginUser.name }></td>
	</tr>
	<tr>
		<td id="front">암호</td>
		<td><input type="password" name="pass" value=${loginUser.pass }></td>
	</tr>	
	
	<tr>
		<td id="front">전화번호</td>
		<td colspan="3"><input type="text" name="phone" value="${loginUser.phone }"></td>	
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
			<input type="button" value="뒤로가기" onclick="history.back();" />
		</td>
	</tr>
</table>

</form>
</body>
</html>