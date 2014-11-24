package ch.desm.middleware.app.core.component.simulation.locsim.messages;

import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.translator.MessageTranslatorRs232Base;
import ch.desm.middleware.app.core.component.ComponentMapMiddleware;
import ch.desm.middleware.app.core.component.simulation.locsim.maps.LocsimMapMiddlewareParameter;
import ch.desm.middleware.app.core.component.simulation.locsim.maps.LocsimMapRs232;

public class LocsimMessageTranslatorRs232 extends MessageTranslatorRs232Base {

	private LocsimMapRs232 mapRs232;
	private LocsimMapMiddlewareParameter mapParameter;
    private static final ComponentMapMiddleware mapMiddlewareMessages = new ComponentMapMiddleware();

	public LocsimMessageTranslatorRs232(){
		mapRs232 = new LocsimMapRs232();
		mapParameter = new LocsimMapMiddlewareParameter();
	}
	
	@Override
	public String translateToCommonMiddlewareMessage(String payload, String topic){
		
		LocsimMessageRs232 locsimMessage = new LocsimMessageRs232(payload, topic);
		String middlewareKey = mapRs232.getValue(locsimMessage.getSignalType(), locsimMessage.getChannel());
		String commonMessage = mapMiddlewareMessages.getValue(middlewareKey);
		
		String dataValue = locsimMessage.getData();
		commonMessage = replaceMiddlewareMessageParameter(MessageCommon.MESSAGE_PARAMETER_PLACEHOLDER, mapParameter.getValue(dataValue), commonMessage);

		return commonMessage;
	}
}
