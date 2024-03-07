<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
    	  var calendarEl = document.getElementById("calendar");

    	  var calendar = new FullCalendar.Calendar(calendarEl, {
    	    selectable: true,
    	    headerToolbar: {
    	      left: "prev,next today",
    	      center: "title",
    	      right: "dayGridMonth"
    	    },
    	    dateClick: function (info) {
    	      alert("clicked " + info.dateStr);
    	    },
    	    select: function (info) {
    	      alert("selected " + info.startStr + " to " + info.endStr);
    	    }
    	  });

    	  calendar.render();
    	});
    </script>
<title>Insert title here</title>
<style type="text/css">
    body {
            background-color: #f8f9fa; /* 배경색 변경 */
            font-family: Arial, sans-serif; /* 폰트 변경 */
            color: #333; /* 글자색 변경 */
            text-align: center;
            padding-top: 20px; /* 위쪽 여백 조정 */
            padding-bottom: 20px; /* 아래쪽 여백 조정 */
          
   
        }
        .login-container {
            position:relative;
            width: 400px; /* 컨테이너 너비 조정 */
            height:400px;
            margin: auto;
            background-color: #fff; /* 백그라운드 색상 변경 */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            float: right; /* 오른쪽으로 이동 */
            margin-right: 100px; /* 오른쪽 마진 추가 */
            margin-top: 70px; /* 위쪽 여백 조정 */
            margin-bottom: 50px; /* 아래쪽 여백 조정 */
        }
        .form-control {
            border: none;
            border-radius: 25px;
            background-color: #f8f9fa; /* 백그라운드 색상 변경 */
            color: #333; /* 글자색 변경 */
            padding: 10px 20px;
            margin-bottom: 15px;
            width: calc(100% - 40px); /* 너비 조정 */
            box-sizing: border-box;
        }
        .btn-login {
            border-radius: 25px;
            padding: 8px 16px; /* 버튼 크기 조정 */
            background-color: #007bff; /* 버튼 배경색 변경 */
            color: #fff; /* 버튼 글자색 변경 */
            font-weight: bold;
            width: calc(100% - 40px); /* 너비 조정 */
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-login:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }
        .signup-link {
            margin-top: 20px; /* 위쪽 마진 추가 */
        }
        .signup-link button {
            font-size: 13px;
            background-color: #c0c0c0;
            color: #fff;
            border-radius: 5px;
            padding: 8px 16px; /* 버튼 크기 조정 */
            margin-right: 10px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .signup-link button:hover {
            background-color: #9e9e9e; /* 호버 시 배경색 변경 */
        }
#comu_form{
        	position: relative;  
            width: 1200px; /* 컨테이너 너비 조정 */
            height:500px;
            margin: auto;
            background-color: #fff; /* 백그라운드 색상 변경 */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            float: left;
            margin-left: 10px; 
            margin-top: 30px; /* 위쪽 여백 조정 */
            margin-bottom: 15px; /* 아래쪽 여백 조정 */
            
        
        }        

.header{

margin: auto;
            background-color:pink; /* 백그라운드 색상 변경 */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            margin-right: 30px; /* 오른쪽 마진 추가 */
            margin-top: 10px; /* 위쪽 여백 조정 */
            margin-bottom: 20px; /* 아래쪽 여백 조정 */
            margin-left: 30px; 
}

#calendar{
	float: left;
   width:900px;
   height:900px;
   margin-left: 30px;
   margin-bottom: 30px;
   margin-top: 50px;
   
}

#cashbook{
            width: 800px; /* 컨테이너 너비 조정 */
            height:700px;
            margin: auto;
            background-color: #fff; /* 백그라운드 색상 변경 */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            float: right; /* 오른쪽으로 이동 */
            margin-right: 30px; /* 오른쪽 마진 추가 */
            margin-top: 150px; /* 위쪽 여백 조정 */
            margin-bottom: 20px; /* 아래쪽 여백 조정 */
}

table{
    margin-left:auto; 
    margin-right:auto;
}

</style>
</head>
<body>
<div class='header'>핑크피그</div>

<div class='main1'>

<div id= 'comu_form'>
    <h2>커뮤니티</h2>
    <form action="comu_info">
    </form>
    </div>

<div class="login-container">
        <h2>로그인</h2>
        <form class="login-form" action="sign.do" method="post">
            <input type="text" class="form-control" name="username" placeholder="아이디" required>
            <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
            <button type="submit" class="btn btn-login">로그인</button>
        </form>
        <div class="signup-link">
            <button onclick="location.href='signup.jsp'">회원가입</button> 
            <button onclick="location.href='mypage.jsp'">마이페이지</button>  
            <button onclick="location.href='#'">관리자</button>
        </div>
    </div>

</div>

<div class='main2'>

<div id='calendar'>

</div>

<div id='cashbook'>
<h2>가계부 입력 란<h2>
<table border="2"  height=600 width=600 bordercolor="pink" cellspacing="2"
        bordercolor="pink">
<tr>
<td>입력 일자</td>
<td><input type="date" name="IN_DATE" " style="width:300px;height:20px;font-size:16px;"></td>
</tr>

<tr>
<td>수입/지출</td>
<td>
<input type="radio" name="IN_OUT" value="0" checked>수입
<input type="radio" name="IN_OUT" value="1" >지출</td>
</tr>

<tr>
	<td>금 액</td>
	<td><input type="text" name="AMOUNT" style="width:300px;height:20px;font-size:16px;">
	<br>(*숫자로만 입력해 주세요*)</td>

</tr>

<tr>
<td>결제수단</td>
<td>
<input type="radio" name="IN_OUT" value="0" checked>카드
<input type="radio" name="IN_OUT" value="1" >현금
<input type="radio" name="IN_OUT" value="2" >계좌이체</td>
</tr>



<tr>
	<td>내 용</td>
	<td><input type="text" name="CONTENT" style="width:300px;height:20px;font-size:16px;"></td>
</tr>




</table>
</div>

</div>



</body>
</html>