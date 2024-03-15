function comuCheck(){
	if(document.frm.c_title.value.length == 0){
		alert("제목을 입력해 주세요");
		frm.c_title.focus();
		return false;
	}
	
	if(document.frm.c_post.value.length == 0){
		alert("내용을 입력해 주세요");
		frm.c_post.focus();
		return false;
		}
	var selectedDate = document.frm.c_post_date.value;	
	if(!selectedDate){
		alert("날짜를 선택해 주세요");
		document.frm.c_post_date.focus();
      	return false;   
	}
	return true;
}

function deleteRow(button)
{
	var row = button.parentNode.parentNode;
	row.prentNode.removeChild(row);
}
function deleteRow(postNum){
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href = "comuDelete.do?code=" + postNum;
			}
		}
		
// 현재 날짜를 가져오는 함수
    function getCurrentDate() {
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = ('0' + (currentDate.getMonth() + 1)).slice(-2);
        var day = ('0' + currentDate.getDate()).slice(-2);
        return year + '-' + month + '-' + day;
    }

    // 페이지 로드 시 실행되는 함수
    window.onload = function() {
        // 현재 날짜를 가져와서 날짜 필드에 자동으로 입력
      var dateFields = document.querySelectorAll('.date-field'); // 날짜 필드 선택
        for (var i = 0; i < dateFields.length; i++) {
            dateFields[i].value = getCurrentDate(); // 현재 날짜 설정
            dateFields[i].readOnly = true; // 읽기 전용으로 설정
        }
    };