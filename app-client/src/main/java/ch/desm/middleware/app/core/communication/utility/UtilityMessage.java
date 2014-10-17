package ch.desm.middleware.app.core.communication.utility;

import ch.desm.middleware.app.core.communication.message.MessageCommon;

public class UtilityMessage {

	public String replaceMessageParameter(String stream, String replaceChar){
	
		return stream.replaceAll(MessageCommon.PARAMETER_PLACEHOLDER, replaceChar);
	}
		
}
