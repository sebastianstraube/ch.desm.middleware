package ch.desm.middleware.module.automation.machine;

import ch.desm.middleware.core.component.ComponentMapBase;
import ch.desm.middleware.core.component.ComponentServiceBase;
import ch.desm.middleware.core.communication.broker.Broker;
import ch.desm.middleware.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.core.communication.message.translator.MessageTranslatorMiddleware;
import ch.desm.middleware.module.automation.machine.MachineMapMiddleware;
import ch.desm.middleware.module.automation.machine.map.MachineMapPetrinetCabineRe420;
import ch.desm.middleware.module.automation.machine.map.MachineMapUbw32Analog;
import ch.desm.middleware.module.automation.machine.map.MachineMapUbw32Digital;
import ch.desm.middleware.module.automation.machine.map.MachineMapZusiFahrpult;


/**
 * Created by Sebastian on 11.04.2015.
 */
public class MachineService extends ComponentServiceBase {

    private MachineBrokerClient client;
    private MessageTranslatorMiddleware translator;
    private MachineEndpointUbw32 endpointUbw;
    private MachineMessageProcessor processor;
    private MachineMapZusiFahrpult mapZusi;

    private ComponentMessageProcessorBase componentEndpointUbw32MessageProcessor = new MachineMessageProcessor();
    private final MachineMapPetrinetCabineRe420 machineMapPetrinetCabineRe420 = new MachineMapPetrinetCabineRe420();
    private final MachineMapUbw32Digital machineMapUbw32Digital = new MachineMapUbw32Digital();
    private final MachineMapUbw32Analog machineMapUbw32Analog = new MachineMapUbw32Analog();
    private final MachineMapMiddleware componentMapMiddleware = new MachineMapMiddleware();

    /**
     *
     * @param broker
     */
    public MachineService(Broker broker, String port){
        this.client = new MachineBrokerClient(broker, this);
        this.endpointUbw = new MachineEndpointUbw32(this, port);
        this.translator = new MessageTranslatorMiddleware();
        this.processor = new MachineMessageProcessor();
        this.mapZusi = new MachineMapZusiFahrpult();
    }

    public MachineEndpointUbw32 getEndpoint(){
        return endpointUbw;
    }

    @Override
    public ComponentMapBase getComponentMapMiddleware() {
        return componentMapMiddleware;
    }

    public MessageTranslatorMiddleware getTranslator(){
        return translator;
    }

    @Override
    public MachineMessageProcessor getMessageProcessor(){
        return processor;
    }

    public MachineBrokerClient getBrokerClient(){
        return client;
    }

    public MachineMapZusiFahrpult getMapZusi(){
        return mapZusi;
    }

    public MachineMapPetrinetCabineRe420 getMapPetrinetRe420(){
        return machineMapPetrinetCabineRe420;
    }

    public ComponentMessageProcessorBase getEndpointMessageProcessor(){
        return componentEndpointUbw32MessageProcessor;
    }

    public MachineMapUbw32Digital getMapDigital(){
        return machineMapUbw32Digital;
    }

    public MachineMapUbw32Analog getMapAnalog(){
        return machineMapUbw32Analog;
    }
}
