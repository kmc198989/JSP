<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/comu.css">
<script type="text/javascript" src="script/comu.js"></script>
<script src="deleteRow.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>커뮤니티</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="comuWrite.do">글쓰기</a></td>
			</tr>

			<th width="30px">NO.</th>
			<th width="90px">아이디</th>
			<th>제목</th>
			<th width="90px">등록일자</th>
			<th width="90px" colspan="2">수정 / 삭제</th>
			

			<c:forEach var="comu" items="${comulist}" varStatus="status">
				<tr class="record">
					<td align="center" >${comu.c_post_num}</td>
					<td align="center">${comu.userid}</td>
					<%--List.get(status.index) --%>
					<td class="title-row" onclick="toggleContent('content_${comu.c_post_num}', this)">
					<a href="commentWrite.do">
					<c:set var="truncatedTitle" value="${fn:substring(comu.c_title, 0, 20)}"/>
					${truncatedTitle}${fn:length(comu.c_title) > 20 ? '...' : ''}</a>
					</td>
					<td>${comu.c_post_date}</td>
					<td align="center" width="90px">
					<c:if test="${loginUser.code eq '1' }">
					<input type="button" value="수정" onclick="location.href='comuUpdate.do?code=${comu.c_post_num}'">
					<input type="button" value="삭제" onclick="deleteRow(${comu.c_post_num})">
					</c:if>
					</td>
			</c:forEach>
		</table>
	</div>
	<script>
		function deleteRow(postNum){
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href = "comuDelete.do?code=" + postNum;
			}
		}
	</script>
</body>
</html>

