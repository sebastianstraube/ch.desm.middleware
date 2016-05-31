package sebastianstraube.connectx.module.desm.simulation.zusi.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapFahrpultMiddleware extends ComponentMapBase {

    @Override
    protected void init(){
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;zusi_version;zusi_fahrpult;s;?;");
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;zusi_verbindungsinfo;zusi_fahrpult;s;?;");
        map.put("0100-0200::0100", "0100-0200::0100;;;command;ack_hello;client_akzeptiert;zusi_fahrpult;s;?;");
        map.put("0200-0400::0100", "0200-0400::0100;;;command;ack_needed_data;client_data_ack;zusi_fahrpult;s;?;");
        map.put("0200-0a01-0100::0100:2b00,0200:0000,0300:0700,0400:0200,0500:00000000", "0200-0a01-0100::0100:2b00,0200:0000,0300:0700,0400:0200,0500:00000000;;;stromabnehmer;heben;tastee;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:2200,0200:0000,0300:0700,0400:2200,0500:00000000", "0200-0a01-0100::0100:2200,0200:0000,0300:0700,0400:2200,0500:00000000;;;stromabnehmer;mittelstellung;;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:2b00,0200:0000,0300:0700,0400:0000,0500:00000000", "0200-0a01-0100::0100:2b00,0200:0000,0300:0700,0400:0000,0500:00000000;;;stromabnehmer;senken;tastec;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:1100,0200:0000,0300:0700,0400:0200,0500:00000000", "0200-0a01-0100::0100:1100,0200:0000,0300:0700,0400:0200,0500:00000000;;;hauptschalter;ein;taste h;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:1100,0200:0000,0300:0700,0400:0000,0500:00000000", "0200-0a01-0100::0100:1100,0200:0000,0300:0700,0400:0000,0500:00000000;;;hauptschalter;aus;taste n;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000", "0200-0a01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000;;;kompressor;ein;taste q;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000", "0200-0a01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000;;;kompressor;aus;taste q;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0700,0200:0000,0300:0700,0400:0000,0500:00000000", "0200-0a01-0100::0100:0700,0200:0000,0300:0700,0400:0000,0500:00000000;;;richtungsschalter;rückwärts;bild-nach-oben;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0700,0200:0000,0300:0700,0400:0100,0500:00000000", "0200-0a01-0100::0100:0700,0200:0000,0300:0700,0400:0100,0500:00000000;;;richtungsschalter;null;;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0700,0200:0000,0300:0700,0400:0200,0500:00000000", "0200-0a01-0100::0100:0700,0200:0000,0300:0700,0400:0200,0500:00000000;;;richtungsschalter;vorwärts;bild-nach-unten;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0800,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0800,0500:00000000;;;fahrschalter;bremsen.plus;taste 3;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0700,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0700,0500:00000000;;;fahrschalter;bremsen.punkt;taste 6;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0600,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0600,0500:00000000;;;fahrschalter;bremsen.minus;taste 9;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0500,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0500,0500:00000000;;;fahrschalter;neutral;aufschalten: 8, abschalten 2;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0400,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0400,0500:00000000;;;fahrschalter;fahren.minus;aufschalten: 8, abschalten 2;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0300,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0300,0500:00000000;;;fahrschalter;fahren.punkt;aufschalten: 8, abschalten 2;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0200,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0200,0500:00000000;;;fahrschalter;fahren.m;aufschalten: 8, abschalten 2;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0100,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0100,0500:00000000;;;fahrschalter;fahren.plus;aufschalten: 8, abschalten 2;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0000,0500:00000000", "0200-0a01-0100::0100:0100,0200:0000,0300:0700,0400:0000,0500:00000000;;;fahrschalter;fahren.plusplus;aufschalten: 8, abschalten 2;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:0c00,0200:0000,0300:0700,0400:0200,0500:00000000", "0200-0a01-0100::0100:0c00,0200:0000,0300:0700,0400:0200,0500:00000000;;;pfeife ein / aus;;taste p;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:1300,0200:0000,0300:0700,0400:,0500:00000000", "0200-0a01-0100::0100:1300,0200:0000,0300:0700,0400:,0500:00000000;;;schleuderschutz;;;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:1000,0200:0000,0300:0100,0400:0000,0500:00000000", "0200-0a01-0100::0100:1000,0200:0000,0300:0100,0400:0000,0500:00000000;;;totmannpedal;an;taste leer;zusi_fahrpult;b;?;");
        map.put("0200-0a01-0100::0100:1000,0200:0000,0300:0200,0400:0000,0500:00000000", "0200-0a01-0100::0100:1000,0200:0000,0300:0200,0400:0000,0500:00000000;;;totmannpedal;aus;taste leer;zusi_fahrpult;b;?;");
        map.put("0200-0a00::0100", "0200-0a00::0100;;;geschwindigkeit;;;zusi_fahrpult;b;?;");
        map.put("0200-0a00::1300", "0200-0a00::1300;;;status;hauptschalter;;zusi_fahrpult;b;?;");
        map.put("0200-0a00::1900", "0200-0a00::1900;;;status;zurückgelegter_gesamtweg;;zusi_fahrpult;b;?;");
        map.put("0200-0a00::5500", "0200-0a00::5500;;;status;stromabnehmer;;zusi_fahrpult;b;?;");    }
}
