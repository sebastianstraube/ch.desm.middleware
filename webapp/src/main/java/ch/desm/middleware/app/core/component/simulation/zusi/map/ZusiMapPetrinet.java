package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.common.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapPetrinet extends ComponentMapBase {

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    protected void init(){
        map.put("0300-0D01::0100:526f757465735c5363687765697a5c3332545f303030345f303035325c3030303430365f3030353230315f4f6265726d6174745c3133303931382d454d4d2d4f4d2d4c4e2e737433,0200:49,0300:00,0400:00,0500:00","OML_LN_$C26_FB1"); //LN Ausfahrsignal C2-6 FB1
        map.put("0300-0D01::0100:526f757465735c5363687765697a5c3332545f303030345f303035325c3030303430365f3030353230315f4f6265726d6174745c3133303931382d454d4d2d4f4d2d4c4e2e737433,0200:49,0300:00,0400:00,0500:01","OML_LN_$C26_Halt"); //LN Ausfahrsignal C2-6 HALT
        map.put("0300-0D01::0100:526f757465735c5363687765697a5c3332545f303030345f303035325c3030303430365f3030353230315f4f6265726d6174745c3133303931382d454d4d2d4f4d2d4c4e2e737433,0200:49,0300:00,0400:00,0500:02","OML_LN_$C26_FB1"); //LN Ausfahrsignal C2-6 FB2
    }

}
