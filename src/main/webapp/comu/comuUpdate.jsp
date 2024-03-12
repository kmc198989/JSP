<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>게시글 수정</h1>
<form method="post" name="frm" enctype="multipart/form-data">
<input type="hidden" name="code" value="${comu.code}">
		<table>
			<tr>
				<th style="width:80px">NO.</th>
				<td>
					<input type="text" name="c_post_num" value="${comu.c_post_num}" readonly style="border: none;">			
				</td>	
			</tr>
			<tr>
				<th style="width:80px">제목</th>
				<td>
					<input type="text" name="c_title" value="${comu.c_title}" size="80">			
				</td>	
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="10" cols="90" name="c_post">${comu.c_post}</textarea>				
				</td>	
			</tr>
			
			<tr>
				<th>날짜</th>
				<td>
					<input type="date" name="c_post_date" value="${comu.c_post_date}">				
				</td>	
			</tr>
		</table>
		<br>
<input type="submit" value="등록" onclick="return comuCheck()">
<input type="reset" value="다시 작성">
<input type="button" value="커뮤니티" onclick="location.href='comuList.do'">
</form>
</div>
</body>
</html>