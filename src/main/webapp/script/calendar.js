document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: "prev,next today",
            center: "title",
            right: "dayGridMonth"
        },
        selectable: true,
        dateClick: function(info) {
            // 결제 내역을 토글
            toggleCashbookVisibility();
        },
        events: function(fetchInfo, successCallback, failureCallback) {
            $.ajax({
                url: '/Projectmoney/servlet-url',
                type: 'GET',
                data: {
                    // userCode 변수를 사용하여 서블릿에 code 값을 전송
                    code: userCode
                },
                success: function(result) {
                    // 결과를 파싱하여 events 배열로 변환해야 할 수도 있습니다.
                    // 이 부분은 서버에서 반환하는 데이터 형식에 따라 다릅니다.
                    successCallback(result);
                },
                error: function(err) {
                    failureCallback(err);
                }
            });
        }
    });

    calendar.render();
    
        // 결제 내역을 숨기거나 나타내는 함수
    function toggleCashbookVisibility() {
        var cashbook = document.getElementById("cashbook");
        if (cashbook.style.display === "none") {
            cashbook.style.display = "block"; // 나타내기
        } else {
            cashbook.style.display = "none"; // 숨기기
        }
    }

});
