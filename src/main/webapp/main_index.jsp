<%@page import="main.com.daewoo.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%
    // 세션에서 loginUser 객체 가져오기
    MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");

    // loginUser에서 code 값 추출 (여기서는 loginUser가 code 값을 직접 가지고 있다고 가정)
    // 실제 사용 시에는 loginUser의 클래스 타입에 맞게 캐스팅하고, 적절한 getter 메서드를 호출해야 합니다.
    String code = ""; // loginUser 객체 구조에 따라 적절한 추출 방법 사용
    if (loginUser != null) {
         // 예시로, loginUser가 MyDTO 타입이라고 가정하고, getCode() 메서드로 code 값을 가져옵니다.
         code = Integer.toString(loginUser.getCode());
    }
%>
<script>
    // JSP에서 JavaScript 변수로 code 값을 전달
    var userCode = "<%=code%>"; // loginUser 객체로부터 얻은 code 값을 할당
</script>
<script type="text/javascript" src="script/calendar.js"></script>
<script type="text/javascript" src="script/submitcheck.js"></script>
<script>
<% 
String message = (String)request.getAttribute("message");
String success = (String)request.getAttribute("success");
if (message != null) { %>
    alert("<%= message %>");
<% } else if (success != null) { %>
    alert("<%= success %>");
<% } %>
</script> 

<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>
	<div class='header'>
	<img src="img/header.png">
	</div>
	<div class='main1'>
		<div id='comu_form'>
			<form action="comu_info">
			<%@ include file="comu/comuList.jsp" %>			
			</form>
		</div>
		<%@ include file="loginForm.jsp" %>
		
	</div>
	<div class='main2'>
		<div id='calendar'></div>
		<div id='cashbook'>
			<h2>가계부 입력 란<h2>
               <form method="post" action="cashListAdd.do" name="frm">
                  <table border="2" height=600 width=600 cellspacing="2"
                     bordercolor="#ffb0c0">
                     <input type="hidden" name="code" value="1">
                     <tr>
                        <td>입력 일자</td>
                        <td><input type="date" name="in_date"
                           style="width: calc(100% - 20px); padding: 5px; font-size: 16px; border: 1px solid #ffb0c0; border-radius: 5px;"></td>
                     </tr>

                     <tr>
                        <td>수입/지출</td>
                        <td><input type="radio" name="in_out" value="수입" checked>수입
                           <input type="radio" name="in_out" value="지출">지출</td>
                     </tr>

                     <tr>
                        <td>금 액</td>
                        <td><input type="text" name="amount"
                           placeholder="숫자로만 입력해 주세요"
                           style="width: calc(100% - 20px); padding: 5px; font-size: 16px; border: 1px solid #ffb0c0; border-radius: 5px;">
                        </td>

                     </tr>

                     <tr>
                        <td>결제수단</td>
                        <td><input type="radio" name="payment" value="카드"  style="margin-right: 5px;" checked>카드
                           <input type="radio" name="payment" value="현금" style="margin-right: 5px;">현금 <input
                           type="radio" name="payment" value="계좌이체" style="margin-right: 5px;">계좌이체</td>
                     </tr>

                     <tr>
                        <td>내 용</td>
                        <td><input type="text" name="content" style="width: calc(100% - 20px); padding: 5px; font-size: 16px; border: 1px solid #ffb0c0; border-radius: 5px;"></td>
                     </tr>
                     <tr>
                        <td>메 모</td>
                        <td><input type="text" name="coment" style="width: calc(100% - 20px); padding: 5px; font-size: 16px; border: 1px solid #ffb0c0; border-radius: 5px;"></td>
                     </tr>

                     <tr>
                        <td colspan="2" align="center"><input type="submit"
                           value="등록" onclick="return submitCheck()"
                           style="padding: 10px 20px; background-color: #ffb0c0; color: #fff; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s;">
                           <input type="reset" value="취소"
                           style="padding: 10px 20px; background-color: #ffb0c0; color: #fff; border: none; border-radius: 5px; cursor: pointer; transition: background-color 0.3s;"></td>
                     </tr>
                  </table>

               </form>
		</div>
	</div>
	
<div id="payment1">
<table id="payment">
   <h2>가계부 내역</h2>
        <tr>
            <th>날짜</th>
            <th>수입/지출</th>
            <th>금액</th>
            <th>내용</th>
            <th>메모</th>
        </tr>
        <c:forEach var="payment2" items="${al}">
            <tr class="record">
                <td>${payment2.in_date}</td>
                <td>${payment2.in_out}</td>
                <td>${payment2.amount}</td>
                <td>${payment2.content}</td>
                <td>${payment2.coment}</td>
            </tr>
        </c:forEach>
       
</table>
</div>
</body>
</html>