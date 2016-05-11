package ch.desm.middleware.module.management.web;

import ch.desm.middleware.common.Utils;
import ch.desm.middleware.core.server.ServerService;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class WebServiceStart {


    public static void main(String[] args){
        start();
    }

    public static void start(){
        ServerService server = new ServerService();
        server.startJetty();

        Utils.waitForAnyKey();
    }
}
