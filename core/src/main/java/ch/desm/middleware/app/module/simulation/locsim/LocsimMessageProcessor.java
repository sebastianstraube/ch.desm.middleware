package ch.desm.middleware.app.module.simulation.locsim;

import ch.desm.middleware.app.common.utility.UtilityMessageProcessor;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageUbw32DigitalRegisterComplete;
import ch.desm.middleware.app.core.component.ComponentMessageProcessorBase;
import ch.desm.middleware.app.module.simulation.locsim.logic.LocsimLogicFahrschalter;
import ch.desm.middleware.app.module.simulation.locsim.maps.LocsimMapRs232;
import ch.desm.middleware.app.module.simulation.locsim.message.LocsimMessageDll;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian on 29.10.2014.
 */
public class LocsimMessageProcessor extends ComponentMessageProcessorBase<Locsim> {

    private static Logger LOGGER = Logger.getLogger(LocsimMessageProcessor.class);
    private LocsimLogicFahrschalter fahrschalter;

    public LocsimMessageProcessor(){
        fahrschalter = new LocsimLogicFahrschalter();
    }
    /**
     *
     * @param impl
     * @param messages
     */
    public void processBrokerMessage(Locsim impl, LinkedList<MessageMiddleware> messages) {

        for (MessageMiddleware message : messages) {
            this.processBrokerMessage(impl, message);
        }
    }

    /**
     * @param impl
     * @param message
     */
    protected void processBrokerMessage(Locsim impl, MessageMiddleware message) {

        if (impl.isLocsimDllMessage(message.getGlobalId())) {

            // TODO implementation of dll messages
            // ....
        }

        else if (UtilityMessageProcessor.isSoftwareMessage(message.getOutputInput())) {

            // send locsim interface ready to start simulation
            if (message.getGlobalId().equalsIgnoreCase(
                    "locsim.initialization.ready.ini1")) {
                // init message
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "locsim.initialization.ready.ini2")) {
                impl.getEndpointRs232().sendMessage("INI2");
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "mgmt.simulation.locsim.rs232")) {

                switch (message.getParameter()) {
                    case ("init"): {
                        impl.getEndpointRs232().init();
                        break;
                    }
                    case ("start"): {

                        break;
                    }
                    case ("stop"): {
                        impl.getEndpointRs232().closePort();
                        break;
                    }
                }
            }

