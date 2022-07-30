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