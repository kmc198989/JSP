document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {    	
    	    
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
