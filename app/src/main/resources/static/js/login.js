// 로그인 아이디, 비밀번호 입력 안했을 시
function LoginOn() {
	let f = document.login;

	
	if($('#userId').val() == "") {
		alert("아이디를 입력 해주세요");
		return false;
	}
	
	if ($('#userPw').val() == "") {
		alert("비밀번호를 입력 해주세요.");
		return false;
	}
	document.getElementsByName('login').submit();
}
*/


// 로그인 아이디, 비밀번호 입력 안했을 시
function LoginOn() {
	let f = document.login;
	let userId = f.userId;
	let userPw = f.userPw;

	if (userId.value == "") {
		alert("아이디를 입력하세요!");
		userId.focus();
		return false;
	}

	if (userPw.value == "") {
		alert("비밀번호를 입력하세요!");
		userPw.focus();
		return false;
	}

	f.submit();
	
}

