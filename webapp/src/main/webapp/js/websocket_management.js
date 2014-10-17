var $message;
var $logWindow;
var room = '';

var payload;
var topic = 'management';


$(document).ready(function() {
	$message = $('#message');
	$logWindow = $('#response');
	$('.control-wrapper').hide();
	$('.log-wrapper').hide();
	$('.gui-wrapper').hide();
	$('.init-wrapper').hide();
	
	$('#do-log').submit(function(evt) {
		evt.preventDefault();
		sendMessage()
	});

	$('#enterRoom').click(function(evt) {
		evt.preventDefault();
		connectToChatserver();
		$('.status').text(' Connection @' + serviceLocation + room);
		$('.signin-wrapper').hide();
		$('.control-wrapper').show();
		$('.log-wrapper').hide();
		$('.gui-wrapper').hide();
		$('.init-wrapper').hide();
		$message.focus();
	});

	$('#switch_exit').click(function(){
		$('.control-wrapper').hide();
		$('.log-wrapper').hide();
		$('.gui-wrapper').hide();
		$('.init-wrapper').hide();
		$('.signin-wrapper').show();
		leaveRoom();
	});
	
	$('#switch_gui').click(function(){
		$('.gui-wrapper').toggle();
	});
	
	$('#switch_log').click(function(){
		$('.log-wrapper').toggle();
	});
	
	$('#switch_controls').click(function(){
		$('.init-wrapper').toggle();
	});
	
});

function sendMessage() {
	
	var msg =
		'{'+		
		'"payload":"' + $message.val() + '", ' +
		'"topic":"' + room + '"' +
		'}';

	wsocket.send(msg);
	$message.val('').focus();
}
