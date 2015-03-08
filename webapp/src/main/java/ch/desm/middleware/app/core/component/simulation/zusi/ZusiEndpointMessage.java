package ch.desm.middleware.app.core.component.simulation.zusi;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiEndpointMessage{

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private String message;
    private ZusiService service;

    public ZusiEndpointMessage(ZusiService service) {
        this.service = service;
        this.message = "";
    }

    public ZusiEndpointMessage(ZusiService service, String message) {
        this.service = service;
        this.message = message;
    }

    public void addMessage(String message){
        this.message += message;
    }

    public boolean isTransferComplete(){
        return service.getMessageService().isMessageComplete(message);
    }

    public String getMessage(){
        return message;
    }

}
