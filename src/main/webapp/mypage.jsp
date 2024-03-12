<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 0;
  }
  .container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
  }
  h1 {
    text-align: center;
    color: #333;
    display: flex;
    justify-content: space-between; /* 헤더 안에서 좌우로 요소를 배치 */
    align-items: center; /* 수직 가운데 정렬 */
  }
  .category-buttons {
    display: inline-block;
  }
  .category-btn, .btn-password-check {
    padding: 10px 20px;
    margin: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: all 0.3s ease-in-out; /* 호버 효과를 위한 변환 효과 설정 */
  }
  .category-btn {
    background-color: #4CAF50;
    color: #fff;
  }
  .category-btn:hover {
    background-color: #45a049; /* 호버 시 색상 변환 */
  }
  .btn-password-check {
    background-color: #008CBA;
    color: white;
  }
  .btn-password-check:hover {
    background-color: #0073e6; /* 호버 시 색상 변환 */
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
</style>
</head>
<body>

<div class="container">
  <h1> 
  <form action="modifyUserInfo.do" method="get">
    마이페이지
    <button type="submit" class="btn btn-password-check">내 정보 수정</button>
    <input type="hidden" name="action">
  </form>  
  </h1>
  
  <div class="category-buttons">
    <button class="category-btn" onclick="showCategory('post')">게시글</button>
    <button class="category-btn" onclick="showCategory('comment')">댓글</button>
    <button class="category-btn" onclick="showCategory('inquiry')">문의</button>
  </div>
  
  <div id="post-section" style="display:none;">
    <h2>게시글 활동내역</h2>
    <table id="post-table">
      <tr>
        <th>날짜</th>
        <th>게시글 제목</th>
      </tr>
      <tr>
        <td>2024-03-10</td>
        <td>첫 번째 게시글</td>
      </tr>
      <tr>
        <td>2024-03-08</td>
        <td>두 번째 게시글</td>
      </tr>
    </table>
  </div>
  
  <div id="comment-section" style="display:none;">
    <h2>댓글 활동내역</h2>
    <table id="comment-table">
      <tr>
        <th>날짜</th>
        <th>댓글 내용</th>
      </tr>
      <tr>
        <td>2024-03-09</td>
        <td>첫 번째 게시글에 작성한 댓글입니다.</td>
      </tr>
    </table>
  </div>
  
  <div id="inquiry-section" style="display:none;">
    <h2>문의 활동내역</h2>
    <table id="inquiry-table">
      <tr>
        <th>날짜</th>
        <th>문의 사항</th>
      </tr>
      <tr>
        <td>2024-03-08</td>
        <td>상품 구매에 대한 문의입니다.</td>
      </tr>
    </table>
  </div>
</div>

<script>
  function showCategory(category) {
    document.getElementById('post-section').style.display = 'none';
    document.getElementById('comment-section').style.display = 'none';
    document.getElementById('inquiry-section').style.display = 'none';
    
    document.getElementById(category + '-section').style.display = 'block';
  }
</script>

</body>
</html>
