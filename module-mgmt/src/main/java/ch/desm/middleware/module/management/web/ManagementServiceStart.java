package ch.desm.middleware.module.management.web;

import ch.desm.middleware.common.Utils;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ManagementServiceStart {


    public static void main(String[] args){
        start();

        Utils.waitForAnyKey();
    }

    public static void start(){

        ManagementServer.start();

        ManagementService mgmtService = new ManagementService();
        mgmtService.getEndpoint().init();
        mgmtService.getEndpoint().start();
    }
}
