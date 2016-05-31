package sebastianstraube.connectx.module.desm.simulation.zusi.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapPetrinetRe420 extends ComponentMapBase {

    @Override
    protected void init(){

        map.put("0200-0A01-0100::0100:1000,0200:0000,0300:0100,0400:0000,0500:00000000","cabine_re420_totmannpedal_$on"); //an
        map.put("0200-0A01-0100::0100:1000,0200:0000,0300:0200,0400:0000,0500:00000000","cabine_re420_totmannpedal_$off"); //aus


        // map.put("0100-0200::0100",""); //ACK_HELLO
// map.put("0100-0200::0100",""); //ACK_HELLO
// map.put("0100-0200::0100",""); //ACK_HELLO
// map.put("0200-0400::0100",""); //ACK_NEEDED_DATA
        map.put("0200-0A01-0100::0100:2b00,0200:0000,0300:0700,0400:0200,0500:00000000","cabine_re420_stromabnehmer_$stromabnehmer_hoch"); //heben
// map.put("0200-0A01-0100::0100:2200,0200:0000,0300:0700,0400:2200,0500:00000000",""); //mittelstellung
        map.put("0200-0A01-0100::0100:2b00,0200:0000,0300:0700,0400:0000,0500:00000000","cabine_re420_stromabnehmer_$stromabnehmer_tief"); //senken
        map.put("0200-0A01-0100::0100:1100,0200:0000,0300:0700,0400:0200,0500:00000000","cabine_re420_hauptschalter_$hauptschalter_ein"); //ein
        map.put("0200-0A01-0100::0100:1100,0200:0000,0300:0700,0400:0000,0500:00000000","cabine_re420_hauptschalter_$hauptschalter_aus"); //aus
// map.put("0200-0A01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000",""); //ein
// map.put("0200-0A01-0100::0100:2d00,0200:0000,0300:0700,0400:0000,0500:00000000",""); //aus
        map.put("0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0000,0500:00000000","cabine_re420_wendeschalter_$wendeschalter_R"); //rückwärts
        map.put("0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0100,0500:00000000","cabine_re420_wendeschalter_$wendeschalter_0"); //null
        map.put("0200-0A01-0100::0100:0700,0200:0000,0300:0700,0400:0200,0500:00000000","cabine_re420_wendeschalter_$wendeschalter_V"); //vorwärts

        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0800,0500:00000000","cabine_re420_fahrschalter_controller_$bremsen_plus"); //bremsen.plus
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0700,0500:00000000","cabine_re420_fahrschalter_controller_$bremsen_punkt"); //bremsen.punkt
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0600,0500:00000000","cabine_re420_fahrschalter_controller_$bremsen_minus"); //bremsen.minus
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0500,0500:00000000","cabine_re420_fahrschalter_controller_$neutral"); //neutral
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0400,0500:00000000","cabine_re420_fahrschalter_controller_$fahren_minus"); //fahren.minus
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0300,0500:00000000","cabine_re420_fahrschalter_controller_$fahren_punkt"); //fahren.punkt
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0200,0500:00000000","cabine_re420_fahrschalter_controller_$fahren_m"); //fahren.m
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0100,0500:00000000","cabine_re420_fahrschalter_controller_$fahren_plus"); //fahren.plus
        map.put("0200-0A01-0100::0100:0100,0200:0000,0300:0700,0400:0000,0500:00000000","cabine_re420_fahrschalter_controller_$fahren_plusplus"); //fahren.plusplus
// map.put("0200-0A01-0100::0100:0c00,0200:0000,0300:0700,0400:0200,0500:00000000",""); //
// map.put("0200-0A01-0100::0100:1300,0200:0000,0300:0700,0400:,0500:00000000",""); //
// map.put("0200-0A01-0100::0100:1000,0200:0000,0300:0700,0400:0100,0500:00000000",""); //an
// map.put("0200-0A01-0100::0100:1000,0200:0000,0300:0700,0400:0200,0500:00000000",""); //aus
// map.put("0200-0A00::0100",""); //
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
// map.put("0200-0A00::1900",""); //Zurückgelegter_Gesamtweg
// map.put("0200-0A00::5500",""); //Stromabnehmer
// map.put("",""); //

    }
}
