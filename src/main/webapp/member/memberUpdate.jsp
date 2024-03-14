<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" type="text/css" href="css/manager.css">
<script type="text/javascript" src="script/manager.js"></script>
</head>
<body>
<div id="update" align="center">
<form method="post" name="frm">
    <h1 style="text-align: center;">회원 정보 수정</h1>
    <table>
        <tr>
            <th style="width:200px">아이디</th>
            <td>
                <input type="text" name="id" value="${member.id}" size="100" readonly="readonly">
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>
                <input type="password" name="pass" value="${member.pass}" size="100">
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td>
                <input type="text" name="name" value="${member.name}" size="100">
            </td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>
                <input type="text" name="phone" value="${member.phone}" size="100">
            </td>
        </tr>
        <tr>
            <th>가입일자</th>
            <td>
                <input type="text" name="join_date" value="${member.join_date}" size="100" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td colspan="2" id="btnContainer">
                <input type="submit" value="수정" onclick="return managerCheck()">
                <input type="reset" value="다시 작성">
                <input type="button" value="목록" onclick="location.href='memberList.do'">
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
