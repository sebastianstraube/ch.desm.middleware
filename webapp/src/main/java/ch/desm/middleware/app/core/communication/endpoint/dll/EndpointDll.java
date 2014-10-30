package ch.desm.middleware.app.core.communication.endpoint.dll;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ch.desm.middleware.app.core.communication.Dll;
import ch.desm.middleware.app.core.communication.endpoint.EndpointCommon;
import ch.desm.middleware.app.core.communication.endpoint.dll.objects.EndpointObjectDllSignal;
import ch.desm.middleware.app.core.communication.endpoint.dll.objects.EndpointObjectDllTrainPosition;
import ch.desm.middleware.app.core.communication.endpoint.dll.objects.EndpointObjectDllWeiche;
import ch.desm.middleware.app.core.component.simulation.locsim.messages.LocsimMessageTranslatorDll;

public abstract class EndpointDll extends EndpointCommon implements
		EndpointDllListenerInterface {

	private static Logger LOGGER = Logger.getLogger(EndpointDll.class);
	
	private Dll dll;
	private EndpointDllThread thread;
	private String configPath;
	
	public EndpointDll(String configPath) {
		this.configPath = configPath;
	}
	
	public void initialize(){
		dll = new Dll();
		dll.onStartProgramm(configPath);
		this.thread = new EndpointDllThread(
				"EndpointDesmDllPolling", dll, this);
	}
	
	public void run(){
		thread.run();
		}
	
	public void interrupt(){
		if(thread.isAlive()){
			thread.interrupt();
		}
	}

	public void receiveEndpointObject(Object obj){
		
		LOGGER.log(Level.TRACE, "receive in endpoint " + this.getClass() + " an object " + obj.getClass());
		
		String message = "";
		
		if(obj instanceof EndpointObjectDllSignal){
			message = new LocsimMessageTranslatorDll().translateToMiddlewareMessage((EndpointObjectDllSignal)obj);
		
		}else if(obj instanceof EndpointObjectDllTrainPosition){
			message = new LocsimMessageTranslatorDll().translateToMiddlewareMessage((EndpointObjectDllTrainPosition)obj);
		
		}else if(obj instanceof EndpointObjectDllWeiche){
			message = new LocsimMessageTranslatorDll().translateToMiddlewareMessage((EndpointObjectDllWeiche)obj);
		}else{
			
			LOGGER.error("Translation does not support yet endpoint object: " + obj.getClass());
		}
		
		if(!message.isEmpty()){
			this.onIncomingEndpointMessage(message);
		}
	}

}
