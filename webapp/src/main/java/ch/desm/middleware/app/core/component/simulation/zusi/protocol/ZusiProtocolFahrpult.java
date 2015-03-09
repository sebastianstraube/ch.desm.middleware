package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolFahrpult {

    /**
     * Der INPUT-Befehl überträgt Nutzdaten vom Client an Zusi. Diese Daten sollten nur bedarfsweise gesendet werden,
     * also nur, wenn sich die jeweilige Größe geändert hat. Bei Schaltern wird die absolute Schalterstellung
     * übermittelt. Bei den Schaltern mit mehr als einer Schaltstellung gibt der Wert 0 immer die Grundstellung an.
     * Ein übertragener Wert größer 0 gibt die jeweilige Raste in positive Schaltrichtung an, negative Werte können
     * für die andere Richtung in Frage kommen (z.B. Kombischalter als Fahrschalter mit integrierter dynamischer Bremse)
     */
    public static final String COMMAND_TO_INPUT = "010A";

    /**
     * x0001 (1) Geschwindigkeit m/s single
     */
    public static final String ID_FUEHRERSTAND_GESCHWINDIGKEIT = "0001";


}
