package ch.desm.middleware.modules.component.simulation.locsim.messages;

import ch.desm.middleware.modules.communication.message.translator.MessageTranslatorRs232;
import ch.desm.middleware.modules.communication.message.type.MessageBase;
import ch.desm.middleware.modules.communication.message.type.MessageCommon;
import ch.desm.middleware.modules.communication.message.type.MessageMiddleware;
import ch.desm.middleware.modules.component.simulation.locsim.maps.LocsimMapMiddleware;
import ch.desm.middleware.modules.component.simulation.locsim.maps.LocsimMapMiddlewareParameter;
import ch.desm.middleware.modules.component.simulation.locsim.maps.LocsimMapRs232;

public class LocsimMessageTranslatorRs232 extends MessageTranslatorRs232 {

//	private MessageTranslatorMiddleware translator;
	
	private LocsimMapRs232 mapRs232;
	private LocsimMapMiddleware middlewareMessages;
	private LocsimMapMiddlewareParameter mapParameter;
	
	public LocsimMessageTranslatorRs232(){
//		translator = new MessageTranslatorMiddleware();
		mapRs232 = new LocsimMapRs232();
		middlewareMessages = new LocsimMapMiddleware();
		mapParameter = new LocsimMapMiddlewareParameter();
	}
	
	@Override
	public String translateToCommonMiddlewareMessage(String payload){
		
		LocsimMessageRs232 locsimMessage = new LocsimMessageRs232(payload, MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
		String middlewareKey = mapRs232.getValue(locsimMessage.getSignalType(), locsimMessage.getChannel());
		String commonMessage = middlewareMessages.getValue(middlewareKey);
		
		String dataValue = locsimMessage.getData();
		commonMessage = replaceMiddlewareMessageParameter(MessageCommon.PARAMETER_PLACEHOLDER, mapParameter.getValue(dataValue), commonMessage);
		
//		MessageMiddleware middlewareMessage = translator.translateToCommonMiddlewareMessage(commonMessage);
		
		return commonMessage;
	}
	
	public String translateToCommonLocsimMessage(MessageMiddleware message){
		
		
		
		return null;
	}
}
