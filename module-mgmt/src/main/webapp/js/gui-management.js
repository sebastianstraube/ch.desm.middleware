

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

        var newAlert = '' +
            '<div class="alert alert-info alert-message" id="' + ++alertId + '">' +
            '<a href="#" class="close" data-dismiss="alert">&times;</a>' +
            text +
            '</div>' +
            '';

        $(selector).append(newAlert);

        var alertObj = $("#" + alertId);
        alertObj.alert();

        window.setTimeout(function () {
            alertObj.fadeTo(500, 0).slideUp(500, function () {
                alertObj.alert('close');
                alertObj.remove();
            });
        }, delay);
    }

    function buttonHighLight(button){
        button.toggleClass("btn-success");

        var timer = window.setTimeout(function () {
            button.toggleClass("btn-success");
        }, 1000);

        timer = null;
    }

    function createAutoClosingAlert(selector, delay, text) {

        var newAlert =''+
            '<div class="alert alert-danger alert-message" id="'+ ++alertId +'">' +
            '<a href="#" class="close" data-dismiss="alert">&times;</a>' +
            text +
            '</div>' +
            '';

        $(selector).append(newAlert);

        var alertObj = $("#" + alertId);
        alertObj.alert();

        window.setTimeout(function() {
            alertObj.fadeTo(500, 0).slideUp(500, function(){
                alertObj.alert('close');
                alertObj.remove();
            });
        }, delay);

    }

    function connectWebsocketServer() {
        component = $('#component option:selected').val();
        hostname = $('#hostname option:selected').val();
        hostport = $('#hostport option:selected').val();
        serviceLocation = "ws://"+hostname+":"+hostport+"/websocket";

        wsocket = new WebSocket(serviceLocation + "/"+component);

        wsocket.onopen = function() {
            createAutoClosingInfo(".notification-box", 5000, "Server connection established.");

            setInterval(function(){
                $("#status_blinking").fadeTo(250, 0.1).fadeTo(250, 0.5);
            }, 1000);
};

        wsocket.onmessage = function (evt) {
            //createAutoClosingAlert(".notification-box", 10000, "Message: " + evt.data);

            onMessageReceived(evt);
        };

        wsocket.onclose = function(evt) {
            $("#status_blinking").remove();
            createAutoClosingAlert(".notification-box", 10000, "Websocket Connection Closed from Server with code: " + evt.code + ", reason: " + evt.reason + ", wasClean:" + evt.wasClean);

            window.setTimeout(function() {
                leaveComponent();
                }, 60000);
        };

        wsocket.onerror = function(evt) {
            createAutoClosingAlert(".notification-box", 10000, "Websocket Error happend with code: " + evt.code + ", reason: " + evt.reason + ", wasClean:" + evt.wasClean);

            window.setTimeout(function() {
                leaveComponent();
            }, 60000);
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

        if(msg.payload.length >= 0){
            processButtons(msg.payload);
        } else{
            createAutoClosingAlert(".notification-box", 5000, "payload is empty: " + msg.payload);
        }

    }

    function getJsId(id){
        id = id.replace("_$", "-");
        id = id.replaceAll("\\.","_");

        return id;
    }

    function processButtons(payload){

        var parts = payload.split(';');

        var topic = parts[6].replace("#","");
        var id = parts[0];
        var parameter = parts[8];

        id = checkButtonGroup(topic, id);

        if(!hasRemoteButton(id)){
            addRemoteTab(topic);
            addRemoteTabPanel(topic);

            addRemoteAccordionGroup(topic, id);
            addRemoteAccordionPanel(topic, id);
            addRemoteAccordionHeading(topic, id);

            addRemoteButton(topic, id, parameter);
            addRemoteButtonEvent(id, payload);
        }else{
            //createAutoClosingInfo(".notification-box", 20000, payload);
            changeRemoteButton(id, parameter);
        }

        checkEndpointControleTakenBy("petrinet_obermatt", topic, id);
    }

    function getButtonName(id){
        var buttonId = getButton(id);
        var buttonNameArray = buttonId.split('-');
        var buttonName = buttonNameArray[0];
        if(buttonNameArray.length > 1){
            buttonName = buttonNameArray[1];
        }

        return buttonName;
    }

    function getKeyGroupFromId(id){
        id= getJsId(id);
        var array = id.split('-');
        var keyGroup = array[0];

        return keyGroup;
    }

    function checkButtonGroup(topic, id){
        var array = id.split("_$");

        if(array.length <= 1){
            id = topic + "_GROUP_$" + id;
        }

        return id;
    }

    //check object exists
    function hasRemoteButton(id){
        return ($("#"+ getButton(id)).length > 0);
    }

    function getAccordionPanel(topic){
        var id = "arc_panel_" + getJsId(topic);
        return id;
    }

    function getTabPanelHome(){
        var id = "tab_panel_content";
        return id;
    }

    function getTabHome(){
        var id = "tab_panel";
        return id;
    }

    function getAccordionHeading(id){
        var id = "arc_heading_" + getKeyGroupFromId(getJsId(id));
        return id;
    }

    function getAccordionButtonPanel(id){
        var id = "arc_button_panel_" + getKeyGroupFromId(getJsId(id));
        return id;
    }

    function getAccordionButtonGroupTitel(id){
        var id = "abg_titel_" + getKeyGroupFromId(getJsId(id));
        return id;
    }

    function getButton(id){
        var id = "button_"+ getJsId(id);
        return id;
    }

    function getAccordionCollapsePanelId(id){
        var id = "collapse_"+ getKeyGroupFromId(getJsId(id));
        return id;
    }

    function getTab(topic){
        var id = "tab_"+ getJsId(topic);
        return id;
    }

    function getTabPanel(topic){
        var id = "tab_panel_" + topic;
        return id;
    }

    function addRemoteTab(topic){

        var tabHomeId = getTabHome();
        var tabId = getTab(topic);
        var tabPanelId = getTabPanel(topic);

        //add to presentation
        //class="active"
        if($("#"+ tabId).length <= 0 ){
            var tab = '' +
                '<li role="presentation" id=\"'+ tabId + '\" ><a href=\"#'+ tabPanelId + '\" aria-controls=\"'+ tabPanelId + '\" role="tab" data-toggle="tab">' + topic + '</a></li>';

            $("#"+tabHomeId).append(tab);

            $("#"+tabId+" a").click(function (e) {
                e.preventDefault();
                $(this).tab('show');
            })
        }
    }

    function addRemoteTabPanel(topic){

        var tabPanelHomeId = getTabPanelHome();
        var tabPanelId = getTabPanel(topic);

        if($("#"+ tabPanelId).length <= 0 ){
            var tabPanel = '' +
                '<div role="tabpanel" class="tab-pane" id=\"'+ tabPanelId + '\" >' +
                '</div>';

            $("#"+tabPanelHomeId).append(tabPanel);
        }
    }

    function getRemoteAccordionGroup(id){
        var id = "arc_" + getAccordionButtonGroupTitel(id);
        return id;
    }

    function addRemoteAccordionGroup(topic, id){

        var tabPanelId = getTabPanel(topic);
        var accordionGroupId = getRemoteAccordionGroup(id);

        if($("#"+ accordionGroupId).length <= 0 ){
            var accordionPanel = '' +
                '<div class="panel-group" id=\"'+ accordionGroupId + '\" role="tablist" aria-multiselectable="true"></div>';

            $("#"+tabPanelId).append(accordionPanel);
        }
    }


    function addRemoteAccordionPanel(topic, id){

        var accordionGroupId = getRemoteAccordionGroup(id);
        var accordionPanelId = getAccordionPanel(topic);

        if($("#"+ accordionPanelId).length <= 0 ){

            var accordion = '' +
                '<div class="panel panel-default" id=\"'+ accordionPanelId + '\" >' +
                '</div>';

            $("#"+accordionGroupId).append(accordion);
        }
    }

    function addRemoteAccordionHeading(topic, id){

        var accordionPanelId = getAccordionPanel(topic);
        var accordionGroupId = getRemoteAccordionGroup(id);

        var headingId = getAccordionHeading(id);
        var buttonPanelId = getAccordionButtonPanel(id);
        var collapsePanelId = getAccordionCollapsePanelId(id);

        if($("#"+ headingId).length <= 0){
            var heading = '' +
                '<div class="panel-heading" role="tab" id=\"'+ headingId + '\" >' +
                    '<h4 class="panel-title">' +
                        '<a data-toggle="collapse" data-parent=\"#'+ accordionGroupId + '\" href=\"#'+ collapsePanelId + '\" aria-expanded="false" class="collapsed" aria-controls=\"'+ collapsePanelId + '\" >' +
                            getKeyGroupFromId(getJsId(id)) +
                        '</a>' +
                    '</h4>' +
                '</div>' +
                '<div id=\"'+ collapsePanelId + '\" class="panel-collapse collapse" role="tabpanel" aria-labelledby=\"'+ headingId + '\" aria-expanded="false" style="height: 0px;">' +
                    '<div class="panel-body" id=\"'+ buttonPanelId + '\">' +
                        //accordion panel context
                    '</div>' +
                '</div>';

            $("#"+accordionPanelId).append(heading);

        }
    }

    function addRemoteButton(topic, id, parameter){

        var buttonId = getButton(id);
        var buttonName = getButtonName(id);
        var buttonPanelId = getAccordionButtonPanel(id);


        if($("#"+ buttonId).length <= 0){
            var button = '' +
                    '<div class=\"btn btn-default btn-remote-controle '+getIsActiveClass(parameter)+'\" topic=\"'+ topic + '\" id=\"'+ buttonId + '\" aria-pressed=\"'+getIsAriaPressedAttr(parameter)+'\">' +
                        '<span style="cursor: pointer;">'+ buttonName + " ("+parameter+")"+ '</span>' +
                    '</div>';


            $("#" + buttonPanelId).append(button);
        }

    }

    function addRemoteButtonEvent(id, payload){

        $("#"+getButton(id)).on( "click", function( event ) {

            var changedPayload = "";

            if($(this).hasClass("active")){
                changedPayload = payload.replace(";on;", ";off;");
                deactivateButton($(this));
                sendMessage(changedPayload);
            }else{
                changedPayload = payload.replace(";off;", ";on;");
                activateButton($(this));
                sendMessage(changedPayload);
            }

        });
    }

    function checkEndpointControleTakenBy(controleTopic, topic, id){

            var buttonId = getButton(id);

        $('.btn-remote-controle').each(function(){ //do stuff
                var buttonTopic = $( this ).attr('topic');
                if(buttonTopic == controleTopic){
                    $( this).removeAttr("disabled");
                }else{
                    $( this).attr("disabled", "disabled");
                }
            });
    }

    function changeRemoteButton(id, parameter){

        var buttonId = getButton(id);
        var button = $("#" + buttonId);

        if(parameter == "on") {
            if (!button.hasClass("active")) {
                activateButton(button)
            }
        } else if(parameter == "off") {
            if (button.hasClass("active")) {
                deactivateButton(button)
            }
        } else{
            createAutoClosingAlert(".notification-box", 5000, "illegal state with button: " + buttonId + " and parameter: " + parameter );
        }
    }

    function activateButton(button){
        button.addClass("btn-success in active");
        button.attr('aria-pressed', 'true');
        button.text(button.text().replace('off', 'on'));
    }

    function deactivateButton(button){
        button.removeClass("btn-success in active");
        button.attr('aria-pressed', 'false');
        button.text(button.text().replace('on', 'off'));
    }

    function unhighlightButton(button){
        button.removeClass("btn-warning in active");
        button.attr('aria-pressed', 'false');
    }

    function highlightButton(button, alertClass){
        button.removeClass("btn-warning in active");
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
        // TODO: payload = parts[0]+";"+parts[1]+";"+parts[2]+";"+parts[3]+";"+parts[4]+";"+parts[5]+";"+parts[6]+";"+topicManagement+"#";
        payload = parts[0]+";"+parts[1]+";"+parts[2]+";"+parts[3]+";"+parts[4]+";"+parts[5]+";"+topicManagement+";"+parts[7]+";"+parts[8]+"#";

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
        $('#status_text').append(serviceLocation + "/"+component);
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
        buttonHighLight($(this));
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;management;S;init;")
    });

    $('#init_petrinet').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;init;")
    });

    $('#init_petrinet_re420').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.petrinet.re420;os;0;management;petrinet;re420;management;S;init;")
    });

    $('#init_cabine-ubw32').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;management;S;init;")
    });
    
    //start
    $('#start_interlocking').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;management;S;start;")
    });

    $('#start_petrinet').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;start;")
    });

    $('#start_petrinet_re420').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.petrinet.re420;os;0;management;petrinet;re420;management;S;start;")
    });

    $('#start_cabine-ubw32').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;management;S;start;")
    });

    //stop
    $('#stop_interlocking').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;management;S;stop;")
    });

    $('#stop_petrinet').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;management;S;stop;")
    });

    $('#stop_petrinet_re420').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.petrinet.re420;os;0;management;petrinet;re420;management;S;stop;")
    });

    $('#stop_cabine-ubw32').click(function(){
        buttonHighLight($(this));
        sendMessage("mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;management;S;stop;")
    });

    //GUI
    $('#w1_change').on({
        'click': function(){
            $('#w1_image').attr('src','img/iltis_arrowright-green.png');
        }
    });

});


