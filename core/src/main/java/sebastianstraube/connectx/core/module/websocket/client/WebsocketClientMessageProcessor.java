package sebastianstraube.connectx.core.module.websocket.client;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorBase;
import sebastianstraube.connectx.core.component.ComponentServiceBase;

import java.util.List;

/**
 * Created by Sebastian on 29.10.2014.
 */
class WebsocketClientMessageProcessor extends ComponentMessageProcessorBase<WebsocketClientService> {

    @Override
    public void processBrokerMessage(WebsocketClientService service, List<MessageCommon> messages) {

    }

    @Override
    protected boolean initEndpoint(WebsocketClientService service, MessageCommon element) {
        return false;
    }

}
