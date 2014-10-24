var $message;
var $logWindow;
var $message;
var $logWindow;

$(document).ready(function() {
	$message = $('#message');
	$logWindow = $('#response');
	$('.control-wrapper').hide();
	$('.log-wrapper').hide();
	$('.gui-wrapper').hide();
	$('.init-wrapper').hide();
	
	$('#do-log').submit(function(evt) {
		evt.preventDefault();
		sendMessage($message.val());
	});

	$('#enterRoom').click(function(evt) {
		evt.preventDefault();
        connectWebsocketServer();

		$('.status').text(' Connection @' + serviceLocation + component);
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
        leaveComponent();
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

    //INIT
    $('#init_petrinet').click(function(){
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;init;management;#")
    });

    $('#init_interlocking').click(function(){
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;init;management;#")
    });

    $('#init_cabine-ubw32').click(function(){
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;init;management;#")
    });

    $('#init_cabine-fabisch').click(function(){
        sendMessage("mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;init;management;#")
    });

    $('#init_locsim-rs232').click(function(){
        sendMessage("mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;init;management;#")
    });

    $('#init_locsim-dll').click(function(){
        sendMessage("mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;init;management;#")
    });
    
    //start
    $('#start_petrinet').click(function(){
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;start;management;#")
    });

    $('#start_interlocking').click(function(){
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;start;management;#")
    });

    $('#start_cabine-ubw32').click(function(){
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;start;management;#")
    });

    $('#start_cabine-fabisch').click(function(){
        sendMessage("mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;start;management;#")
    });

    $('#start_locsim-rs232').click(function(){
        sendMessage("mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;start;management;#")
    });

    $('#start_locsim-dll').click(function(){
        sendMessage("mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;start;management;#")
    });

    //stop
    $('#stop_petrinet').click(function(){
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;stop;management;#")
    });

    $('#stop_interlocking').click(function(){
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;stop;management;#")
    });

    $('#stop_cabine-ubw32').click(function(){
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;stop;management;#")
    });

    $('#stop_cabine-fabisch').click(function(){
        sendMessage("mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;stop;management;#")
    });

    $('#stop_locsim-rs232').click(function(){
        sendMessage("mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;stop;management;#")
    });

    $('#stop_locsim-dll').click(function(){
        sendMessage("mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;stop;management;#")
    });


    //GUI
    $('#w1_change').on({
        'click': function(){
            $('#w1_image').attr('src','../img/iltis_arrowright-green.png');
        }
    });

});


