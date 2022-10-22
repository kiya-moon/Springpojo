const autoHyphen = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

	function closeModal(){
		var closeModal = document.querySelector("sw_modal");
		closeModal.classList.add("closeModal");
	}

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

