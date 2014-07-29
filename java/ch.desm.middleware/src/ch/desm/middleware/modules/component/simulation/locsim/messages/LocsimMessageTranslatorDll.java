package ch.desm.middleware.modules.component.simulation.locsim.messages;

import ch.desm.middleware.modules.communication.endpoint.dll.objects.EndpointObjectDllSignal;
import ch.desm.middleware.modules.communication.endpoint.dll.objects.EndpointObjectDllTrainPosition;
import ch.desm.middleware.modules.communication.endpoint.dll.objects.EndpointObjectDllWeiche;
import ch.desm.middleware.modules.communication.message.translator.MessageTranslatorDll;
import ch.desm.middleware.modules.component.interlocking.elements.OMLMessageSignalStellung;

public class LocsimMessageTranslatorDll extends MessageTranslatorDll {

	/**
	 * 
	 * @param obj
	 */
	@Override
	public String translateToMiddlewareMessage(EndpointObjectDllTrainPosition obj) {

		String s = LocsimMessageDll.DLL_MESSAGE_GLEISLIST;
		s += "gleislist";
		s += ";";
		s += obj.gleisList.toString();
		s += ";";

		return s;
	}

	/**
	 * 
	 * @param obj
	 */
	@Override
	public String translateToMiddlewareMessage(EndpointObjectDllSignal obj) {

		String s = LocsimMessageDll.DLL_MESSAGE_SIGNAL;
		s += obj.signalId;
		s += ";";
		s += new OMLMessageSignalStellung().getSignalStellung(obj.stellung);
		s += ";";

		return s;
	}

	/**
	 * TODO implementation stellung
	 * 
	 * @param obj
	 */
	@Override
	public String translateToMiddlewareMessage(EndpointObjectDllWeiche obj) {

		String s = LocsimMessageDll.DLL_MESSAGE_WEICHE;
		s += obj.weicheId;
		s += ";";
		s += obj.gleisId;
		s += ";";
		// s += obj.stellung;
		// s+=";";

		return s;
	}	
}
