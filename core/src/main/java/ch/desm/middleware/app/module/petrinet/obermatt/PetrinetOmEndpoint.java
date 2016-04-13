package ch.desm.middleware.app.module.petrinet.obermatt;

import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.common.Pair;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;

public class PetrinetOmEndpoint extends EndpointCommon {

    private static Logger LOGGER = Logger.getLogger(PetrinetOmEndpoint.class);

    private PetrinetOmService service;
    private PetrinetOmEndpointExportThread petriNetThread;

    public PetrinetOmEndpoint(PetrinetOmService service){
        super();
        this.registerEndpointListener();

        this.service = service;
        petriNetThread = new PetrinetOmEndpointExportThread("OMLPetriNetSimulationThread", service);
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

    /**
     *
     */
    @Override
    public void reset(){

    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
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
                message = message.replace(MessageBase.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                service.getProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT);
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
