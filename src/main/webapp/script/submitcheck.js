function submitCheck() {
	if(document.frm.in_date.value.length == 0) {
		alert("입력 할 날짜를 선택해주세요.");
		frm.in_date.focus();
		return false;
	}
	
	if(document.frm.in_out.value.length == 0) {
		alert("수입/지출 항목을 선택해주세요.");
		frm.in_out.focus();
		return false;
	}
	
	if(document.frm.amount.value.length == 0) {
		alert("금액을 입력해주세요.");
		frm.amount.focus();
		return false;
	}

	if(document.frm.payment.value.length == 0) {
		alert("카드/현금/이체 항목을 선택해주세요.");
		frm.payment.focus();
		return false;
	}	
	
	if(isNaN(document.frm.amount.value)) {
		alert("가격은 숫자로만 입력해 주세요");
		frm.amount.focus();
		return false;
	}
	return true;
}