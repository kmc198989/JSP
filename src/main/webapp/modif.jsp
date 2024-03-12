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
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .container {
            width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        .container h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>개인정보 수정</h1>

    <form action="modifyUserInfo.do" method="POST">
        <div class="form-group">
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
