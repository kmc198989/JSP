<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="main.com.daewoo.dto.AskVO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>문의 페이지</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: Arial, sans-serif;
    }

    .container {
      max-width: 500px;
      margin: 0 auto;
      padding-top: 50px;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .card {
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      padding: 30px;
    }

    .btn-primary {
      background-color: #007bff;
      border-color: #007bff;
    }

    .btn-primary:hover {
      background-color: #0056b3;
      border-color: #0056b3;
    }

    .btn-primary:focus {
      box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.5);
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="card">
      <h1 class="text-center mb-4">문의 페이지</h1>
      <form  method="post" action="inquiry.do">
        <div class="form-group">
          <label for="titleInput">제목</label>
          <input type="text" class="form-control" id="titleInput" placeholder="제목을 입력하세요" name="a_title">
        </div>
        <div class="form-group">
          <label for="messageTextarea">문의 내용</label>
          <textarea class="form-control" id="messageTextarea" rows="5" placeholder="문의할 내용을 입력하세요" name="a_post"></textarea>
        </div>
        <button type="submit" class="btn btn-primary btn-block">전송</button>
      </form>
    </div>
  </div>
</body>
</html>
