

if (typeof String.prototype.startsWith != 'function') {
    String.prototype.startsWith = function (str){
        return this.slice(0, str.length) == str;
    };
}

if (typeof String.prototype.replaceAll != 'function') {
    String.prototype.replaceAll = function (finding, replace){

        var escapedRegExp = new RegExp(finding, 'g');
        var replacedText = this.replace(escapedRegExp, replace);

        return replacedText;
    };
}

function escapeRegExp(string) {
    return string.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1");
}


$(document).ready(function() {


    var $message;
    var $logWindow;
    var wsocket;
    var serviceLocation;
    var component;
    var hostname;
    var hostport;
    var filter_array;
    var logId;

    init();

    function init(){

        $message = $('#message');
        $logWindow = $('#log-window');
        filter_array = [];
        logId = 1;

        $('.control-wrapper').hide();
        $('.log-wrapper').hide();
        $('.gui-wrapper').hide();
        $('.init-wrapper').hide();
        $('.communication-wrapper').hide();
        $('.status-wrapper').hide();
        $('#remote-wrapper').hide();


    }

    var alertId = 0;
    function createAutoClosingInfo(selector, delay, text) {

        var newAlert =''+
            '<div class="alert alert-info" id="'+ ++alertId +'">' +
                '<a href="#" class="close" data-dismiss="alert">&times;</a>' +
                text +
            '</div>' +
            '';

        $(selector).append(newAlert);

        var alert = $("#" + alertId);
        alert.alert();

        window.setTimeout(function() {
            alert.fadeTo(500, 0).slideUp(500, function(){
                alert.alert('close');
                alert.remove();
            });
        }, delay);


    }

    var alertId = 0;
    function createAutoClosingAlert(selector, delay, text) {

        var newAlert =''+
            '<div class="alert alert-danger" id="'+ ++alertId +'">' +
            '<a href="#" class="close" data-dismiss="alert">&times;</a>' +
            text +
            '</div>' +
            '';

        $(selector).append(newAlert);

        var alert = $("#" + alertId);
        alert.alert();

        window.setTimeout(function() {
            alert.fadeTo(500, 0).slideUp(500, function(){
                alert.alert('close');
                alert.remove();
            });
        }, delay);

    }

    function connectWebsocketServer() {
        component = $('#component option:selected').val();
        hostname = $('#hostname option:selected').val();
        hostport = $('#hostport option:selected').val();
        serviceLocation = "ws://"+hostname+":"+hostport+"/gui/";

        wsocket = new WebSocket(serviceLocation + component);

        wsocket.onopen = function() {
            //alert("Opened!");

            createAutoClosingInfo(".notification-box", 5000, "Server connection established.");

            setInterval(function(){
                $("#status_blinking").fadeTo(250, 0.1).fadeTo(250, 0.5);
            }, 1000);
};

        wsocket.onmessage = function (evt) {
            //alert("Message: " + evt.data);
            onMessageReceived(evt);
        };

        wsocket.onclose = function(evt) {
            $("#status_blinking").remove();
            createAutoClosingAlert(".notification-box", 10000, "Websocket Connection Closed from Server with code: " + evt.code + ", reason: " + evt.reason + ", wasClean:" + evt.wasClean);

            window.setTimeout(function() {
                leaveComponent();
                }, 5000);
        };

        wsocket.onerror = function(evt) {
            createAutoClosingAlert(".notification-box", 10000, "Websocket Error happend with code: " + evt.code + ", reason: " + evt.reason + ", wasClean:" + evt.wasClean);

            window.setTimeout(function() {
                leaveComponent();
            }, 30000);
        };

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

        processButtons(msg.payload);
    }

    function getJsId(id){
        id = id.replace("_$", "-");
        id = id.replaceAll("\\.","_");

        return id;
    }

    function getJavaPayload(payload){
        payload = payload.replace("-", "_$");
        payload = "OML_" + payload;

        return payload;
    }

    function processButtons(payload){

        var parts = payload.split(';');

        var topic = parts[7].replace("#","");
        var id = parts[0];
        var parameter = parts[6];

        if(!hasRemoteButton(id)){
            addRemoteButtonNav(payload);
            addRemoteButtonPan(payload);
            addRemoteButton(topic, id, parameter, payload);
            addRemoteButtonEvent(id, payload);
        }else{
            //createAutoClosingInfo(".notification-box", 20000, payload);
            changeRemoteButton(id, parameter);
        }
    }

    function addRemoteButtonNav(payload){

        var jsId = getRemoteButtonPanId(payload);

        if($("#" + jsId).length <= 0) {
            var tab = '' +
                '<li role="presentation">' +
                    '<a href="#' + jsId +
                        '" aria-controls="' + jsId +
                        '" role="tab" data-toggle="tab">' +
                        getKeyGroup(payload) +
                    '</a>' +
                '</li>';

            $('#'+jsId+' a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            })

            $("#remote_button_nav").append(tab);
        }
    }

    function getRemoteButtonPanId(payload){
        var id = "remote_button_pan_"+getJsId(getKeyGroup(payload));
        return id;
    }

    function addRemoteButtonPan(payload){

        var jsId = getRemoteButtonPanId(payload);
        var panElement = $("#" + jsId);

        if(panElement.length <= 0){
            var pan = ''+
                '<div role="tabpanel" class="tab-pane btn-group fade" id=\"'+ jsId +'\">' +
                '</div>';

            $("#remote_button_pan").append(pan);
        }
    }

    function addRemoteButton(topic, id, parameter, payload){

        var parts = payload.split(';');
        var jsId = getJsId(id);
        var panElement = $("#" + getRemoteButtonPanId(payload));

        var button =
            $('' +
                    '<div class=\"btn btn-default '+getIsActiveClass(parameter)+'\" id=\"button_'+ jsId + '\" aria-pressed=\"'+getIsAriaPressedAttr(parameter)+'\">' +
                    '<span style="cursor: pointer;">'+ id +'</span>' +
                    '</div>'
            );

        panElement.append(button);
    }

    function addRemoteButtonEvent(id, payload){

        $("#button_" + getJsId(id)).on( "click", function( event ) {

            var changedPayload = "";

            if($(this).hasClass("active")){
                changedPayload = payload.replace(";on;", ";off;");
                //alert("change to OFF, payload: " + changedPayload);
                deactivateButton($(this));
                sendMessage(changedPayload);
            }else{
                changedPayload = payload.replace(";off;", ";on;");
                //alert("change to ON, payload: " + changedPayload);
                activateButton($(this));
                sendMessage(changedPayload);
            }

        });
    }

    function getKeyGroup(payload){

        var payloadArray = payload.split(';');
        var keyGroup = payloadArray[0];

        if(keyGroup.length >= 1){
            var keyGroupArray = keyGroup.split('_$');
            keyGroup = keyGroupArray[0].replace("OML_", "");
        }

        return keyGroup;
    }

    //check object exists
    function hasRemoteButton(id){
        return ($("#button_"+ getJsId(id)).length > 0);
    }

    function changeRemoteButton(id, parameter){

        var button = $("#button_"+ getJsId(id));

        if(parameter == "on") {
            if (!button.hasClass("active")) {
                activateButton(button)
            }
        } else if(parameter == "off") {
            if (button.hasClass("active")) {
                deactivateButton(button)
            }
        } else{
            //button.attr('src','img/remote_null.png');
        }
    }

    function activateButton(button){
        button.addClass("btn-success in active");
        button.attr('aria-pressed', 'true');
    }

    function deactivateButton(button){
        button.removeClass("btn-success in active");
        button.attr('aria-pressed', 'false');
    }

    function getStateParameter(parameter){
        var state = "";
        if (parameter.toLowerCase().indexOf("on") >= 0){
            state = "on";
        }
        else if (parameter.toLowerCase().indexOf("off") >= 0){
            state = "off";
        }
        else {
            state = "null";
        }

        return state;
    }

    function getIsActiveClass(parameter){
        var state = getStateParameter(parameter);
        var isActive = "";
        if(state == "on"){
            isActive = "btn-success active";
        }

        return isActive;
    }

    function getIsAriaPressedAttr(parameter){
        var state = getStateParameter(parameter);
        var isActive = "false";
        if(state == "on"){
            isActive = "true";
        }

        return isActive;
    }

    function sendMessage(payload) {

        var parts = payload.split(';');
        var topicManagement = "management";

        //change message topic to management
        payload = parts[0]+";"+parts[1]+";"+parts[2]+";"+parts[3]+";"+parts[4]+";"+parts[5]+";"+parts[6]+";"+topicManagement+"#";

        var msg =
            '{'+
            '"payload":"' + payload + '", ' +
            '"topic":"' + topicManagement + '"' +
            '}';

        //alert("send message with topic:" + topicManagement + ", payload: " +payload);

        wsocket.send(msg);
        $message.val('').focus();
    }

    function leaveComponent() {
        $('.status').text('Connection not Established');
        $('.log-wrapper').hide();
        $('.gui-wrapper').hide();
        $('.init-wrapper').hide();
        $('#signin-wrapper').show();
        $('.communication-wrapper').hide();
        $('.control-wrapper').hide();
        $('.status-wrapper').hide();
        $('#remote-wrapper').hide();
        $('#status_text').empty();

        wsocket.close();
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
        $('#signin-wrapper').hide();
        $('.init-wrapper').hide();
        $('.control-wrapper').show();
        $('.log-wrapper').hide();
        $('.gui-wrapper').hide();
        $('.communication-wrapper').hide();
        $('#remote-wrapper').hide();
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
        $('#remote-wrapper').toggle();
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
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;start;management;#")
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
            $('#w1_image').attr('src','img/iltis_arrowright-green.png');
        }
    });

});


