<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 게시글 관리</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/manager.js"></script>
</head>
<body>
<div id="wrap" align="center">
	<img src="upload/mini.png" alt="header">
	<h1>${param.id }님이 작성한 게시물</h1>
	<table>
		<tr>
            <th>게시글 번호</th>
            <th>게시글 제목</th>
            <th>게시글 내용</th>
            <th>작성일자</th>
            <th>삭제</th>
        </tr>
        <c:forEach var="comu" items="${comuList}">
            <tr>
                <td>${comu.c_post_num}</td>
                <td>${comu.c_title}</td>
                <td>${comu.c_post }</td>
                <td>${comu.c_post_date}</td>
				<td><input type="submit" value="삭제"
						onclick="deleteRow(${comu.c_post_num})"></td>
            </tr>
        </c:forEach>
	</table>
</div>
</body>
</html>