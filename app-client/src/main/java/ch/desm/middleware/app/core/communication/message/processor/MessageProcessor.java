package ch.desm.middleware.app.core.communication.message.processor;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.communication.message.MessageUbw32Base;
import ch.desm.middleware.app.core.component.cabine.re420.Re420;
import ch.desm.middleware.app.core.component.interlocking.obermattlangnau.OML;
import ch.desm.middleware.app.core.component.petrinet.obermattlangnau.OMLPetriNet;
import ch.desm.middleware.app.core.component.simulation.locsim.Locsim;
import ch.desm.middleware.app.core.component.simulation.locsim.elements.LocsimElementFahrschalter;
import ch.desm.middleware.app.core.component.simulation.locsim.maps.LocsimMapRs232;

/**
 * 
 * @author Sebastian
 * 
 */
public class MessageProcessor extends MessageProcessorBase {

	private static Logger LOGGER = Logger.getLogger(MessageProcessor.class);

	private LocsimElementFahrschalter fahrschalter;
	private MessageProcessorUtil util;
	
	public MessageProcessor(){
		fahrschalter = new LocsimElementFahrschalter();
		util = new MessageProcessorUtil();
	}
	
	/**
	 * @param impl
	 * @param message
	 */
	protected void processBrokerMessage(OMLPetriNet impl,
			MessageMiddleware message) {
		
		impl.processBrokerMessage(message);
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

		else if (MessageProcessorUtil.isSoftwareMessage(message.getOutputInput())) {

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
						impl.getEndpointRs232().initialize();
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
						impl.getEndpointDll().initialize();
						break;
					}
					case ("start"): {
						impl.getEndpointDll().run();
						break;
					}
					case ("stop"): {
						impl.getEndpointDll().interrupt();
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

					for (Entry<String, String> element : fahrschalterKeys
							.entrySet()) {

						String channelData = element.getKey();
						if (channelData.isEmpty()) {
							LOGGER.warn("no locsim mapping with message: "
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
					LOGGER.warn("no locsim mapping with message: " + message);
				}
				String channelType = channelData.substring(0, 1);
				String channel = channelData.substring(1, 3);
				String parameter = util.getParameterValueLocsim(message
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
						LOGGER.error(e);
					}
				} else {

					String parameter = message.getParameter();
					String channelType = channelData.substring(0, 1);
					String channel = channelData.substring(1, 3);

					// conversion Hauptleitung, Bremszylinder pressure
					if (channelData.equals("V00") || channelData.equals("V01")) {

						parameter = util.conversionFahrschalter(parameter);

					} else if (channelData.equals("V02")) {

						parameter = util.conversionFahrschalter(parameter);

					} else if (channelData.equals("V03")) {

					}

					else {

						parameter = util.getParameterValueLocsim(parameter);
					}

					if (channelData.isEmpty()) {
						LOGGER.warn("no locsim mapping with message: " + message);
					}

					String locsimCommand = "X" + channelType + channel
							+ parameter + "Y";

					impl.getEndpointRs232().sendMessage(locsimCommand);

				}
			}
		}
	}

	/**
	 * @param impl
	 * @param message
	 */
	protected void processBrokerMessage(Re420 impl, MessageMiddleware message) {

		// is fabisch endpoint digital message
		if (impl.getEndpointFabisch().getMapDigital()
				.isKeyAvailable(message.getGlobalId())) {

			String channel = impl.getEndpointFabisch().getMapDigital()
					.getValue(message.getGlobalId());
			String data = message.getParameter();

			data = util.convertParameter(channel, data);

			impl.getEndpointFabisch().sendStream(channel + data);

			// is fabisch endpoint analog message
		} else if (impl.getEndpointFabisch().getMapAnalog()
				.isKeyAvailable(message.getGlobalId())) {
			String channel = impl.getEndpointFabisch().getMapAnalog()
					.getValue(message.getGlobalId());
			String data = message.getParameter();

			// TODO convert from locsim values to fabisch values

			impl.getEndpointFabisch().sendStream(channel + data);
		}
		
		// is software message
		else if (MessageProcessorUtil.isSoftwareMessage(message.getOutputInput())) {

			if (message.getGlobalId().equalsIgnoreCase(
					"locsim.initialization.ready.ini1")
					&& !util.init1) {
				impl.getEndpointUbw32().setCacheEnabled(false);
				impl.getEndpointUbw32().run();
				util.init1 = true;
			}

			else if (message.getGlobalId().equalsIgnoreCase(
					"locsim.initialization.ready.ini2")) {
				// nothing to do
			}

			else if (message.getGlobalId().equalsIgnoreCase(
					"locsim.initialization.ready.ini7")) {
				impl.getEndpointUbw32().pollingCommand();
				impl.getEndpointUbw32().setCacheEnabled(false);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					LOGGER.error(e);
				}
				impl.getEndpointUbw32().setCacheEnabled(true);
			}

			else if (message.getGlobalId().equalsIgnoreCase(
					"locsim.initialization.ready.ini8")) {
				// nothing to do
			}
			
			else if (message.getGlobalId().equalsIgnoreCase(
					"mgmt.cabine.re420.fabisch")) {

				switch (message.getParameter()) {
					case ("init"): {
						impl.getEndpointFabisch().initialize();
						break;
					}
					case ("start"): {
						//nothing to do
						break;
					}
					case ("stop"): {
						//nothing to do
						break;
					}
				}
			}

			else if (message.getGlobalId().equalsIgnoreCase(
					"mgmt.cabine.re420.ubw32")) {

				switch (message.getParameter()) {
					case ("init"): {
						impl.getEndpointUbw32().initialize();
						break;
					}
					case ("start"): {
						impl.getEndpointUbw32().run();
						break;
					}
					case ("stop"): {
						impl.getEndpointUbw32().interrupt();
						break;
					}
				}
			}

			// is hardware message
		} else {

			String value = util.getParameterValueRe420(message.getParameter());
			boolean isInput = message.getOutputInput().equals(
					MessageUbw32Base.MESSAGE_CHAR_INPUT);

			// is ubw message
			if (impl.getEndpointUbw32().getMapDigital()
					.isKeyAvailable(message.getGlobalId())) {

				String endpointRegister = impl.getEndpointUbw32()
						.getMapDigital().getMap().get(message.getGlobalId());
				String registerName = String
						.valueOf(endpointRegister.charAt(0));
				String pin = String.valueOf(endpointRegister.charAt(1));

				if (isInput) {
					impl.getEndpointUbw32().getPinInputDigital(registerName,
							pin);
				} else {
					impl.getEndpointUbw32().setPinOutputDigital(registerName,
							pin, value);
				}

				// is analog message
			} else if (impl.getEndpointUbw32().getMapAnalog()
					.isKeyAvailable(message.getGlobalId())) {

				String endpointRegister = impl.getEndpointUbw32()
						.getMapAnalog().getMap().get(message.getGlobalId());

				if (isInput) {
					impl.getEndpointUbw32().getPinInputAnalog(endpointRegister);
				}

			} else {
				LOGGER.warn(impl.getClass() + "> processBrokerMessage skipped:"
						+ message);
			}
		}
	}

	@Override
	protected void processBrokerMessage(OML impl, MessageMiddleware message) {
		// TODO Auto-generated method stub
		
	}
	
}
