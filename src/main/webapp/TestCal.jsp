<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
  <head>
    <meta charset='utf-8'/>
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <!-- 
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth'
        });
        calendar.render();
      });
    </script>
     -->
    <script >
    document.addEventListener("DOMContentLoaded", function () {
    	  var calendarEl = document.getElementById("calendar");

    	  var calendar = new FullCalendar.Calendar(calendarEl, {
    	    selectable: true,
    	    headerToolbar: {
    	      left: "prev,next today",
    	      center: "title",
    	      right: "dayGridMonth,timeGridWeek,timeGridDay"
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
  </head>
  <body>
    <div id='calendar'></div>
  </body>
</html>