 // 회원가입
 function signSend(){
	let f = document.signup;
	let UserId = f.UserId;
	let UserPw = f.UserPw;
	let UserPwCheck = f.UserPwCheck;
	let UserName = f.UserName;
	let UserBirth = f.UserBirth;
	let UserEmail = f.UserEmail;
	let UserPhone = f.UserPhone;
	
	// 아이디 입력 안 했을때
	if(UserId.value == ""){
		alert("아이디를 입력 해주세요.");
		UserId.focus();
		return false;
	}
	
	// 아이디 6~16자리 
	var re1 = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{6,16}$/;
	
	if(!re1.test(UserId.value)) {
		alert("아이디는 6~16자리 영문, 숫자 조합으로 입력 해주세요.");
		UserId.focus();
		return false;
	}
	
	// 비밀번호 입력 안 했을때
	if(UserPw.value == "") {
		alert("비밀번호를 입력 해주세요.");
		UserPw.focus();
		return false;
	}
	
	var re2 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
	
	if(!re2.test(UserPw.value)) {
		alert("비밀번호는 8~16자 영문, 숫자, 특수문자 조합으로 입력 해주세요.");
		UserPw.focus();
		return false;
	}
	
	// 비밀번호 확인 입력 안했을때
	if(UserPwCheck.value == ""){
		alert("비밀번호 확인을 입력 해주세요.");
		UserPwCheck.focus();
		return false;
	}
	
	// 비밀번호와 비밀번호 확인이 일치 하지 않을때
	if(UserPw.value !== UserPwCheck.value){
		alert("비밀번호가 일치 하지 않습니다.");
		UserPwCheck.focus();
		return false;
	}
	
	// 이름 입력 안 했을때
	if(UserName.value == ""){
		alert("이름을 입력 해주세요.");
		UserName.focus();
		return false;
	}
	
	var re3 =  /^[가-힣]{2,5}$/;
	
	if(!re3.test(UserName.value)){
		alert("이름을 정확히 적어주세요.");
		UserName.focus();
		return false;
	}
	
	// 생년월일 입력 안 했을때
	if(UserBirth.value == ""){
		alert("생년월일을 입력 해주세요.");
		UserBirth.focus();
		return false;
	}
	
	var re4 = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
	
	if(!re4.test(UserBirth.value)){
		alert("생년월일은 8자리 숫자로 입력 해주세요.");
		UserBirth.focus();
		return false;
	}
	
	// 이메일 입력 안 했을때
	if(UserEmail.value == ""){
		alert("이메일을 입력 해주세요.");
		UserEmail.focus();
		return false;
	}
	
	var re5 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(!re5.test(UserEmail.value)){
		alert("이메일 형식에 맞게 입력 해주세요.")
		UserEmail.focus();
		return false;
	}
	
	// 전화번호 입력 안 했을때
	if(UserPhone.value == ""){
		alert("전화번호를 입력 해주세요.");
		UserPhone.focus();
		return false;
	}
	
	var re6 = /^01([0|1|6|7|8|9])-?([0-9]{4})-?([0-9]{4})$/;
	
	if(!re6.test(UserPhone.value)){
		alert("전화번호 형식에 맞게 입력해주세요.");
		UserPhone.focus();
		return false;
	}
  
  if( !(UserId == true && UserPw == true && UserPwCheck == true && UserName == true 
  		&& UserBirth == true && UserEmail == true && UserPhone == true) == false){
	} else{
		alert("회원가입 성공");
		f.submit();
	}
}

//중복확인
/*$("#overlapperdID").click(function(){
	$("#signup").attr("type", "button");
	const UserId = $("#UserId").val();
	$.ajax({
	type:"get",
	async: false,
	url: "http://localhost:9090/signup/new",
	data: {UserId: UserId},
	success: function(data){
		if(data == 1) {
			alert("이미 사용중인 ID입니다.");
		}else{
			alert("사용 가능한 ID 입니다.");
			$("#signup").attr("type", "submit");
		}
	}
	})
});*/



