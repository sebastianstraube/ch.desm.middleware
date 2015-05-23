package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.common.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapRe420 extends ComponentMapBase {

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    protected void init(){
// map.put("0100-0200::0100",""); //Initialisierung acknowledge command from zusi
// map.put("0100-0200::0100",""); //Initialisierung acknowledge command from zusi
// map.put("0100-0200::0100",""); //Initialisierung acknowledge command from zusi
// map.put("0200-0400::0100",""); //Initialisierung acknowledge command needed data from zusi
        map.put("0200-0A01-0100::0100:2b,0200:00,0300:07,0400:01,0500:00","S129"); //Stromabnehmer heben
        map.put("0200-0A01-0100::0100:11,0200:00,0300:07,0400:02,0500:00","S132"); //Hauptschalter ein
// map.put("0200-0A01-0100::0100:11,0200:00,0300:07,0400:00,0500:00",""); //Hauptschalter aus
// map.put("0200-0A01-0100::0100:2d,0200:00,0300:07,0400:,0500:00",""); //Luftpresser ein / aus
// map.put("0200-0A01-0100::0100:2d,0200:00,0300:07,0400:,0500:00",""); //Luftpresser ein / aus
        map.put("0200-0A01-0100::0100:07,0200:00,0300:07,0400:00,0500:00","S140b"); //Richtungsschalter rückwärts
// map.put("0200-0A01-0100::0100:07,0200:00,0300:07,0400:01,0500:00",""); //Richtungsschalter neutral
        map.put("0200-0A01-0100::0100:07,0200:00,0300:07,0400:02,0500:00","S140a"); //Richtungsschalter vorwärts
        map.put("0200-0A01-0100::0100:02,0200:00,0300:07,0400:08,0500:00","fahrschalter.bremsen.plus"); //Fahrschalter.bremsen.plus
        map.put("0200-0A01-0100::0100:02,0200:00,0300:07,0400:07,0500:00","fahrschalter.bremsen.punkt"); //Fahrschalter.bremsen.punkt
        map.put("0200-0A01-0100::0100:02,0200:00,0300:07,0400:06,0500:00","fahrschalter.bremsen.minus"); //Fahrschalter.bremsen.minus
        map.put("0200-0A01-0100::0100:01,0200:00,0300:07,0400:05,0500:00","fahrschalter.neutral"); //Fahrschalter.neutral
        map.put("0200-0A01-0100::0100:01,0200:00,0300:07,0400:04,0500:00","fahrschalter.fahren.minus"); //Fahrschalter.fahren.minus
        map.put("0200-0A01-0100::0100:01,0200:00,0300:07,0400:03,0500:00","fahrschalter.fahren.punkt"); //Fahrschalter.fahren.punkt
        map.put("0200-0A01-0100::0100:01,0200:00,0300:07,0400:02,0500:00","fahrschalter.fahren.m"); //Fahrschalter.fahren.m
        map.put("0200-0A01-0100::0100:01,0200:00,0300:07,0400:01,0500:00","fahrschalter.fahren.plus"); //Fahrschalter.fahren.plus
        map.put("0200-0A01-0100::0100:01,0200:00,0300:07,0400:00,0500:00","fahrschalter.fahren.plusplus"); //Fahrschalter.fahren.plusplus
// map.put("0200-0A01-0100::0100:0c,0200:00,0300:07,0400:02,0500:00",""); //Pfeife ein
// map.put("0200-0A01-0100::0100:13,0200:00,0300:07,0400:,0500:00",""); //Schleuderschutz
        map.put("0200-0A01-0100::0100:10,0200:00,0300:07,0400:01,0500:00","S235"); //Sifa
        map.put("0200-0A01-0100::0100:10,0200:00,0300:07,0400:02,0500:00","S235"); //Sifa
// map.put("0200-0A00::0100",""); //Geschwindigkeit
// map.put("",""); //Uhrzeit
// map.put("",""); //Sifa Hupe
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //Fahrleitungsspannung
// map.put("",""); //Oberstrom
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("",""); //
// map.put("0200-0A00::1900",""); //Status Zurückgelegter Gesamtweg
// map.put("0200-0A00::5500",""); //Status Stromabnehmer
// map.put("",""); //

    }

}
