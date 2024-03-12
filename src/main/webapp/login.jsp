<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel ="stylesheet" type="text/css" href="css/main.css">
<body>
 <%-- success 변수를 받아와서 메시지를 표시 --%>
    <% String success = (String) request.getAttribute("success"); %>
    <script>
        // 메시지 형식으로 성공 메시지를 표시
        alert("${success}");
    </script>
<div class="login-container">
    <c:choose>
        <c:when test="${not empty id}">
            <h1>${id}님<small>반갑습니다.</small></h1>
        </c:when>
        <c:otherwise> 
            <h1>${success}</h1>
        </c:otherwise>
    </c:choose>
    <button type="submit" class="btn btn-login" onclick="location.href='main_index.jsp'">로그아웃</button>
    
</div>
</body>
</html>