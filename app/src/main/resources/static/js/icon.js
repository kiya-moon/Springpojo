var chatRoom_width = 450;
var chatRoom_height = 500;
var positionX = (window.screen.width /2 ) - (chatRoom_width /2);
var positionY = (window.screen.height /2 ) - (chatRoom_height /2);
function chatRoom(){
	window.open("/chat", "ChatRoom", "width=" + chatRoom_width + ", height=" + chatRoom_height + ", top=" + positionY + ", left=" + positionX);
}
