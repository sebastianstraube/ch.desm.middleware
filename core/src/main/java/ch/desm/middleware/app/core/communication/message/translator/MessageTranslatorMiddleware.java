package ch.desm.middleware.app.core.communication.message.translator;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Analog;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterSingle;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * TODO implementation
 * 
 * @author Sebastian
 *
 */
public class MessageTranslatorMiddleware extends MessageTranslatorMiddlewareBase {

	private static Logger LOGGER = Logger.getLogger(MessageTranslatorMiddleware.class);

	/**
	 *
	 * @param stream
	 * 
	 */
	public List<MessageMiddleware> toMiddlewareMessageList(String stream){
		return decodeMiddlewareMessages(stream);
	}

    /**
     *
     * @param stream
     *
     */
    public MessageMiddleware toMiddlewareMessage(String stream){
        return decodeMiddlewareMessage(stream);
    }

	/**
	 * 
	 * @param commonMessage
	 * 
	 */
	public String toMiddlewareMessage(MessageMiddleware commonMessage){
		return encodeMiddlewareMessage(commonMessage);
	}

	/**
	 * 
	 * @param payload
	 * @param topic
	 * @return
	 */
	public MessageUbw32Base decodeUbw32EndpointMessage(String payload, String topic){
		MessageUbw32Base messageUbw32Base = null;
		
//		VUBW32 Version 1.6.3
		if(payload.startsWith("V")){
			//nothing to do
		}
		
		//IA,3,0,1IA,177,179
		else if(payload.startsWith("IA")){			
			messageUbw32Base = new MessageUbw32Analog(payload, topic);
		}
		
//		PI,F,5PI,0
//		PI,A,2PI,0
		else if(payload.startsWith("PI")){			
			messageUbw32Base = new MessageUbw32DigitalRegisterSingle(payload, topic);
		}
		
//		PO, C, 3, 1
		else if(payload.startsWith("PO")){
			//nothing to do
		}
		
//		C,17943,65339,16,49152,768,12596,960
		else if (payload.startsWith("C")) {
			//nothing to do
		}
		
		else if (payload.startsWith("I")) {
			messageUbw32Base = new MessageUbw32DigitalRegisterComplete(payload, topic);
		}
		
		return messageUbw32Base;
	}
	
}
