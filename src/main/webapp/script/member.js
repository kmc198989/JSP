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
//아이디 중복 체크 함수


function idCheck(){
   if(document.frm.id.value==""){
      alert("아이디를 입력해 주세요");
      document.frm.id.focus();
      return;
   }
   
   var url ="idok.do?id="+document.frm.id.value;
   window.open(url,"_blank_1", "toolbar=no, memubar=no,scrollbars=yes, resizable=no, width=450, height=200");
}


function idok(){
   opener.frm.id.value=document.frm.id.value;
   opener.frm.reid.value=document.frm.id.value;
   self.close();
}


function joinCheck(){
   if(document.frm.name.value.length==0){
      alert("이름을 입력 하세요.");
      frm.name.focus();
      return false;
   }
   if(document.frm.id.value.length==0){
      alert("아이디를 입력 하세요.");
      frm.id.focus();
      return false;
   }
   if(document.frm.id.value.length < 4){
      alert("아이디는 최소 4글자 이상이어야 합니다.");
      frm.id.focus();
      return false;
   }
   
   if(document.frm.pass.value == ""){
      alert("암호는 반드시 입력해야 합니다.");
      frm.pass.focus();
      return false;
   }
   
   if(document.frm.pass.value != document.frm.pass_check.value){
      alert("암호가 일치하지 않습니다.");
      frm.pass.focus();
      return false;
   }
   
   if(document.frm.reid.value.length==0){
      alert("중복 체크를 하지 않았습니다.");
      frm.id.focus();
      return false;
   }
   
   
         
}