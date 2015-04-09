package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.common.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapAusbildung extends ComponentMapBase {

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
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;zusi_version;?;zusi_ausbildung;#");
        map.put("0100-0200::0200", "0100-0200::0200;;;command;ack_hello;zusi_verbindungsinfo;?;zusi_ausbildung;#");
        map.put("0100-0200::0300", "0100-0200::0300;;;command;ack_hello;client_akzeptiert;?;zusi_ausbildung;#");
        map.put("0300-0400::0100", "0300-0400::0100;;;command;ack_needed_data;client_data_ack;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0100", "0300-1400-0100::0100;;;command;alltrainpos;parameter_0001;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0200", "0300-1400-0100::0200;;;command;alltrainpos;parameter_0002;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0300", "0300-1400-0100::0300;;;command;alltrainpos;parameter_0003;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0400", "0300-1400-0100::0400;;;command;alltrainpos;parameter_0004;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0500", "0300-1400-0100::0500;;;command;alltrainpos;parameter_0005;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0600", "0300-1400-0100::0600;;;command;alltrainpos;parameter_0006;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0700", "0300-1400-0100::0700;;;command;alltrainpos;parameter_0007;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0800", "0300-1400-0100::0800;;;command;alltrainpos;parameter_0008;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0900", "0300-1400-0100::0900;;;command;alltrainpos;parameter_0009;?;zusi_ausbildung;#");
        map.put("0300-1400-0100::0a00", "0300-1400-0100::0a00;;;command;alltrainpos;parameter_000a;?;zusi_ausbildung;#");

    }

}
