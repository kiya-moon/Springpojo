function id_search() {
	let f = document.forgotId;
	let userName = f.userName;
	let userPhone = f.userPhone;

	if (userName.value == "") {
		alert("이름을 입력해주세요");
		userName.focus();
		return false;
	}

	if (userPhone.value == "") {
		alert("전화번호를 입력해주세요");
		userPhone.focus();
		return false;
	}

	f.submit();
}