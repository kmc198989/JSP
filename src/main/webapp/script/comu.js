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