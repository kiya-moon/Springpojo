function pw_search() {
	let f = document.forgotPw;
	let userId = f.userId;
	let userName = f.userName;
	let userPhone = f.userPhone;

	if (userId.value == "") {
		alert("아이디를 입력 해주세요");
		userId.focus();
		return false;
	}

	if (userName.value == "") {
		alert("이름을 입력 해주세요");
		userName.focus();
		return false;
	}

	if (userPhone.value == "") {
		alert("전화번호를 입력 해주세요");
		userPhone.focus();
		return false;
	}

	f.submit();
}