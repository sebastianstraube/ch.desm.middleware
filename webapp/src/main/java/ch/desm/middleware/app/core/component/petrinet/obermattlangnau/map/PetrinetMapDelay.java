package ch.desm.middleware.app.core.component.petrinet.obermattlangnau.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

public class PetrinetMapDelay extends ComponentMapBase{

	@Override
	public Map<String, String> getMap() {
		return map;
	}

    public String mapBrokerToEndpointMessage(String globalId) throws Exception {
        String message = this.getKey(globalId);
        if(message.isEmpty()) {
            throw new Exception("unable to map broker message with globalId\"" + globalId + "\"");
        }
        return message;
    }

	@Override
	protected void init(){
        map.put("OML_Stw_W1_endlage_minus_erreichen", "5500");
        map.put("OML_Stw_W1_endlage_plus_erreichen", "5500");
    }

}
