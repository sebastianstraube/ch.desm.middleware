package ch.desm.middleware.app.common.utility;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;

public class UtilityMessageProcessor {

	private static Logger LOGGER = Logger.getLogger(UtilityMessageProcessor.class);

    /**
     *
     * @param value
     * @return
     */
    public static String getParameterValueEndpoint(String value) {
        String returnValue = "";

		if (value.equals(MessageUbw32DigitalRegisterComplete.MESSAGE_PARAMETER_OFF)) {
			returnValue = "0";
		} else if (value.equals(MessageUbw32DigitalRegisterComplete.MESSAGE_PARAMETER_ON)) {
			returnValue = "1";
		} else{
			LOGGER.log(Level.TRACE, "unexpected (0,1) parameter value: " + value);
		}

        return returnValue;
    }
	
	public static boolean isSoftwareMessage(String value) {
		return value.equalsIgnoreCase(MessageUbw32Base.MESSAGE_CHAR_ONLYSOFTWARE) == true? true: false;
	}
	


	public static String replaceMiddlewareMessageDelimiter(String middlewareMessage, String parameterValue){
		return middlewareMessage.replace("?", parameterValue);
	}

	public static String[] trimList(String[] list){
		String tmp[] = new String[0];
		for(int i=0; i<list.length; i++){
			if(list[i] != null && !list[i].isEmpty()){
				tmp = addElement(tmp, list[i]);
			}
		}

		return tmp;
	}

	public static String[] addElement(String[] list, String s){
		int length = list.length+1;
		String[] tmp = new String[length];
		for(int i=0; i<list.length; i++) tmp[i] = list[i];
		tmp[tmp.length-1] = s;

		return tmp;
	}

}
