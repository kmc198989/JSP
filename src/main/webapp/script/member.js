function productCheck(){
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력해주세요");
		frm.price.focus();
		return false;
	}
	
	// 숫자말고 다른문자 입력시
	if(isNaN(document.frm.price.value)){
		alert("가격은 숫자만 입력 가능합니다");
		frm.price.focus();
		return false;	
	}
	return true;
}