package ch.desm.middleware.app.core.component.simulation.zusi;

import ch.desm.middleware.app.core.common.utility.UtilityMessageProcessor;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.component.simulation.zusi.logic.ZusiLogicIsolierung;

/**
 * Created by Sebastian on 22.04.2015.
 */
public class ZusiEndpointLogic {

    /**
     *
     */
    public String getIsolierungFromParameter(ZusiService service, String globalId, String parameterValue){
        String middlewareMessage = "";

        if(globalId.equalsIgnoreCase(ZusiLogicIsolierung.LOGIC_GLOBALID_GESAMTWEG)){
            int parameter = Float.valueOf(parameterValue).intValue();
            String key = service.getZusiLogicIsolierung().getGlobalId(parameter);
            middlewareMessage = service.getComponentMapMiddleware().getValue(key);
            //TODO OFF PARAMETER
            if(!middlewareMessage.isEmpty()) middlewareMessage = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(middlewareMessage, MessageBase.MESSAGE_PARAMETER_ON);
        }

        return middlewareMessage;
    }

    public String getIsolierungTopic(){
        return MessageBase.MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG;
    }

}
