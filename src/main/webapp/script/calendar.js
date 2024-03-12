document.addEventListener('DOMContentLoaded', function() {

    var calendarEl = document.getElementById('calendar');
    
    var calendar = new FullCalendar.Calendar(calendarEl, {    	
        events: function(fetchInfo, successCallback, failureCallback) {
            $.ajax({
                url: '/Projectmoney/servlet-url',
                type: 'GET',
                data: { 				
				    // userCode 변수를 사용하여 서블릿에 code 값을 전송
                    code: userCode
                },
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
