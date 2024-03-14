<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>개인정보 수정</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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

<div class="container">
    

    <form action="modifyUserInfo.do" method="POST">
        <div class="form-group">
        <h2>회원 정보 수정</h2>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요" class="form-control" value="<c:out value="${userInfo.name}" />">
        </div>
        <div class="form-group">
            <label for="id">아이디:</label>
            <input type="text" id="id" name="id" placeholder="아이디를 입력하세요" class="form-control" value="<c:out value="${userInfo.id}" />">
        </div>
          <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" class="form-control">
        </div>
        <div class="form-group">
            <label for="phone">전화번호:</label>
            <input type="tel" id="phone" name="phone" placeholder="전화번호를 입력하세요" class="form-control" value="<c:out value="${userInfo.phone}" />">
        </div>
        <div class="form-group text-center">
            <input type="submit" value="저장" class="btn btn-primary">
        </div>
    </form>
</div>

</body>
</html>
