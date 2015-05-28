package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.common.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapCabineRe420 extends ComponentMapBase {

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
// map.put("0200-0A01-0100::0100:2b00,0200:0000,0300:0700,0400:0100,0500:00000000",""); //Stromabnehmer heben
// map.put("0200-0A01-0100::0100:2200,0200:0000,0300:0700,0400:2200,0500:00000000",""); //Stromabnehmer mittelstellung
// map.put("0200-0A01-0100::0100:2b00,0200:0000,0300:0700,0400:0000,0500:00000000",""); //Stromabnehmer senken
// map.put("0200-0A01-0100::0100:1100,0200:0000,0300:0700,0400:0200,0500:00000000",""); //Hauptschalter ein
// map.put("0200-0A01-0100::0100:1100,0200:0000,0300:0700,0400:0000,0500:00000000",""); //Hauptschalter aus
// map.put("0200-0A01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000",""); //Luftpresser ein / aus
// map.put("0200-0A01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000",""); //Luftpresser ein / aus
// map.put("0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0000,0500:00000000",""); //Richtungsschalter rückwärts
// map.put("0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0100,0500:00000000",""); //Richtungsschalter neutral
// map.put("0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0200,0500:00000000",""); //Richtungsschalter vorwärts
// map.put("0200-0A01-0100::0100:0200,0200:0000,0300:0700,0400:0800,0500:00000000",""); //Fahrschalter.bremsen.plus
// map.put("0200-0A01-0100::0100:0200,0200:0000,0300:0700,0400:0700,0500:00000000",""); //Fahrschalter.bremsen.punkt
// map.put("0200-0A01-0100::0100:0200,0200:0000,0300:0700,0400:0600,0500:00000000",""); //Fahrschalter.bremsen.minus
// map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0500,0500:00000000",""); //Fahrschalter.neutral
// map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0400,0500:00000000",""); //Fahrschalter.fahren.minus
// map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0300,0500:00000000",""); //Fahrschalter.fahren.punkt
// map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0200,0500:00000000",""); //Fahrschalter.fahren.m
// map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0100,0500:00000000",""); //Fahrschalter.fahren.plus
// map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0000,0500:00000000",""); //Fahrschalter.fahren.plusplus
// map.put("0200-0A01-0100::0100:0c00,0200:0000,0300:0700,0400:0200,0500:00000000",""); //Pfeife ein
// map.put("0200-0A01-0100::0100:1300,0200:0000,0300:0700,0400:,0500:00000000",""); //Schleuderschutz
        map.put("0200-0A01-0100::0100:1000,0200:0000,0300:0700,0400:0100,0500:00000000","S235"); //Sifa
// map.put("0200-0A01-0100::0100:1000,0200:0000,0300:0700,0400:0200,0500:00000000",""); //Sifa
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
// map.put("0200-0A00::1300",""); //Hauptschalter
// map.put("0200-0A00::1900",""); //Status Zurückgelegter Gesamtweg
// map.put("0200-0A00::5500",""); //Status Stromabnehmer
// map.put("",""); //

    }

}
