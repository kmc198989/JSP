function managerCheck(){
	if(document.frm.name.value.length == 0){
		alert("이름을 입력해주세요");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력해주세요");
		frm.pass.focus();
		return false;
	}
	
	/* 숫자말고 다른문자 입력시
	if(isNaN(document.frm.code.value)){
		alert("전화번호는 숫자만 입력 가능합니다");
		frm.price.focus();
		return false;	
	}
	return true;
	*/
}