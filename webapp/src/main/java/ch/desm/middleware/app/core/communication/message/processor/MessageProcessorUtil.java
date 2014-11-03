package ch.desm.middleware.app.core.communication.message.processor;

import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.app.core.component.cabine.re420.maps.Re420MapFabischValue;

public class MessageProcessorUtil {

	private static Logger LOGGER = Logger.getLogger(MessageProcessorUtil.class);
	
	public boolean init1;
	private Re420MapFabischValue mapValues;
	
	public MessageProcessorUtil() {
		mapValues = new Re420MapFabischValue();
		init1 = false;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public String getParameterValueLocsim(String value) {
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
    public String getParameterValueMiddleware(String value) {
        String returnValue = "";

        try{
            if (value.equals(MessageUbw32DigitalRegisterComplete.MESSAGE_PARAMETER_OFF)) {
                returnValue = "0";
            } else if (value.equals(MessageUbw32DigitalRegisterComplete.MESSAGE_PARAMETER_ON)) {
                returnValue = "1";
            } else{
                throw new IllegalStateException("wrong parameter value: " + value);
            }
        } catch(IllegalStateException e){
            LOGGER.log(Level.ERROR, e);
        }

        return returnValue;
    }

	/**
	 * 
	 * @param value
	 * @return
	 */
	public String getParameterValueRe420(String value) {
		String returnValue = String.valueOf(Integer.parseInt(value, 16));

		return returnValue.toUpperCase();
	}

	/**
	 * converts the parameter by fabisch channel map and given parameter
	 * 
	 * @param channelKey
	 * @param parameter
	 * @return
	 */
	public String convertParameter(String channelKey, String parameter) {

		if (mapValues.getMap().containsKey(channelKey)) {

			for (Entry<String, String> element : mapValues.getMap().entrySet()) {
				if (element.getKey().equals(channelKey)) {
					// has values
					if (!element.getValue().isEmpty()) {

						// has switch elements
						if (element.getValue().contains("#")) {
							if (parameter.equals("on")) {
								// set off value as new parameter
								parameter = element.getValue().split("#")[0];
							} else if (parameter.equals("off")) {
								// set on value as new parameter
								parameter = element.getValue().split("#")[1];
							}
						}
					}
				}
			}
		}
		return parameter;
	}
	
	public static boolean isSoftwareMessage(String value) {
		return value.equalsIgnoreCase(MessageUbw32Base.MESSAGE_CHAR_ONLYSOFTWARE) == true? true: false;
	}
	

	public String conversionFahrschalter(String parameter) {
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
}
