<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.js"></script>
<meta charset='utf-8' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
    	
 /*   	eventClick: function(info) {
    	      var eventObj = info.event;

    	      if (eventObj.url) {
    	        alert(
    	          'Clicked ' + eventObj.title + '.\n' +
    	          'Will open ' + eventObj.url + ' in a new tab'
    	        );

    	        window.open(eventObj.url);

    	        info.jsEvent.preventDefault(); // prevents browser from following link in current tab.
    	      } else {
    	        alert('Clicked ' + eventObj.title);
    	      }
    	    },  */
    	    
        events: function(fetchInfo, successCallback, failureCallback) {
            $.ajax({
                url: '/Projectmoney/servlet-url',
                type: 'GET',
                success: function(result) {
                    successCallback(result);
                },
                error: function(err) {
                    failureCallback(err);
                }
            });

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