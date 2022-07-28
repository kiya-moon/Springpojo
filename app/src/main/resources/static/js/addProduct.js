// 이미지 업로드
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('img_upload').src = e.target.result;
			document.getElementById('upload_product').style.display="none";
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('img_upload').src = "";
	}
}

// 체크박스 중복체크불가
function checkOnlyOne(element) {
  
  const checkboxes 
      = document.getElementsByName("date");
  
  checkboxes.forEach((cb) => {
    cb.checked = false;
  })
  
  element.checked = true;
}

// 이미지 삭제버튼
function deleteImg(){
	document.getElementById('img_upload').src="http://pics.auction.co.kr/sell/basic/img_no_286x286.gif";
	document.getElementById('upload_product').style.display="block";
	document.getElementById('upload_box').value='';
//	$('#upload_box').val('');
}

// addForm 널값 체크
function chkNull(){
if(document.getElementById('upload_box').value==""){
	alert('상품 이미지를 등록해주세요.');
	return false;
}

	if(document.getElementById('productNameBox').value==""){
	alert('상품명을 입력해주세요.');
	return false;
}

if(document.getElementById('categorySelect').value=="selectOne"){
	alert('카테고리를 선택해주세요.');
	return false;
}

if(document.getElementById('productPriceBox').value==""){
	alert('경매시작 금액을 입력해주세요.');
	return false;
}

if(document.getElementById('productPriceBox').value<0){
	alert('최소 금액은 0원입니다.');
	return false;
}

if((document.getElementById('productPriceBox').value%1000)!=0){
	alert('시작금액은 1000원 단위로 입력해주세요.');
	return false;
}

if(!document.getElementById('cbDate').checked&&!document.getElementById('cbDate2').checked&&!document.getElementById('cbDate3').checked){
	alert('경매기간을 선택해주세요.');
	return false;
}

document.getElementById('addForm').submit();
}