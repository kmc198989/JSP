<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="script/member.js"></script>
<style>
    body {
        background-color: #f0f0f0; /* 배경색 지정 */
        font-family: Arial, sans-serif; /* 글꼴 지정 */
    }

    form {
        margin: 0 auto; /* 수평 가운데 정렬 */
        width: 500px; /* 폼의 너비 지정 */
        background-color: #ffe6ea; /* 분홍색 계열 배경색 지정 */
        padding: 20px; /* 내부 여백 지정 */
        border-radius: 10px; /* 테두리 둥글기 지정 */
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
        margin-top: 100px;
    }

    h2 {
        text-align: center; /* 제목 가운데 정렬 */
        color: #333; /* 제목 글자색 지정 */
    }

    table {
        width: 100%; /* 테이블의 너비를 부모 요소에 맞게 설정 */
    }

    td {
        padding: 10px; /* 셀 내부 여백 지정 */
    }

    input[type="text"],
    input[type="password"],
    input[type="date"] {
        width: calc(100% - 6px); /* 입력 필드의 너비 지정 */
        padding: 8px; /* 입력 필드 내부 여백 지정 */
        border-radius: 5px; /* 입력 필드 테두리 둥글기 지정 */
        border: 1px solid #ccc; /* 입력 필드 테두리 스타일 지정 */
        box-sizing: border-box; /* 입력 필드의 크기 계산 방법 지정 */
    }

    input[type="button"] {
        padding: 8px 20px; /* 버튼 내부 여백 지정 */
        border: none; /* 버튼 테두리 없애기 */
        border-radius: 5px; /* 버튼 테두리 둥글게 만들기 */
        background-color: #ff4081; /* 버튼 배경색 지정 */
        color: #fff; /* 버튼 글자색 지정 */
        cursor: pointer; /* 커서를 포인터로 변경하여 버튼임을 나타냄 */
        margin-top: 10px;
    }

    input[type="button"]:hover {
        background-color: #d81b60; /* 마우스 호버 시 배경색 변경 */
        
    }

    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px; /* 버튼 내부 여백 지정 */
        border: none; /* 버튼 테두리 없애기 */
        border-radius: 5px; /* 버튼 테두리 둥글게 만들기 */
        background-color: #ff4081; /* 버튼 배경색 지정 */
        color: #fff; /* 버튼 글자색 지정 */
        cursor: pointer; /* 커서를 포인터로 변경하여 버튼임을 나타냄 */
    }

    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #d81b60; /* 마우스 호버 시 배경색 변경 */
    }

    /* 분홍색 계열 텍스트 메시지 스타일 지정 */
    .message {
        color: #ff4081;
        text-align: center;
        font-size: 14px;
    }
</style>
</head>
<body>

	<form action="mainjoin.do" method="post" name="frm">
		<h2>회원 가입 페이지</h2>
		<p>*표시 항목은 필수 입력 사항 입니다.</p>
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