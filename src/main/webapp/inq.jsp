<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.com.daewoo.dto.AskVO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>문의 페이지</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
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

    /* 분홍색 계열 텍스트 메시지 스타일 지정 */
    .message {
        color: #ff4081;
        text-align: center;
        font-size: 14px;
    }
</style>



<body>
  <div class="container">

      <form  method="post" action="inquiry.do">
      <h2 style="text-align: center; /* 제목 가운데 정렬 */color: #333; /* 제목 글자색 지정 */">문의 하기</h2>
        <div class="form-group">
          <label for="titleInput">제목</label>
          <input type="text" class="form-control" id="titleInput" placeholder="제목을 입력하세요" name="a_title">
        </div>
        <div class="form-group">
          <label for="messageTextarea">문의 내용</label>
          <textarea class="form-control" id="messageTextarea" rows="5" placeholder="문의할 내용을 입력하세요" name="a_post"></textarea>
        </div>
        <button type="submit" class="btn btn-primary btn-block" style="padding: 10px 20px; background-color: #ffb0c0; color: #fff; border: none;
         border-radius: 5px; cursor: pointer; transition: background-color 0.3s;">전송</button>
      </form>
    </div>

</body>
</html>
