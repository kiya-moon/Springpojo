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

function checkOnlyOne(element) {
  
  const checkboxes 
      = document.getElementsByName("date");
  
  checkboxes.forEach((cb) => {
    cb.checked = false;
  })
  
  element.checked = true;
}

function deleteImg(){
	document.getElementById('img_upload').src="http://pics.auction.co.kr/sell/basic/img_no_286x286.gif";
	document.getElementById('upload_product').style.display="block";
	
}
