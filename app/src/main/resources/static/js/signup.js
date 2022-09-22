var chk_dupli = 0;
var pw_chk = 0;
var name_chk = 0;
var birth_chk = 0;
var email_chk = 0;
var phone_chk = 0;
var pw_reg = new RegExp(/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/);
var name_reg = new RegExp(/^[가-힣]{2,4}$/);
var birth_reg = new RegExp(/^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/);
var email_reg = new RegExp(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i);
const autoHyphen = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}
function signChk() {
	if(chk_dupli == 0){
		alert('아이디 중복체크를 해주세요.');
	return false;

	}
	
	if(pw_chk == 0){
		return false;
	}
	
	if(name_chk == 0){
		return false;
	}
	
	if(birth_chk == 0){
		return false;
	}
  
	if(email_chk == 0){

		return false;
	}
	if(phone_chk == 0){
		return false;
	}
	document.signup.submit();
}

$(function() {
	//	$('#userId').keyup(function() {
	//		if($('#userId').val().length <= 4){
	//			document.getElementById("text").innerHTML = "<p style='color:red;'>아이디는 4자 이상으로 입력해주세요.</p>";
	//			$('#sw_btnColor').attr("disabled", "disabled");
	//		}else{
	//			document.getElementById("text").remove();
	//			$('#sw_btnColor').removeAttr("disabled");
	//		}
	//	})
	//	$('#UserPw').keyup(function() {
	//		$('#chkNotice').html('');
	//	});
	//
	$('#userName').keyup(function(){
		if($('#userName').val() == ""){
			$('#chkNotice_N').html('이름을 입력해주세요.<br>');
			$('#chkNotice_N').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			name_chk = 0;
		} else if(!name_reg.test($("input[name=userName]").val())){
			$('#chkNotice_N').html('이름을 확인해주세요.<br>');
			$('#chkNotice_N').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			name_chk = 0;

		}else{
			$('#chkNotice_N').html('');
			$('#sw_btnColor').removeAttr("disabled");
			name_chk = 1;
			
		}
	});
	$('#userBirth').keyup(function() {
		if($('#userBirth').val() == ""){
			$('#chkNotice_B').html('생년월일을 입력해주세요.<br>');
			$('#chkNotice_B').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			birth_chk = 0;
		} else if(!birth_reg.test($("input[name=userBirth]").val())){
			$('#chkNotice_B').html('알맞지 않은 형식입니다.(숫자8자리)<br>');
			$('#chkNotice_B').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			birth_chk = 0;
		}else{
			$('#chkNotice_B').html('');
			$('#sw_btnColor').removeAttr("disabled");
			birth_chk = 1;
		}
	});
	$('#userEmail').keyup(function() {
		if($('#userEmail').val() == ""){
			$('#chkNotice_E').html('이메일을 입력해주세요.<br>');
			$('#chkNotice_E').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			email_chk = 0;
		} else if(!email_reg.test($("input[name=userEmail]").val())){
			$('#chkNotice_E').html('이메일 형식을 확인해주세요.<br>');
			$('#chkNotice_E').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			email_chk = 0;
		}else{
			$('#chkNotice_E').html('');
			$('#sw_btnColor').removeAttr("disabled");
			email_chk = 1;
		}
	});
	$('#userPhone').keyup(function(){
		if($('#userPhone').val() == ""){
			$('#chkNotice_P').html('전화번호를 입력해주세요.<br>');
			$('#chkNotice_P').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			phone_chk = 0;
		}else if($('#userPhone').val().length < 13){
			$('#chkNotice_P').html('전화번호를 확인해주세요.<br>');
			$('#chkNotice_P').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			phone_chk = 0;
		}
		else {
			$('#chkNotice_P').html('');
			$('#sw_btnColor').removeAttr("disabled");
			phone_chk = 1;
		}
	})

$('#userPwCheck').keyup(function() {
		if ($('#userPw').val() != $('#userPwCheck').val()) {
			$('#chkNotice').html('비밀번호가 일치하지 않습니다.<br>');
			$('#chkNotice').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			pw_chk = 0;
		} else if(!pw_reg.test($("input[name=userPw]").val())){
			$('#chkNotice').html('비밀번호는 숫자,문자,특수문자를 포함한 8자리이상으로 입력해주세요.<br>');
			$('#chkNotice').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			pw_chk = 0;
		} else {
			$('#chkNotice').html('비밀번호가 일치합니다.<br>');
			$('#chkNotice').attr('color', '#199894b3');
			$('#sw_btnColor').removeAttr("disabled");
			pw_chk = 1;
		}
		if ($('#userPw').val().length <= 7) {
			$('#chkNotice').html('비밀번호는 8자리 이상으로 입력해주세요<br>');
			$('#chkNotice').attr('color', '#f82a2aa3');
			$('#sw_btnColor').attr("disabled", "disabled");
			pw_chk = 0;
		}
	});
});


function checkId() {
	var userId = $('#userId').val();
	var id_reg = /^[A-za-z]+[a-zA-z0-9]{3,15}$/g;
		$.ajax({
			type: "GET",
			url: "/signup.do/idChk",
			data: { userId: userId },
			success: function(data) {
				if (data != null) {
					document.getElementById("text").innerHTML = "<p style='color:red;'>중복된 아이디 입니다.</p>";
					$('#sw_btnColor').attr("disabled", "disabled");
					chk_dupli = 0;
				} else {
					if ($('#userId').val().length <= 3) {
						document.getElementById("text").innerHTML = "<p style='color:red;'>아이디는 4자 이상으로 입력해주세요.</p>";
						$('#sw_btnColor').attr("disabled", "disabled");
						chk_dupli = 0;
					}else if (!id_reg.test($("input[name=userId]").val())){
						document.getElementById("text").innerHTML = "<p style='color:red;'>아이디는 4자이상, 영문+숫자 조합이어야합니다.</p>";
						$('#sw_btnColor').attr("disabled", "disabled");
						chk_dupli = 0;
					}
					else {
						document.getElementById("text").innerHTML = "<p style='color:blue;'>사용할수 있는 아이디 입니다.</p>";
						$('#sw_btnColor').removeAttr("disabled");
						chk_dupli = 1;
					}
				}
			}

		})
}