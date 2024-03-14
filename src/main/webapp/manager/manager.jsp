<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/manager.js"></script>
<style>
/* 초기에는 내용이 숨겨져 있도록 설정 */
.full-content {
	display: none;
	white-space: pre-line; /* 텍스트 줄바꿈 유지 */
	color: black;
}

/* 클릭하면 내용이 나타날 수 있도록 스타일 지정 */
.content-row {
	cursor: pointer;
	color: black;
	text-decoration: none;
}

/* 마우스 호버 시 핑크로 변경 */
.content-row:hover {
	color: #ffb0c0;
}

/* 수정된 스타일 */
.reply-container {
	display: none; /* 초기에는 숨겨져 있음 */
	text-align: left;
	margin-top: 10px;
}

.reply-textarea {
	width: 100%;
	box-sizing: border-box;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div id="wrap" style="text-align: center;">
		<img src="upload/mini.png" alt="header">
		<h1 style="text-align: center">통합 페이지</h1>

		<!-- 회원 리스트 테이블 -->
		<h2 style="text-align: center;">회원 리스트</h2>
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

		<!-- 문의 페이지 테이블 -->
		<h2 style="text-align: center;">문의 페이지</h2>
		<table class="list">
			<tr>
				<th>No.</th>
				<th>아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록 일자</th>
				<th colspan="2">답변 여부</th>
			</tr>
			<c:forEach var="ask" items="${askList}">
				<tr class="record">
					<td>${ask.a_post_num }</td>
					<td>${memberList.get(status.index).id }</td>

					<td class="title-row"
						onclick="toggleContent('content_${ask.a_post_num}', this)"><c:set
							var="truncatedTitle" value="${fn:substring(ask.a_title, 0, 20)}" />
						${truncatedTitle}${fn:length(ask.a_title) > 20 ? '...' : ''}</td>

					<td style="text-align: left;">
						<!-- 클릭하면 내용이 나타나도록 추가 --> <span class="content-row"
						onclick="toggleContent('content_${ask.a_post_num}', this)">
							${fn:substring(ask.a_post, 0, 70)} </span>
						<div class="full-content" id="content_${ask.a_post_num}">
							${ask.a_post}</div>

						<div class="reply-container" id="replyContainer_${ask.a_post_num}">
							<textarea class="reply-textarea" placeholder="답변을 입력하세요..."
								id="replyText_${ask.a_post_num}"></textarea>
							<button
								onclick="sendReply('content_${ask.a_post_num}', 'replyContainer_${ask.a_post_num}', 'replyText_${ask.a_post_num}')">전송</button>
						</div>
					</td>


					<td><fmt:formatDate value="${ask.a_post_date}"
							pattern="yyyy-MM-dd" var="formattedDate" /> ${formattedDate}</td>

					<td>${ask.a_check }</td>
					<td><a href="askComment.do?code=${ask.code}"
						class="comment-link">답변</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
	// 토글 및 답변 함수는 그대로 사용 가능
	</script>
</body>
</html>
