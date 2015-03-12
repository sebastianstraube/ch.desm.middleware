package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.common.Pair;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.ComponentMessageProcessor;
import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClient;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolCommandFrom;
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
                processBrokerMessageManagament(service, message);
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
            case(MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT):{
                processBrokerMessageZusi(service, message);
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
    private void processBrokerMessageZusi(ZusiService service, MessageMiddleware message){
        if(message.getParameter().equalsIgnoreCase("on")){
            ZusiProtocolMessage z = new ZusiProtocolMessage(message.getGlobalId());

            String zusiStream = "";
            //Input command
            if(service.getProtocolCommandTo().isCommandInput(z)){
                try {
                    zusiStream = service.getProtocolCommandTo().getCommandStream(service, message.getGlobalId());
                } catch (Exception e) {
                    LOGGER.log(Level.ERROR, e);
                }
            }

            delegateToEndpoint(service.getEndpointFahrpult(), zusiStream);
        }
    }

    private void processBrokerMessageManagament(ZusiService service, MessageMiddleware message){
        //TODO implementation
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

    public void processEndpointMessage(ZusiService service, String message, String topic){
        try {
            String globalId = service.getProtocolService().getGlobalId(message);
            ZusiProtocolMessage zusiProtocolMessage = new ZusiProtocolMessage(globalId);

            //if parameter message
            if(ZusiProtocolCommandFrom.isCommandInput(zusiProtocolMessage)){

                //send message for every parameter
                for(Pair<String, String> p: zusiProtocolMessage.getParameterList()){
                    String parameterId = zusiProtocolMessage.getGroupId()+"::"+p.getLeft();
                    String middlewareMessage = service.getMapFahrpult().getStartValue(parameterId);
                    middlewareMessage = middlewareMessage.replace("?", p.getRight());
                    //send middleware message to broker clients
                    super.processEndpointMessage(service.getBrokerClientFahrpult(), middlewareMessage, topic);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
