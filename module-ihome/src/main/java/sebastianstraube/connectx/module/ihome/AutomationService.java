package sebastianstraube.connectx.module.ihome;

import sebastianstraube.connectx.core.component.ComponentMapBase;
import sebastianstraube.connectx.core.component.ComponentServiceBase;
import sebastianstraube.connectx.core.component.ComponentMessageProcessorBase;
import sebastianstraube.connectx.core.communication.message.translator.MessageTranslatorMiddleware;
import sebastianstraube.connectx.module.ihome.map.AutomationMapAll;
import sebastianstraube.connectx.module.ihome.map.AutomationMapMiddleware;
import sebastianstraube.connectx.module.ihome.map.AutomationMapUbw32Analog;
import sebastianstraube.connectx.module.ihome.map.AutomationMapUbw32Digital;

/**
 * Created by Sebastian on 11.04.2015.
 */
public class AutomationService extends ComponentServiceBase {

    private AutomationBrokerClient client;
    private MessageTranslatorMiddleware translator;
    private AutomationEndpointUbw32 endpointUbw;
    private AutomationMessageProcessor processor;

    private ComponentMessageProcessorBase componentEndpointUbw32MessageProcessor = new AutomationMessageProcessor();
    private final AutomationMapUbw32Digital automationMapUbw32Digital = new AutomationMapUbw32Digital();
    private final AutomationMapUbw32Analog automationMapUbw32Analog = new AutomationMapUbw32Analog();
    private final AutomationMapAll automationMapAll = new AutomationMapAll();


    private final AutomationMapMiddleware automationMapMiddleware = new AutomationMapMiddleware();

    public AutomationService(String port){
        this.client = new AutomationBrokerClient(this);
        this.endpointUbw = new AutomationEndpointUbw32(this, port);
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new AutomationMessageProcessor();
    }

    public AutomationEndpointUbw32 getEndpoint(){
        return endpointUbw;
    }

    @Override
    public ComponentMapBase getComponentMapMiddleware() {
        return null;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    @Override
    public AutomationMessageProcessor getMessageProcessor(){
        return processor;
    }

    public AutomationBrokerClient getBrokerClient(){
        return client;
    }

    public ComponentMessageProcessorBase getEndpointMessageProcessor(){
        return componentEndpointUbw32MessageProcessor;
    }

    public AutomationMapUbw32Digital getMapDigital(){
        return automationMapUbw32Digital;
    }

    public AutomationMapUbw32Analog getMapAnalog(){
        return automationMapUbw32Analog;
    }

    public AutomationMapAll getMapAll(){
        return automationMapAll;
    }

    public AutomationMapMiddleware getAutomationMapMiddleware() {
        return automationMapMiddleware;
    }

}
