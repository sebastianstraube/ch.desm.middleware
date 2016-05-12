package ch.desm.middleware.module.automation.web;

import ch.desm.middleware.common.Utils;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class AutomationWebServiceStart {


    public static void main(String[] args){
        start();

        Utils.waitForAnyKey();
    }

    public static void start(){
        AutomationWebServer server = new AutomationWebServer();
        server.start();
    }
}
