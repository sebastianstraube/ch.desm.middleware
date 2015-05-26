package ch.desm.middleware.app.core.component.interlocking.obermatt;

import ch.desm.middleware.app.core.communication.endpoint.rs232.ubw32.EndpointUbw32;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.communication.message.MessageCommon;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.component.interlocking.obermatt.map.OmMapUbw32Analog;
import ch.desm.middleware.app.core.component.interlocking.obermatt.map.OmMapUbw32Digital;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class OmEndpointUbw32 extends EndpointUbw32 {

    private static Logger LOGGER = Logger.getLogger(OmBrokerClient.class);

	private OmMapUbw32Digital mapDigital;
	private OmMapUbw32Analog mapAnalog;
    private OmService service;

	public OmEndpointUbw32(String port, OmService service) {
		super(port,
				OmMapUbw32Digital.PINBITMASK_CONFIGURATION_DIGITAL,
				OmMapUbw32Analog.PINBITMASK_INPUT_ANALOG);

        this.registerEndpointListener();
        this.service = service;
	    this.mapAnalog = new OmMapUbw32Analog();
	    this.mapDigital = new OmMapUbw32Digital();
    }

    @Override
    protected void registerEndpointListener() {
        try {
            addEndpointListener(this);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }
    }

    /**
     *
     * @param message
     */
    @Override
    public void onIncomingEndpointMessage(String message) {
        LOGGER.log(Level.TRACE, "endpoint (" + getSerialPortName() + ") received message: " + message);

        MessageUbw32Base ubw32Message = service.getTranslator()
                .decodeUbw32EndpointMessage(message,
                        MessageCommon.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);

        //processable message
        if(ubw32Message != null){
            String messages = service.getProcessor().convertToMiddlewareMessage(this, ubw32Message);
            service.getProcessor().processEndpointMessage(service.getBrokerClient(), messages, MessageBase.MESSAGE_TOPIC_INTERLOCKING_OBERMATT);
        }
    }


    public OmMapUbw32Digital getMapDigital(){
        return this.mapDigital;
    }

    public OmMapUbw32Analog getMapAnalog(){
        return this.mapAnalog;
    }

    public void testDigitalMapSetAll(String value){

        for(String element : mapDigital.getMap().values())
        {
            String port = element.substring(0,1);
            String pin = element.substring(1,2);
            this.sendCommandPinOutput(port, pin, value);
        }
    }

}
