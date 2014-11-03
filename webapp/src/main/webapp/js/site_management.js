var $message;
var $logWindow;
var wsocket;
var serviceLocation;
var component;
var hostname;
var hostport;
var filter_array;
var logId;

if (typeof String.prototype.startsWith != 'function') {
    String.prototype.startsWith = function (str){
        return this.slice(0, str.length) == str;
    };
}

$(document).ready(function() {
    init();

    function blink() {
        $("#status_blinking").fadeTo(100, 0.1).fadeTo(200, 1.0);
    }

    function init(){
        $message = $('#message');
        $logWindow = $('#log-window');
        filter_array = [];
        logId = 1;

        $('.status-wrapper').hide();
        $('.control-wrapper').hide();
        $('.log-wrapper').hide();
        $('.gui-wrapper').hide();
        $('.init-wrapper').hide();
        $('.communication-wrapper').hide();
        $('.status-wrapper').hide();
        $('.remote-wrapper').hide();

        setInterval(function(){blink()}, 1000);
    }

    function onMessageReceived(evt) {
        var msg = JSON.parse(evt.data); // native API

        var $messageLine = $('' +
            '<tr>' +
            '</td><td>' + logId++ +
            '</td><td class="label-info">' + msg.topic +
            '</td><td class="message badge">' + msg.payload + '</td>' +
            '</tr>'
        ).prependTo($logWindow.find('tbody'));

        if ($.inArray(msg.topic, filter_array) == -1){
            filter_array.push(msg.topic);
            alert(filter_array.toString());
        }

    }

    function connectWebsocketServer() {
        component = $('#component option:selected').val();
        hostname = $('#hostname option:selected').val();
        hostport = $('#hostport option:selected').val();
        serviceLocation = "ws://"+hostname+":"+hostport+"/gui/";
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
        $('.status').text('Connection not Established');
        $('.log-wrapper').hide();
        $('.gui-wrapper').hide();
        $('.init-wrapper').hide();
        $('.signin-wrapper').show();
        $('.communication-wrapper').hide();
        $('.control-wrapper').hide();
        $('.status-wrapper').hide();
        $('.remote-wrapper').hide();

        $('#status_text').empty();
        $logWindow.empty();
        location.reload();
    }

	$('#do-log').submit(function(evt) {
		evt.preventDefault();
		sendMessage($message.val());
	});

	$('#connect').click(function(evt) {
        $('#switch_exit').removeClass('btn-primary');
        $('#switch_exit').addClass('btn-success');
		evt.preventDefault();
        connectWebsocketServer();

        $('.status').text('Connection Established to Middleware');
		$('#status_text').append(serviceLocation + component);
		$('.signin-wrapper').hide();
		$('.init-wrapper').hide();
        $('.control-wrapper').show();
		$('.log-wrapper').hide();
		$('.gui-wrapper').hide();
        $('.communication-wrapper').hide();
        $('.remote-wrapper').hide();
	});

	$('#switch_exit').click(function(){
        $('#connect').removeClass('btn-primary');
        $('#connect').addClass('btn-danger');
        leaveComponent();
	});
	
	$('#switch_gui').click(function(){
        $('.gui-wrapper').toggle();
	});
	
	$('#switch_log').click(function(){
        $('.log-wrapper').toggle();
	});
	
	$('#switch_init').click(function(){
        $('.init-wrapper').toggle();
	});

    $('#switch_communication').click(function(){
        $('.communication-wrapper').toggle();
        $message.focus();
    });

    $('#switch_status').click(function(){
        $('.status-wrapper').toggle();
    });

    $('#switch_remote').click(function(){
        $('.remote-wrapper').toggle();
    });

    //INIT
    $('#init_interlocking').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;init;management;#")
    });

    $('#init_petrinet').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;init;management;#")
    });

    $('#init_cabine-ubw32').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;init;management;#")
    });

    $('#init_cabine-fabisch').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;init;management;#")
    });

    $('#init_locsim-rs232').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;init;management;#")
    });

    $('#init_locsim-dll').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;init;management;#")
    });
    
    //start
    $('#start_interlocking').click(function(){
        $(this).toggleClass('btn-success');
    });

    $('#start_petrinet').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;start;management;#")
    });

    $('#start_cabine-ubw32').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;start;management;#")
    });

    $('#start_cabine-fabisch').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;start;management;#")
    });

    $('#start_locsim-rs232').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;start;management;#")
    });

    $('#start_locsim-dll').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;start;management;#")
    });

    //stop
    $('#stop_interlocking').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;stop;management;#")
    });

    $('#stop_petrinet').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;stop;management;#")
    });

    $('#stop_cabine-ubw32').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;stop;management;#")
    });

    $('#stop_cabine-fabisch').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;stop;management;#")
    });

    $('#stop_locsim-rs232').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;stop;management;#")
    });

    $('#stop_locsim-dll').click(function(){
        $(this).toggleClass('btn-success');
        sendMessage("mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;stop;management;#")
    });


    //GUI
    $('#w1_change').on({
        'click': function(){
            $('#w1_image').attr('src','../img/iltis_arrowright-green.png');
        }
    });

    //REMOTE
    $('#remote_change_on_1').on({
        'click': function(){
            $('#remote_img_1').attr('src','../img/remote_on.png');
        }
    });

    $('#remote_change_off_1').on({
        'click': function(){
            $('#remote_img_1').attr('src','../img/remote_off.png');
        }
    });

});


