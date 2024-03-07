<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset='utf-8' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
<script>
  
    document.addEventListener("DOMContentLoaded", function () {
         var calendarEl = document.getElementById("calendar");
         var events = [];

         var calendar = new FullCalendar.Calendar(calendarEl, {
           selectable: true,
           headerToolbar: {
             left: "prev,next today",
             center: "title",
             right: "dayGridMonth,timeGridWeek,timeGridDay"
           }, 
    	
           

           
           
          events: [
          	   {
        	      title  : 'event1',
        	      start  : '2024-03-07'
        	    },
        	    {
        	      title  : 'event2',
        	      start  : '2024-03-18',
        	      end    : '2024-03-22'
        	    }
        	  ]         
 
         });

         calendar.render();
       });
  </script>
</head>
<body>
	<div id='calendar'></div>
	<form method="post" action="cashbook.do">
		<input type="hidden" name="code" value="1"> <input
			type="submit" value="내역 조회">
	</form>
	<c:forEach var="listall" items="${listall }">
  	${listall.code }
  	${listall.in_out }
  	${listall.amount }
  	${listall.in_date }
  	${listall.content }
  	${listall.payment }
  	${listall.monthly }
  	${listall.coment }
  </c:forEach>
</body>
</html>