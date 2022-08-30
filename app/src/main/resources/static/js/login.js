// 로그인 아이디, 비밀번호 입력 안했을 시
function LoginOn() {
	let userId = document.getElementById('userId').value;
	let userPw = document.getElementById('userPw').value;
	
	if(userId == "") {
		alert("아이디를 입력 해주세요");
		userId.focus();
		return false;
	}
	
	if (userPw == "") {
		alert("비밀번호를 입력 해주세요.");
		userPw.focus();
		return false;
	}
	document.getElementByName('login').submit();
}


