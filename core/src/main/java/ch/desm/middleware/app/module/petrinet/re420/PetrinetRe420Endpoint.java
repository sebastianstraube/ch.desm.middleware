package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.common.Pair;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PetrinetRe420Endpoint extends EndpointCommon {

    private static Logger LOGGER = Logger.getLogger(PetrinetRe420Endpoint.class);

    private PetrinetRe420Service service;
    private PetrinetRe420EndpointExportThread petriNetThread;

    public PetrinetRe420Endpoint(PetrinetRe420Service service){
        super();
        this.registerEndpointListener();

        this.service = service;
        petriNetThread = new PetrinetRe420EndpointExportThread("OMLPetriNetSimulationThread", service);
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
                message = message.replace(MessageBase.MESSAGE_PARAMETER_DELIMITER, parameter);
                service.getProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageBase.MESSAGE_TOPIC_PETRINET_OBERMATT);
            }else{
                LOGGER.log(Level.WARN, "component map lookup failed with message: " + jsonMessage);
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
