package sebastianstraube.connectx.core.module;

import sebastianstraube.connectx.core.module.server.ServerConfig;
import sebastianstraube.connectx.core.module.server.ServerJettyHttpStart;
import sebastianstraube.connectx.core.module.server.ServerTyrusWebsocketStart;
import sebastianstraube.connectx.core.module.websocket.client.WebsocketClientServiceStart;

/**
 * Created by heisenberg on 29/05/16.
 */
public class CoreModuleServiceStart {

    public static void main(String args[]){
        String configPath = args[0];

        CoreModuleServiceStart.start(configPath);
    }

    public static void start(String configPath){
        ServerConfig config = ServerConfig.readConfigFile(configPath);

        ServerJettyHttpStart.start(config);
        ServerTyrusWebsocketStart.start(config);
        WebsocketClientServiceStart.start(config);
    }
}
