package sebastianstraube.connectx.core.module;

import sebastianstraube.connectx.core.module.server.ServerJettyHttpStart;
import sebastianstraube.connectx.core.module.server.ServerTyrusWebsocketStart;
import sebastianstraube.connectx.core.module.websocket.client.WebsocketClientServiceStart;

/**
 * Created by heisenberg on 29/05/16.
 */
public class CoreModuleServiceStart {

    public static void main(String args[]){

        CoreModuleServiceStart.start();

    }

    public static void start(){
        ServerJettyHttpStart.start();
        ServerTyrusWebsocketStart.start();
        WebsocketClientServiceStart.start();
    }
}
