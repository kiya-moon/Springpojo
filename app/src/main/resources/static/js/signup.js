/* 동의하기 체크박스 시작 */
function checkSelectAll()  {
  // 전체 체크박스
  const checkboxes 
    = document.querySelectorAll('input[name="sw_select"]');
  // 선택된 체크박스
  const checked 
    = document.querySelectorAll('input[name="sw_select"]:checked');
  // select all 체크박스
  const selectAll 
    = document.querySelector('input[name="sw_selectAll"]');
  
  if(checkboxes.length === checked.length)  {
    selectAll.checked = true;
  }else {
    selectAll.checked = false;
  }

}

function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('sw_select');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}
/* 동의하기 체크 박스 끝  */
 
 
 
 // 회원가입
 function signSend(){
	let f = document.signup;
	let userId = f.userId;
	let userPw = f.userPw;
	let userPwCheck = f.userPwCheck;
	let userName = f.userName;
	let userBirth = f.userBirth;
	let userEmail = f.userEmail;
	
	// 아이디 입력 안 했을때
	if(userId == ""){
		alert("아이디를 입력 해주세요.");
		userId.focus();
		return false;
	}
	
	var re1 = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{4,16}$/;
	
	if(!re1.test(userId.value)) {
		alert("아이디는 6~16자리 영문, 숫자 조합으로 입력 해주세요.");
		userId.focus();
		return false;
	}
	
	// 비밀번호 입력 안 했을때
	if(userPw.value == "") {
		alert("비밀번호를 입력 해주세요.");
		userPw.focus();
		return false;
	}
	
	var re2 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
	
	if(!re2.test(userPw.value)) {
		alert("비밀번호는 *~16자 영문, 숫자, 특수문자 조합으로 입력 해주세요.");
		userPw.focus();
		return false;
	}
	
	if(userPwCheck.value == ""){
		alert("비밀번호 확인을 입력 해주세요.");
		userPwCheck.focus();
		return false;
	}
	
	// 이름 입력 안 했을때
	if(userName.value == ""){
		alert("이름을 입력 해주세요.");
		userName.focus();
		return false;
	}
	
	var re3 =  /^[가-힣]{2,4}$/;
	
	if(!re3.test(userName.value)){
		alert("이름을 정확히 적어주세요.");
		userName.focus();
		return false;
	}
	
	// 생년월일 입력 안 했을때
	if(userBirth.value == ""){
		alert("생년월일을 입력 해주세요.");
		userBirth.focus();
		return false;
	}
	
	var re4 = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
	
	if(!re4.test(userBirth.value)){
		alert("생년월일은 8자리 숫자로 입력 해주세요.");
		userBirth.focus();
		return false;
	}
	
	// 이메일 입력 안 했을때
	if(userEmail.value == ""){
		alert("이메일을 입력 해주세요.");
		userEmail.focus();
		return false;
	}
	
	var re5 = /^[a-zA-Z0-9+-_.]$/;
	
	if(!re5.test(userEmail.value)){
		alert("이메일 형식에 맞게 입력 해주세요.")
		userEmail.focus();
		return false;
	}
	
	// 전화번호 입력 안 했을때
	if(userPhone.value == ""){
		alert("전화번호를 입력 해주세요.");
		userPhone.focust();
		return false;
	}
	
	var re6 = /^01([0|1|6|7|8|9])-?([0-9]{4})-?([0-9]{4})$/;
	
	if(!re6.test(userPhon.value)){
		alert("전화번호 형식에 맞게 입력해주세요.");
		userPhone.focus();
		return false;
	}
	
	f.submit();
}


