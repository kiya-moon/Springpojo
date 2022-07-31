	function closeModal(){
		var closeModal = document.querySelector("sw_modal");
		closeModal.classList.add("closeModal");
	}


// 로그인 아이디, 비밀번호 입력 안했을 시
function LoginOn() {
	let f = document.login;
	let userId = f.userId
	let userPw = f.userPw;
	
	if (userId.value == "") {
		alert("아이디를 입력 해주세요");
		userId.focus();
		return false;
	}
	
	if (userPw.value == "") {
		alert("비밀번호를 입력 해주세요.");
		userPw.focus();
		return false;
	}
	
	f.submit();
}


