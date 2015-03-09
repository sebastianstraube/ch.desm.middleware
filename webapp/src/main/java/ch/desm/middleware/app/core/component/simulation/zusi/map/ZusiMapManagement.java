package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapManagement extends ComponentMapBase {

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
        map.put("0001-0002::0001:00200033002e0030002e0036002e00320036,0002:0031003700330033003500320032003600360037,0003:0000", "");
    }

}
