
$(document).ready(function() {

      $('#switch_c3_on').click(function(){
            buttonHighLight($(this));
            sendMessage("module.automation_switchc3;os;0;module;automation;switch_c3;management;b;on;")
        });

        $('#switch_c3_off').click(function(){
            buttonHighLight($(this));
            sendMessage("module.automation_switchc3;os;0;module;automation;switch_c3;management;b;off;")
        });

        $('#switch_c2_on').click(function(){
            buttonHighLight($(this));
            sendMessage("module.automation_switchc2;os;0;module;automation;switch_c2;management;b;on;")
        });

        $('#switch_c2_off').click(function(){
            buttonHighLight($(this));
            sendMessage("module.automation_switchc2;os;0;module;automation;switch_c2;management;b;off;")
        });

});


