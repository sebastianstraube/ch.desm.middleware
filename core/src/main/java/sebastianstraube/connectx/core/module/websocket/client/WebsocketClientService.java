package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.component.ComponentMapBase;
import sebastianstraube.connectx.core.module.websocket.client.map.WebsocketClientMapMiddleware;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 08.05.2016.
 */
class WebsocketClientService extends WebsocketClientServiceBase {

    private static Logger LOGGER = Logger.getLogger(WebsocketClientService.class);

    private final ComponentMapBase mapMiddleware = new WebsocketClientMapMiddleware();

    public WebsocketClientService() {
        super();
    }

    @Override
    public ComponentMapBase getComponentMapMiddleware() {
        return mapMiddleware;
    }
}
