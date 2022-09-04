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

$(document).ready(function remindTime(){
				var end = document.getElementById('endDate').value;
				var dday = new Date(end).getTime();
				var now = new Date().getTime();
				console.log("end" + end);
				console.log("dday : " + dday);
				console.log("now" + now);


				 $(".time").fadeIn();
			     sec = parseInt(dday - now) / 1000;
			     day  = parseInt(sec/60/60/24);
			     sec = (sec - (day * 60 * 60 * 24));
			     hour = parseInt(sec/60/60);
			     sec = (sec - (hour*60*60));
			     min = parseInt(sec/60);
			     sec = parseInt(sec-(min*60));
			     if(hour<10){hour="0"+hour;}
			     if(min<10){min="0"+min;}
			     if(sec<10){sec="0"+sec;}
			      $(".day").html(day);
			      $(".hours").html(hour);
			      $(".minutes").html(min);
			      $(".seconds").html(sec);
			      
			 setInterval(remindTime,1000);
			
			 })
			      