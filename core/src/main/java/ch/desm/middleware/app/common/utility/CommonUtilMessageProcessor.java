package ch.desm.middleware.app.common.utility;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;

public class CommonUtilMessageProcessor {

	private static Logger LOGGER = Logger.getLogger(CommonUtilMessageProcessor.class);
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String getParameterValueLocsim(String value) {
		String returnValue = "";

		if (value
				.equals(MessageUbw32DigitalRegisterComplete.MESSAGE_PARAMETER_OFF)) {
			returnValue = "0000";
		} else if (value
				.equals(MessageUbw32DigitalRegisterComplete.MESSAGE_PARAMETER_ON)) {
			returnValue = "0001";
		} else {
			returnValue = value;
			if (returnValue.length() < 4) {
				while (returnValue.length() < 4) {
					returnValue = "0" + returnValue;
				}
			}
		}
		return returnValue.toUpperCase();
	}

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
	

	public static String conversionFahrschalter(String parameter) {
		double x = Double.valueOf(parameter);
		x = (x - 180) / 100;
		// (x^2)/8

		double locsimValue = Math.sqrt(Math.pow(x, 3)); // ((Math.pow(x, 3)) /
														// 100);
		locsimValue *= 100;
		if (locsimValue < 0) {
			locsimValue = 0;
		} else if (locsimValue > 255) {
			locsimValue = 255;
		}

		String locsimParameter = Integer.toHexString((int) locsimValue);

		while (locsimParameter.length() < 4) {
			locsimParameter = locsimParameter + "0";
		}

		LOGGER.log(Level.TRACE, "x: " + x + ", locsimValue: " + locsimValue
                + ", locsimParameter: " + locsimParameter);

		return locsimParameter;
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

	public static boolean listContains(String[] list, String el){
		boolean contains = false;
		for(int i=0; i<list.length; i++){
			if(list[i].equalsIgnoreCase(el)){
				contains = true;
				break;
			}
		}
		return contains;
	}

	public static boolean listEquals(String[] list1, String[] list2){
		boolean equ = true;
		for(int i=0; i<list1.length; i++){
			if(!list1[i].equalsIgnoreCase(list2[i])){
				equ = false;
				break;
			}
		}
		return equ;
	}


}
