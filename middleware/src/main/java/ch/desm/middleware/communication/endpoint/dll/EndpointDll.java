package ch.desm.middleware.communication.endpoint.dll;

import org.apache.log4j.Logger;

import ch.desm.middleware.communication.Dll;
import ch.desm.middleware.communication.endpoint.EndpointBaseCommon;
import ch.desm.middleware.communication.endpoint.dll.objects.EndpointObjectDllSignal;
import ch.desm.middleware.communication.endpoint.dll.objects.EndpointObjectDllTrainPosition;
import ch.desm.middleware.communication.endpoint.dll.objects.EndpointObjectDllWeiche;
import ch.desm.middleware.component.simulation.locsim.messages.LocsimMessageTranslatorDll;

public abstract class EndpointDll extends EndpointBaseCommon implements
		EndpointDllListenerInterface {

	private static Logger log = Logger.getLogger(EndpointDll.class);
	
	private Dll dll;
	private EndpointDllThread eventPollingDaemonDll;

	public EndpointDll(String configPath) {
		
		dll = new Dll();
		dll.onStartProgramm(configPath);
		this.eventPollingDaemonDll = new EndpointDllThread(
				"EndpointDesmDllPolling", dll, this);
	}

	public Dll getDll() {
		return dll;
	}

	public void receiveEndpointObject(Object obj){
		
		log.trace("receive in endpoint " + this.getClass() + " an object " + obj.getClass());
		
		String message = "";
		
		if(obj instanceof EndpointObjectDllSignal){
			message = new LocsimMessageTranslatorDll().translateToMiddlewareMessage((EndpointObjectDllSignal)obj);
		
		}else if(obj instanceof EndpointObjectDllTrainPosition){
			message = new LocsimMessageTranslatorDll().translateToMiddlewareMessage((EndpointObjectDllTrainPosition)obj);
		
		}else if(obj instanceof EndpointObjectDllWeiche){
			message = new LocsimMessageTranslatorDll().translateToMiddlewareMessage((EndpointObjectDllWeiche)obj);
		}else{
			
			log.error("Translation does not support yet endpoint object: " + obj.getClass());
		}
		
		if(!message.isEmpty()){
			this.onIncomingEndpointMessage(message);
		}
	}

}
