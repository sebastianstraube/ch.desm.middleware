var wsocket;
var serviceLocation = "ws://localhost:8080/gui/";

function onMessageReceived(evt) {
	
	alert(evt.data);
	
	var msg = JSON.parse(evt.data); // native API
	var $messageLine = $('<tr><td class="received">' + ""
			+ '</td><td class="user label label-info">' + msg.topic
			+ '</td><td class="message badge">' + msg.payload
			+ '</td></tr>');
	$logWindow.append($messageLine);
}

function connectToChatserver() {
	room = $('#logroom option:selected').val();
	wsocket = new WebSocket(serviceLocation + room);
	wsocket.onmessage = onMessageReceived;
}

function leaveRoom() {
	wsocket.close();
	$logWindow.empty();
}
