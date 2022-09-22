	$(document).ready(function(){
		$("#user").show();
		$("#like").hide();
		$("#sale").hide();
		$("#success").hide();
		$("#bid").hide();
	});

	
			/* 페이지 hide&show */
			$(document).ready(function(){
				$("#list-sale-list").click(function(){
					$("#user").hide();
					$("#success").hide();
					$("#bid").hide();
					$("#like").hide();
					$("#sale").show();
				});
			});

			$(document).ready(function(){
				$("#list-success-list").click(function(){
					$("#user").hide();
					$("#sale").hide();
					$("#bid").hide();
					$("#like").hide();
					$("#success").show();
				});
			});

			$(document).ready(function(){
				$("#list-bid-list").click(function(){
					$("#bid").show();
					$("#user").hide();
					$("#sale").hide();
					$("#success").hide();
					$("#like").hide();
				});
			});
			
			$(document).ready(function(){
				$("#list-like-list").click(function(){
					$("#like").show();
					$("#user").hide();
					$("#sale").hide();
					$("#success").hide();
					$("#bid").hide();
				});
			});
			
			$(document).ready(function(){
				$("#list-user-list").click(function(){
					$("#user").show();
					$("#like").hide();
					$("#sale").hide();
					$("#success").hide();
					$("#bid").hide();
				});
			});
			
/* 동의하기 체크박스 시작 */
function checkListAll()  {
  // 전체 체크박스
  const checkboxes 
    = document.querySelectorAll('input[name="one"]');
  // 선택된 체크박스
  const checked 
    = document.querySelectorAll('input[name="one"]:checked');
  // select all 체크박스
  const ListAll 
    = document.querySelector('input[name="full"]');
  
  if(checkboxes.length === checked.length)  {
     ListAll.checked = true;
  }else {
     ListAll.checked = false;
  }

}

function ListAll(ListAll)  {
  const checkboxes 
       = document.getElementsByName("one");
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = ListAll.checked;
  })
}
/* 동의하기 체크 박스 끝  */

//<!-- 페이지 접속 시 초기화 스크립트 -->
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