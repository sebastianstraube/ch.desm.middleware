package ch.desm.middleware.module.management;

import ch.desm.middleware.common.Utils;
import ch.desm.middleware.core.server.ServerService;
import ch.desm.middleware.core.server.ServerConfig;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class ManagementServiceStart {


    public static void main(String[] args){

        ServerService server = new ServerService();
        server.startTyrus();
        server.startJetty();

        ManagementService mgmtService = new ManagementService();
        mgmtService.getEndpoint().init();
        mgmtService.getEndpoint().start();

        Utils.waitForAnyKey();
    }
}
