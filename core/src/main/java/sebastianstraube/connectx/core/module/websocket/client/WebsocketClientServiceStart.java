package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.common.Utils;
import sebastianstraube.connectx.core.module.server.ServerConfig;

/**
 * Created by Sebastian on 08.05.2016.
 */
public class WebsocketClientServiceStart {


    public static void main(String[] args){
        ServerConfig config = ServerConfig.readConfigFile(args[0]);
        start(config);
        Utils.waitForAnyKey();
    }

    public static void start(ServerConfig config){
        WebsocketClientService mgmtService = new WebsocketClientService(config);
        mgmtService.getEndpoint().init();
        mgmtService.getEndpoint().start();
    }
}
