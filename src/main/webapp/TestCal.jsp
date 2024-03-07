<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
  <meta charset='utf-8'/>
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
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
           dateClick: function (info) {
             var dateStr = info.dateStr;
             var category = prompt("수입 또는 지출을 선택해주세요 (수입/지출):");
             var amount = prompt("금액을 입력해주세요:");
             var description = prompt("설명을 입력해주세요:");

             if (category !== null && amount !== null && description !== null) {
               var event = {
                 title: category + ' - ' + amount,
                 start: dateStr,
                 description: description
               };

               events.push(event);
               calendar.addEvent(event);
             }
           }
         });

         calendar.render();
       });
  </script>
</head>
<body>
  <div id='calendar'></div>
</body>
</html>