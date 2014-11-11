package ch.desm.middleware.app.core.component.petrinet.obermattlangnau;

import ch.desm.middleware.app.core.communication.endpoint.EndpointBase;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommonListenerInterface;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.utility.Pair;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

public class PetrinetOmlEndpoint extends EndpointCommon {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmlEndpoint.class);

    private PetrinetOmlService service;
    private PetrinetOmlEndpointExportThread petriNetThread;

    public PetrinetOmlEndpoint(PetrinetOmlService service){
        this.service = service;
        petriNetThread = new PetrinetOmlEndpointExportThread("OMLPetriNetSimulationThread", service);
    }

    @Override
    public void init(){
        petriNetThread.init();
    }

    @Override
    public void start(){
        petriNetThread.start();
    }

    @Override
    public void stop(){
        petriNetThread.interrupt();
    }

    @Override
    protected void registerEndpointListener(EndpointBase listener) {
        try {
            listener.addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    @Override
    public void onIncomingEndpointMessage(String jsonMessage){
        try {
            Pair<String, Integer> pair = service.getDecoder().decode(jsonMessage);
            String message = service.getComponentMapMiddleware().getValue(pair.getLeft());
            if(!message.isEmpty()){
                String parameter = pair.getRight() == 0? "off" : "on";
                message = message.replaceAll("\\?", parameter);
                service.getProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU);
            }
        } catch (ClassCastException e) {
            LOGGER.log(Level.ERROR, "Error on message: " + jsonMessage + "with: " + e);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void setSensor(String message, int value) {
    	petriNetThread.setSensor(message, value);
    }
    
}
