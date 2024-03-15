<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/comu.css">
<script type="text/javascript" src="script/comu.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>글쓰기</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
			<table>				
				<tr>
					<th>제목</th>
					<td><input type="text" name="c_title" size="80"></td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="80" name="c_post"></textarea></td>
				</tr>

				<tr>
					<th>날짜</th>
					<td><input type="date" name="c_post_date" class="date-field"
						readonly style="border: none;" size="80"></td>
				</tr>

			</table>
			<br> <input type="submit" value="등록"
				onclick="return comuCheck()"> <input type="button"
				value="목록" onclick="location.href='comuList.do'">
		</form>
	</div>
</body>
</html>
