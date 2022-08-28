var cnt = 1;

function imgToggle(){

	var img1 = document.getElementById("like_off");
	
	if(cnt%2 == 1){
		img1.src="img/likeon.png";
	}else{
		img1.src="img/likeoff.png";
		}
		cnt++;
		}
		
function chk_price(){
	var p1 = document.getElementById('startPrice').value;
	var p2 = document.getElementById('checkPrice').value;
	
	if(p1 == p2){
		alert('입찰금액을 확인해주세요.');
		return false;
	}
	
	document.getElementById('new_price').submit();
}

$('document').ready(function (){
	
	var sendData = "period"+$('input[name=period]').val();
	$.ajax({
		type: "POST",
		url: "localhost:9091/product",
		data: sendData,
		success: function(data){
			setInterval(1000)
		}
		
	})
})
	
