package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.common.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapInitAusbildung extends ComponentMapBase {

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    protected void init(){
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;zusi_version;?;zusi_ausbildung;#");
        map.put("0100-0200::0200", "0100-0200::0200;;;command;ack_hello;zusi_verbindungsinfo;?;zusi_ausbildung;#");
        map.put("0100-0200::0300", "0100-0200::0300;;;command;ack_hello;client_akzeptiert;?;zusi_ausbildung;#");
        map.put("0300-0400::0100", "0300-0400::0100;;;command;ack_needed_data;client_data_ack;?;zusi_ausbildung;#");
    }

}
