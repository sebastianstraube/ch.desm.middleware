package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolMessage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMessageProcessor extends ComponentMessageProcessor {

    private static Logger LOGGER = Logger.getLogger(ZusiMessageProcessor.class);

    /**
     * @param messages
     */
    public void processBrokerMessage(ZusiService service, LinkedList<MessageMiddleware> messages) {
        for(MessageMiddleware message : messages){
            processBrokerMessage(service, message);
        }
    }

    private void delegateToEndpoint(ZusiFahrpultEndpointTcpClient endpoint, String message){
        LOGGER.log(Level.INFO, "processing endpoint message: " + message);

        try {
            endpoint.send(message);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public boolean isInitProcessMessage(MessageMiddleware element){
        /*
        if (element.getGlobalId().equalsIgnoreCase("mgmt.stellwerk.obermattlangnau")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.petrinet.obermatlangnau")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.fabisch")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.cabine.re420.ubw32")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.simulation.locsim.rs232")) {
            return true;
        }else if (element.getGlobalId().equalsIgnoreCase("mgmt.simulation.locsim.dll")) {
            return true;
        }
        */
        return false;
    }

    private void processInitEndpoint(ZusiFahrpultEndpointTcpClient endpoint, MessageMiddleware element){

        switch (element.getParameter()) {
            case ("init"): {
                endpoint.init();
                break;
            }
            case ("start"): {
                endpoint.start();
                break;
            }
            case ("stop"): {
                endpoint.stop();
                break;
            }
        }
    }

    private void processBrokerMessage(ZusiService service, MessageMiddleware message){

        switch(message.getTopic()){
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_CABINE_RE420_FABISCH):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_MANAGEMENT):{
                processManagament(service, message);
            };
            case(MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232):{
                //TODO implementation
            };
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI):{
                processZusi(service, message);
            };

            standard:{
                try {
                    throw new Exception("unsupported topic, broker message delegation skipped: " + message.toString());
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, e);
                }
            };
        }

    }

    /**
     *
     * @param service
     * @param message = 0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#
     */
    private void processZusi(ZusiService service, MessageMiddleware message){
        if(message.getParameter().equalsIgnoreCase("on")){
            ZusiProtocolMessage z = new ZusiProtocolMessage(message.getGlobalId());

            //Input command
            if(service.getProtocolCommand().isCommandInput(z)){

            }
        }
    }



    private void processManagament(ZusiService service, MessageMiddleware message){
        //TODO implementation
    }
}
