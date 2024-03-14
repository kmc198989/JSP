<%@page import="main.com.daewoo.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, main.com.daewoo.dao.AskDAO, main.com.daewoo.dto.AskVO" %>
<%@ page import="main.com.daewoo.dao.CommunityDAO, main.com.daewoo.dto.CommunityDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0; 
    margin: 0;
    padding: 0;
  }

  .container {
    max-width: 800px;
    margin: 80px auto;
    padding: 50px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 20px;
    position: relative;
    padding-bottom: 80px; /* 수정된 부분 */
  }

  h2 {
    text-align: center;
    color:  #333;
    display: flex;
    justify-content: center; /* 텍스트 가운데 정렬 */
    align-items: center;
    margin-bottom: 20px;
  }

  .category-buttons {
    display: inline-block;
    padding: 10px;
    border-radius: 5px;
    background-color: #fff;
    margin-bottom: 20px;
  }

  .category-btn, .btn-password-check {
    padding: 10px 20px;
    margin: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: all 0.3s ease-in-out;
    background-color: #ffb0c0; 
    color: #fff;
  }

  .category-btn:hover {
    background-color: #ff4081; /* 밝은 핑크색 계열 */
  }

  .btn-password-check {
    background-color:  #ff4081; /* 밝은 진한 핑크색 */
    color: white;
  }

  .btn-password-check:hover {
    background-color:  #ff4081; 
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
    background-color: #ffb0c0; /* 연한 핑크색 계열 */
  } 

  th.date-column {
    width: 200px; 
  }

  .btn-inquiry {
    position: absolute;
    bottom: 20px;
    right: 20px;
  }

  #inquiry-section .btn-inquiry {
    position: relative;
    bottom: auto;
    right: auto;
    margin-top: 20px; /* 추가된 부분입니다. */
    float: right; /* 추가된 부분입니다. */
    
  }
</style>

</head>
<body>

<div class="container">
  
    <form action="modifyUserInfo.do" method="get">
     <h2> 마이페이지 </h2>
      <button type="submit" class="btn btn-password-check">내 정보 수정</button>
      <input type="hidden" name="action">
    </form>  
 
  
  <div class="category-buttons" style="text-align: center;">
    <button class="category-btn" onclick="showCategory('post')">게시글</button>
    <button class="category-btn" onclick="showCategory('comment')">댓글</button>
    <button class="category-btn" onclick="showCategory('inquiry')">문의</button>
  </div>


  <div id="post-section" style="display:none;">
    <h2>나의 게시글 활동내역</h2>
    <table id="post-table">
      <tr>
        <th>게시글 번호</th>
        <th>게시글 제목</th>
        <th>게시글 내용</th>
        <th>게시글 등록일자</th>
      </tr>
      <!-- 여기에 서버에서 받아온 게시글 데이터를 넣어주면 됩니다. -->
      <%
        CommunityDAO postDAO = new CommunityDAO();      
         MemberDTO mdto = (MemberDTO) session.getAttribute("loginUser");         
       int code = mdto.getCode();
        List<CommunityDTO> posta = postDAO.getAllPosts(code);
        for (CommunityDTO post : posta) {
      %>
      <tr>
        <td><%= post.getC_post_num() %></td>
        <td><%= post.getC_title() %>
        <td><%= post.getC_post() %></td>
        <td><%= post.getC_post_date() %></td>
      </tr>
      <%
        }
      %>
    </table>
  </div>
  
  <div id="comment-section" style="display:none;">
    <h2>내 댓글 활동내역</h2>
     <table id="comment-table">
        <tr>
            <th>댓글 번호</th>
            <th>댓글 내용</th>
            <th>작성일</th>
        </tr>
        <!-- 서버에서 받아온 댓글 데이터를 넣어줍니다. -->
        <%
            CommunityDAO communityDAO = new CommunityDAO();
            List<CommunityDTO> postb = communityDAO.getAllPosts(code);
            for (CommunityDTO post : postb) {
        %>
        <tr>
            <td><%= post.getC_comment() %></td>
            <td><%= post.getC_comment_num() %></td>
            <td><%= post.getC_comment_date() %></td>
        </tr>
        <%
            }
        %>
    </table>
  </div>
  
  <div id="inquiry-section" style="display:none;">
    <h2>문의 내역</h2>
    <table id="inquiry-table">
      <tr>
        <th>문의 번호</th>
        <th>문의 제목</th>
        <th>작성일</th>
      </tr>
      <!-- 여기에 서버에서 받아온 문의 데이터를 넣어주면 됩니다. -->
      <%
        AskDAO dao = AskDAO.getInstance();
        List<AskVO> posts = dao.getAllPosts();
        for (AskVO post : posts) {
      %>
      <tr>
        <td><%= post.getA_post_num() %></td>
        <td><%= post.getA_title() %></td>
        <td><%= post.getA_post_date() %></td>
      </tr>
      <%
        }
      %>
    </table>
    <!-- 문의하기 버튼 -->
    <form action="inquiry.do" method="get" class="btn-inquiry">
      <button type="submit" class="category-btn">문의하기</button>
      <input type="hidden" name="action" value="create">
    </form>
  </div>
</div>
<script>
  function showCategory(category) {
    if (category === 'post') {
      document.getElementById('post-section').style.display = 'block';
      document.getElementById('comment-section').style.display = 'none';
      document.getElementById('inquiry-section').style.display = 'none';
    } else if (category === 'comment') {
      document.getElementById('post-section').style.display = 'none';
      document.getElementById('comment-section').style.display = 'block';
      document.getElementById('inquiry-section').style.display = 'none';
    } else if (category === 'inquiry') {
      document.getElementById('post-section').style.display = 'none';
      document.getElementById('comment-section').style.display = 'none';
      document.getElementById('inquiry-section').style.display = 'block';
    }
  }
</script>

</body>
</html>
