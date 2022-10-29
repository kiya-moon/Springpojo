var likeChk;
var likeImg = document.getElementById("like_off");

function likeChks(){
	if(likeChk == "Y"){
		likeImg.src="img/likeon.png";
	}else {
		likeImg.src="img/likeoff.png";
	}
}

function imgToggle(){
	var img1 = document.getElementById("like_off");
	var userId= document.getElementById("userId").value;
	var id= document.getElementById("id").value;
	$.ajax({
		type:"POST",
		url:"/updateLike/"+id,
		data:{userId: userId},
		success: function(data){
			if(data == 1){
				img1.src="img/likeoff.png";
				likeChk = "Y";
			} else {
				img1.src="img/likeon.png";
				likeChk = "N";
			}
	$.ajax({
		type:"GET",
		url:"/updateLike/"+id,
		data:{userId: userId},
		async: false,
		success: function(data){
			$('#likeCnt').text(data);
			console.log("likeCnt Test" + data);
		}
	})
		}
		
	})
	
	
	
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

function remindTime(){
				var end = document.getElementById('endDate').value;
				var dday = new Date(end).getTime();
				var now = new Date().getTime();


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
			 
			 if(sec <= 0){
				$.ajax({
					url: '/delete',
					type:'DELETE',
					success: function(data){
						
					}
				})
			}
			
			 }

$(document).ready(remindTime())
			      