<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 페이지</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/manager.js"></script>
<style>
.list-container, .member-list-container {
  width: 100%; /* 컨테이너의 너비를 각각 48%로 설정하여 좌우로 배치 */
  max-height: 500px; /* 최대 높이 설정 */
  overflow-y: auto; /* 내용이 넘칠 경우 세로 스크롤 생성 */  
  display: flex;
  justify-content: space-between;
}
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

</style>
</head>
<body>
    <div id="wrap" style="text-align: center;">
	    <img src="upload/mini.png" alt="header">
	    <h1 style="text-align: center">문의 페이지</h1>        
	    
        <div class="list-container">
        <table class="list">
            <tr>
                <th>No.</th>
                <th>아이디</th>
                <th>제목</th>
                <th>내용</th>
                <th>등록 일자</th>
                <th colspan="2">답변</th>
            </tr>
            <c:forEach var="ask" items="${askList}">
                <tr class="record">
                	<!-- post 번호 -->
                    <td>${ask.a_post_num }</td>
                    
                    <!-- 유저 아이디 -->
                    <td>${ask.userid }</td>
                    
                    <!-- 제목 -->
                    <td class="title-row" onclick="toggleContent('content_${ask.a_post_num}', this)">
                        <c:set var="truncatedTitle" value="${fn:substring(ask.a_title, 0, 20)}" />
                        ${truncatedTitle}${fn:length(ask.a_title) > 20 ? '...' : ''}
                    </td>
					
                    <td style="text-align: left;">
                        <!-- 클릭하면 내용이 나타나도록 추가 -->
                        <span class="content-row" onclick="toggleContent('content_${ask.a_post_num}', this)">
                            ${fn:substring(ask.a_post, 0, 70)}
                        </span>
                        <div class="full-content" id="content_${ask.a_post_num}">
                            ${ask.a_post}
                        <br>
                        <hr>
                            <!-- 답변 내용 표시 -->
                            <div class="comment-container" id="comment_${ask.a_post_num}">
                                <span class="comment-row" onclick="toggleComment('comment_${ask.a_post_num}')">답변</span>
                                <div class="comment-content">
                                    : ${ask.a_comment}
                                </div>
                            </div>
                        </div>
                    </td>
                    
                    <td><fmt:formatDate value="${ask.a_post_date}" pattern="yyyy-MM-dd" var="formattedDate" />
                    ${formattedDate}</td>
                    <td>${ask.a_check }</td>
    
    
    
                    <td><a href="askComment.do?a_post_num=${ask.a_post_num}" class="comment-link">답변</a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
        <div class="member-list-container">
        <%@ include file="/member/memberList.jsp" %>			
        </div>
    </div>
<script>
  function goToCommentPage(a_post_num) {
    // 클릭된 "답변" 버튼의 문의 번호를 사용하여 서블릿으로 이동
    window.location.href = 'askCommentPage.do?a_post_num=' + a_post_num;
  }
  function toggleContent(contentId, clickedElement) {
    var content = document.getElementById(contentId);
    
    // 이미 토글된 경우에는 숨기도록
    if (content.style.display === 'block') {
      content.style.display = 'none';
    } else {
      // 이전에 토글된 내용을 숨기도록
      var allContents = document.querySelectorAll('.full-content');
      allContents.forEach(function(element) {
        element.style.display = 'none';
      });
      
      // 현재 클릭한 내용을 보이도록
      content.style.display = 'block';
    }
  }
  
  function toggleComment(commentId) {
      var commentContainer = document.getElementById(commentId);
      var commentContent = commentContainer.querySelector('.comment-content');

      // 이미 토글된 경우에는 숨기도록
      if (commentContainer.style.display === 'block') {
          commentContainer.style.display = 'none';
      } else {
          // 이전에 토글된 내용을 숨기도록
          var allComments = document.querySelectorAll('.comment-container');
          allComments.forEach(function(element) {
              element.style.display = 'none';
          });

          // 현재 클릭한 내용을 보이도록
          commentContainer.style.display = 'block';
      }
  }
</script>

</body>
</html>