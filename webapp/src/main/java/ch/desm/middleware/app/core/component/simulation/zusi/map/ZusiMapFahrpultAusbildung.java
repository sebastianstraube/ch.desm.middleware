package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapFahrpultAusbildung extends ComponentMapBase {

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
        map.put("0002-010a-0001::0001:2b,0002:00,0003:07,0004:1,0005:0", "0002-010a-0001::0001:2b,0002:00,0003:07,0004:1,0005:0;;;stromabnehmer;hoch;tastee;?;zusi_fahrpult;#");
        map.put("0002-010a-0001::0001:2b,0002:00,0003:07,0004:0,0005:0", "0002-010a-0001::0001:2b,0002:00,0003:07,0004:0,0005:0;;;stromabnehmer;tief;tastec;?;zusi_fahrpult;#");
        map.put("0002-010a-0001::0001:11,0002:00,0003:01,0004:2,0005:0", "0002-010a-0001::0001:11,0002:00,0003:01,0004:2,0005:0;;;hauptschalter;ein;taste h;?;zusi_fahrpult;#");
        map.put("0002-010a-0001::0001:11,0002:00,0003:01,0004:0,0005:0", "0002-010a-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi_fahrpult;#");
        map.put("0002-010a-0001::0001:07,0002:00,0003:03,0004:0,0005:0", "0002-010a-0001::0001:07,0002:00,0003:03,0004:0,0005:0;;;richtungsschalter;vorwärts;bild-nach-oben;?;zusi_fahrpult;#");
        map.put("0002-010a-0001::0001:07,0002:00,0003:03,0004:2,0005:0", "0002-010a-0001::0001:07,0002:00,0003:03,0004:2,0005:0;;;richtungsschalter;rückwärts;bild-nach-unten;?;zusi_fahrpult;#");
        map.put("0002-000a::0001", "0002-000a::0001;;;geschwindigkeit;;;?;zusi_fahrpult;#");
    }

}
