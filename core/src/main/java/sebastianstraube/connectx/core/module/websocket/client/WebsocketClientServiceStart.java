package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.common.Utils;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class WebsocketClientServiceStart {


    public static void main(String[] args){
        start();

        Utils.waitForAnyKey();
    }

    public static void start(){

        WebsocketClientService mgmtService = new WebsocketClientService();
        mgmtService.getEndpoint().init();
        mgmtService.getEndpoint().start();
    }
}
