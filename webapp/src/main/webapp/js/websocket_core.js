var wsocket;
var serviceLocation = "ws://127.0.0.1:8080/gui/";
var component;

function onMessageReceived(evt) {
	var msg = JSON.parse(evt.data); // native API

    var $messageLine = $('' +
            '<tr><td class="received">' + ""
        +   '</td><td class="label-info">' + msg.topic
        +   '</td><td class="message badge">' + msg.payload
        +   '</td></tr>');

    $messageLine.prependTo($logWindow.find('tbody'));
}

function connectWebsocketServer() {
    component = $('#component option:selected').val();
	wsocket = new WebSocket(serviceLocation + component);
	wsocket.onmessage = onMessageReceived;
}

function sendMessage(payload) {
    var msg =
        '{'+
        '"payload":"' + payload + '", ' +
        '"topic":"' + component + '"' +
        '}';
    wsocket.send(msg);
    $message.val('').focus();
}

function leaveComponent() {
	wsocket.close();
	$logWindow.empty();
}