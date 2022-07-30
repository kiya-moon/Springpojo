	const form = document.querySelector('#form_sw_wrap');	//데이터를 전송하는 form
	const checkAll = document.querySelector('.sw_checkAll input');	// 모두 동의 체크박스
	const checkBoxes = document.querySelectorAll('.sw_inputCheck input');	// 모두 동의 제외 체크박스
	const submitButton = document.querySelector('button');	// 확인 버튼

	const agreements = {
	  termsOfService: false,		// 첫번째 필수동의 체크박스
	  privacyPolicy: false,			// 두번째 필수동의 체크박스
	  ElectronicTransaction: false,	// 세번째 필수동의 체크박스
	};

	form.addEventListener('submit', (e) => e.preventDefault()); // 새로고침(submit) 되는 것 막음

	checkBoxes.forEach((item) => item.addEventListener('input', toggleCheckbox));

	function toggleCheckbox(e) {
	  const { checked, id } = e.target;  
	  agreements[id] = checked;
	  this.parentNode.classList.toggle('active');
	  checkAllStatus();
	  toggleSubmitButton();
	}

	function checkAllStatus() {
	  const { termsOfService, privacyPolicy, ElectronicTransaction } = agreements;
	  if (termsOfService && privacyPolicy && ElectronicTransaction) {
	    checkAll.checked = true;
	  } else {
	    checkAll.checked = false;
	  }
	}
	
	// 확인버튼
	function toggleSubmitButton() {
	  const { termsOfService, privacyPolicy, ElectronicTransaction} = agreements;
	  if (termsOfService && privacyPolicy && ElectronicTransaction) {
	    submitButton.disabled = false;	// 버튼 활성화
	  } else {
	    submitButton.disabled = true;	// 버튼 비활성화
	  }
	}
	
	// 모두동의 체크 이벤트
	checkAll.addEventListener('click', (e) => {
	  const { checked } = e.target;
	  if (checked) {
	    checkBoxes.forEach((item) => {
	      item.checked = true;
	      agreements[item.id] = true;
	      item.parentNode.classList.add('active');
	    });
	  } else {
	    checkBoxes.forEach((item) => {
	      item.checked = false;
	      agreements[item.id] = false;
	      item.parentNode.classList.remove('active');
	    });
	  }
	  toggleSubmitButton();
	});