package sebastianstraube.connectx.module.desm.simulation.zusi.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapAusbildungInit extends ComponentMapBase {

    @Override
    protected void init(){
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;zusi_version;zusi_ausbildung;b;?;");
        map.put("0100-0200::0200", "0100-0200::0200;;;command;ack_hello;zusi_verbindungsinfo;zusi_ausbildung;b;?;");
        map.put("0100-0200::0300", "0100-0200::0300;;;command;ack_hello;client_akzeptiert;zusi_ausbildung;b;?;");
        map.put("0300-0400::0100", "0300-0400::0100;;;command;ack_needed_data;client_data_ack;zusi_ausbildung;b;?;");    }

}
