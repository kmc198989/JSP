<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 답변 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/manager.js"></script>
<style>
div {
	text-align: center;
}
</style>
</head>
<body>
	<div id="wrap" style="text-align: center;">
		<img src="upload/mini.png" alt="header">
		<h1 style="text-align: center;">문의 답변 페이지</h1>
		<table class="list">
			<tr>
				<th>No.</th>
				<th>아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>

			<!-- 문의 내용 불러오기 -->
			
			<tr>			
				<td>${ask.a_post_num}</td>
				<td>${ask.userid}</td>
				<td>${ask.a_title}</td>
				
				<td>
				<textarea rows="10" cols="70">${ask.a_post}</textarea>				
				</td>
				<td>${ask.a_post_date}</td>
			</tr>					

			<!-- 답변 양식 -->
			<tr>
				<td>${param.a_post_num}</td>
				<td colspan="3">
					<form action="askComment.do" method="post">
						<input type="hidden" name="a_post_num" value="${param.a_post_num}">
						<input type="hidden" name="a_post_date" value="${ask.a_post_date }">
						<br>
						<textarea name="a_comment" rows="5" cols="100" placeholder="답변 내용"></textarea>
						<br> <br> 
						<input type="submit" value="작성"> 
						<input type="reset" value="다시 작성"> 
						<input type="button" value="목록" onclick="location.href='askList.do'">
					</form>
				</td>
				<td>
					<form>
						<input type="date" name="a_comment_date" class="date-field" readonly style="border: none; text-align: right;">
					</form>
				</td>
			</tr>
		</table>
	</div>
	<br>
	<script>
	// 현재 날짜를 가져오는 함수
    function getCurrentDate() {
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = ('0' + (currentDate.getMonth() + 1)).slice(-2);
        var day = ('0' + currentDate.getDate()).slice(-2);
        return year + '-' + month + '-' + day;
    }

    // 페이지 로드 시 실행되는 함수
    window.onload = function() {
        // 현재 날짜를 가져와서 날짜 필드에 자동으로 입력
      var dateFields = document.querySelectorAll('.date-field'); // 날짜 필드 선택
        for (var i = 0; i < dateFields.length; i++) {
            dateFields[i].value = getCurrentDate(); // 현재 날짜 설정
            dateFields[i].readOnly = true; // 읽기 전용으로 설정
        }
    };
	</script>
</body>
</html>
