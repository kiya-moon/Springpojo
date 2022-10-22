
// 페이지 접속 시 초기화 스크립트 -->
	$(document).ready(function() {
	
	});


//<!-- 이벤트, 함수 선언 스크립트 -->

	//검색창 클릭 시 검색 결과 보여주는 팝업 열기
	$("#nav-search-bar").on("click", function(e) {
		$("#speech-bubble-wrapper").show();
	});
	
	//외부 영역 클릭 시 검색 결과 보여주는 팝업 닫기
	$(document).on("mouseup", function(e){
		if($("#speech-bubble-wrapper").has(e.target).length == 0){
			$("#speech-bubble-wrapper").hide();
		}
	});
	
	//스크롤에 따른 애니메이션 효과
	var furnitureElectronic = $("#popular-product-list-furniture-electronic");
	var gameHobby = $("#popular-product-list-game-hobby");
	var sportsCar = $("#popular-product-list-sports-car");
	var bookEtc = $("#popular-product-list-book-etc");
	
	$(window).scroll(function(e) {
		var scrollValue = $(document).scrollTop(); 
		if(scrollValue >= 700){
			furnitureElectronic.removeClass('active');
		}
		if(scrollValue >= 1400){
			gameHobby.removeClass('active');
		}
		if(scrollValue >= 2100){
			sportsCar.removeClass('active');
		}
		if(scrollValue >= 2800){
			bookEtc.removeClass('active');
		}
	});
	
	// 채팅창 크기 조절
	var chatRoom_width = 450;
	var chatRoom_height = 500;
	var positionX = (window.screen.width /2 ) - (chatRoom_width /2);
	var positionY = (window.screen.height /2 ) - (chatRoom_height /2);
	function chatRoom(){
		window.open("/chat", "ChatRoom", "width=" + chatRoom_width + ", height=" + chatRoom_height + ", top=" + positionY + ", left=" + positionX);
	}