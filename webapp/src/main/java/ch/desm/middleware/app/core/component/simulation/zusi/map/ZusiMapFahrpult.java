package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.common.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapFahrpult extends ComponentMapBase {

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    protected void init(){
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;zusi_version;?;zusi_fahrpult;#");
        map.put("0100-0200::0200", "0100-0200::0200;;;command;ack_hello;zusi_verbindungsinfo;?;zusi_fahrpult;#");
        map.put("0100-0200::0300", "0100-0200::0300;;;command;ack_hello;client_akzeptiert;?;zusi_fahrpult;#");
        map.put("0200-0400::0100", "0200-0400::0100;;;command;ack_needed_data;client_data_ack;?;zusi_fahrpult;#");
        map.put("0200-0a01-0100::0100:2b,0200:00,0300:07,0400:01,0500:00", "0200-0a01-0100::0100:2b,0200:00,0300:07,0400:01,0500:00;;;stromabnehmer;hoch;tastee;?;zusi_fahrpult;#");
        map.put("0200-0a01-0100::0100:2b,0200:00,0300:07,0400:00,0500:00", "0200-0a01-0100::0100:2b,0200:00,0300:07,0400:00,0500:00;;;stromabnehmer;tief;tastec;?;zusi_fahrpult;#");
        map.put("0200-0a01-0100::0100:11,0200:00,0300:01,0400:02,0500:00", "0200-0a01-0100::0100:11,0200:00,0300:01,0400:02,0500:00;;;hauptschalter;ein;taste h;?;zusi_fahrpult;#");
        map.put("0200-0a01-0100::0100:11,0200:00,0300:01,0400:00,0500:00", "0200-0a01-0100::0100:11,0200:00,0300:01,0400:00,0500:00;;;hauptschalter;aus;taste n;?;zusi_fahrpult;#");
        map.put("0200-0a01-0100::0100:07,0200:00,0300:03,0400:00,0500:00", "0200-0a01-0100::0100:07,0200:00,0300:03,0400:00,0500:00;;;richtungsschalter;vorwärts;bild-nach-oben;?;zusi_fahrpult;#");
        map.put("0200-0a01-0100::0100:07,0200:00,0300:03,0400:02,0500:00", "0200-0a01-0100::0100:07,0200:00,0300:03,0400:02,0500:00;;;richtungsschalter;rückwärts;bild-nach-unten;?;zusi_fahrpult;#");
        map.put("0200-0a00::0100", "0200-0a00::0100;;;geschwindigkeit;;;?;zusi_fahrpult;#");
        map.put("0200-0a00::1300", "0200-0a00::1300;;;status;hauptschalter;;?;zusi_fahrpult;#");
        map.put("0200-0a00::1900", "0200-0a00::1900;;;status;zurückgelegter gesamtweg;;?;zusi_fahrpult;#");
        map.put("0200-0a00::5500", "0200-0a00::5500;;;status;stromabnehmer;;?;zusi_fahrpult;#");


    }

}