            else if (message.getGlobalId().equalsIgnoreCase(
                    "mgmt.simulation.locsim.dll")) {

                switch (message.getParameter()) {
                    case ("init"): {
                        impl.getEndpointDll().init();
                        break;
                    }
                    case ("start"): {
                        impl.getEndpointDll().start();
                        break;
                    }
                    case ("stop"): {
                        impl.getEndpointDll().stop();
                        break;
                    }
                }
            }

        }

        else {

            // delegate needed fahrschalter messages
            if (fahrschalter.getMap().containsValue(message.getGlobalId())) {

                // find locsim needed keys
                HashMap<String, String> fahrschalterKeys = fahrschalter
                        .getLocsimNeededKeys(message.getGlobalId());

                if (!fahrschalterKeys.isEmpty()) {

                    for (Map.Entry<String, String> element : fahrschalterKeys
                            .entrySet()) {

                        String channelData = element.getKey();
                        if (channelData.isEmpty()) {
                            LOGGER.log(Level.WARN, "no locsim mapping with message: "
                                    + message);
                        }
                        String channelType = channelData.substring(0, 1);
                        String channel = channelData.substring(1, 3);
                        String parameter = "0000";
                        String locsimCommand = "X" + channelType + channel
                                + parameter + "Y";

                        impl.getEndpointRs232().sendMessage(locsimCommand);
                    }
                }

                String channelData = fahrschalter.getKey(message.getGlobalId());
                if (channelData.isEmpty()) {
                    LOGGER.log(Level.WARN, "no locsim mapping with message: " + message);
                }
                String channelType = channelData.substring(0, 1);
                String channel = channelData.substring(1, 3);
                String parameter = getParameterValueLocsim(message
                        .getParameter());
                String locsimCommand = "X" + channelType + channel + parameter
                        + "Y";

                impl.getEndpointRs232().sendMessage(locsimCommand);

                // no fahrschalter command
            } else {

                LocsimMapRs232 locsimMap = new LocsimMapRs232();
                String channelData = locsimMap.getKey(message.getGlobalId());

                if (channelData.isEmpty()) {
                    try {
                        throw new Exception("processBrokerMessage: " + message
                                + ", has no mapping");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        LOGGER.log(Level.ERROR, e);
                    }
                } else {

                    String parameter = message.getParameter();
                    String channelType = channelData.substring(0, 1);
                    String channel = channelData.substring(1, 3);

                    // conversion Hauptleitung, Bremszylinder pressure
                    if (channelData.equals("V00") || channelData.equals("V01")) {

                        parameter = conversionFahrschalter(parameter);

                    } else if (channelData.equals("V02")) {

                        parameter = conversionFahrschalter(parameter);

                    } else if (channelData.equals("V03")) {

                    }

                    else {

                        parameter = getParameterValueLocsim(parameter);
                    }

                    if (channelData.isEmpty()) {
                        LOGGER.log(Level.WARN, "no locsim mapping with message: " + message);
                    }

                    String locsimCommand = "X" + channelType + channel
                            + parameter + "Y";

                    impl.getEndpointRs232().sendMessage(locsimCommand);

                }
            }
        }
    }

    /**
     * processing all incoming rs232 data from locsim
     *
     * @param data
     */
    public void processIncomingDataRs232(Locsim impl, String data) {
        impl.endpointRs232.parser.addData(data);

        String message;
        while ((message = impl.endpointRs232.parser.pop()) != null) {

            LOGGER.log(Level.TRACE,"receive endpoint("+ impl.endpointRs232.getSerialPortName()+") locsim message: " + message);
            if (message.startsWith("INI")) {

                //TODO implementation different states of locsim (INI8)
                if (!impl.initialisiert && message.equalsIgnoreCase("INI1")) {
                    message = "locsim.initialization.ready.ini1;os;0;message;initialisiation;ini1;on;locsim-rs232;#";
                    processEndpointMessage(impl, message,
                            MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
                    impl.initialisiert = true;

                    impl.endpointRs232.sendMessage("INI2");
                }

                else if (message.equalsIgnoreCase("INI7")) {
                    message = "locsim.initialization.ready.ini7;os;0;message;initialisiation;ini7;on;locsim-rs232;#";
                    impl.processor.processEndpointMessage(impl, message,
                            MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
                }

                else{
                    LOGGER.log(Level.WARN, "not implemented or skipped initialisation message: " + message);
                }
            } else {

                message = impl.translatorRs232
                        .translateToCommonMiddlewareMessage(message, MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);

                processEndpointMessage(impl, message,
                        MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232);
            }
        }
    }


    /**
     * TODO implementation
     *
     * @param message
     */
    public void processIncomingDataDll(Locsim impl, String message) {

        LocsimMessageDll messageDll = new LocsimMessageDll(message,
                MessageCommon.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);

        String stream = "";

        if (messageDll.isGleislistMessage()) {
            System.out
                    .println("processEndpointDataDll: not yet supported message: "
                            + message);

        } else if (messageDll.isSignalMessage()) {
            // TODO implementation
            LOGGER.fatal("processEndpointDataDll: not yet supported message: "
                    + message);
        } else if (messageDll.isTrackMessage()) {
            // TODO implementation
            LOGGER.fatal("processEndpointDataDll: not yet supported message: "
                    + message);

        } else if (messageDll.isTrainpositionMessage()) {
            // TODO implementation
            LOGGER.fatal("processEndpointDataDll: not yet supported message: "
                    + message);

        } else if (messageDll.isWeicheMessage()) {
            // TODO implementation
            LOGGER.fatal("processEndpointDataDll: not yet supported message: "
                    + message);

        } else {
            LOGGER.fatal("processEndpointDataDll: not yet supported message: "
                    + message);
        }

        processEndpointMessage(impl, stream,
                MessageBase.MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL);
    }

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
}
