package sebastianstraube.connectx.module.desm.petrinet.obermatt;

import sebastianstraube.connectx.core.communication.message.MessageCommon;
import sebastianstraube.connectx.core.component.petrinet.Bucket;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import sebastianstraube.connectx.core.communication.endpoint.EndpointCommon;

public class PetrinetOmEndpoint extends EndpointCommon<Bucket> {

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
    public void onIncomingEndpointMessage(Bucket bucket){
        try {
            String message = service.getComponentMapMiddleware().getValueForKey(bucket.getName());
            if(!message.isEmpty()){
                final String parameter = MessageCommon.mapBoolToOnOffParameter(bucket.getTokenCount() > 0);
                message = message.replace(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, parameter);
                service.getMessageProcessor().processEndpointMessage(service.getBrokerClient(), message, MessageCommon.MESSAGE_TOPIC_PETRINET_OBERMATT);
            }
        } catch (ClassCastException e) {
            LOGGER.log(Level.ERROR, "Error on message: " + bucket + "with: " + e);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    public void setSensor(String message, boolean value) {
    	petriNetThread.setSensor(message, value);
    }
    
}
