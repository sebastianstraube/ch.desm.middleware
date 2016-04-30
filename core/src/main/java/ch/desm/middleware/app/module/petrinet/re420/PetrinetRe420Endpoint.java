package ch.desm.middleware.app.module.petrinet.re420;

import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.component.petrinet.Bucket;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PetrinetRe420Endpoint extends EndpointCommon<Bucket> {

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
    public void onIncomingEndpointMessage(Bucket bucket){
        try {
            String message = service.getComponentMapMiddleware().getValueForKey(bucket.getName());
            if(!message.isEmpty()){
                final String parameter = MessageCommon.mapBoolToOnOffParameter(bucket.getTokenCount() > 0);
                message = message.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                service.getProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT);
            }else{
                LOGGER.log(Level.WARN, "component map lookup failed with message: " + bucket);
            }
        } catch (ClassCastException e) {
            LOGGER.log(Level.ERROR, "Error on message: " + bucket + "with: " + e);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void setSensor(String message, int value) {
    	petriNetThread.setSensor(message, value);
    }
    
}
