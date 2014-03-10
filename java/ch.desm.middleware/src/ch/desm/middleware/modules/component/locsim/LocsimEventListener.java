package ch.desm.middleware.modules.component.locsim;

import java.util.EventObject;

import ch.desm.middleware.modules.component.ComponentEventListener;

public class LocsimEventListener extends ComponentEventListener{

	public LocsimEventListener(){
		
	}

	@Override
	public void handleEvent(EventObject event) {
		System.out.println("Locsim event listener handles the Event: "+ event.getClass());
	}
	
}
