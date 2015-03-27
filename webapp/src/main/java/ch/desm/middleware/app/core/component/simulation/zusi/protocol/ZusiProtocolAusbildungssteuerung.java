package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolAusbildungssteuerung {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolAusbildungssteuerung.class);
    /**
     * Der MODUL-Befehl überträgt ein Streckenmodul (st3-Datei) und weitere zugehörige Dateien (Signale) von Zusi an den Client.
     */
    public static final String COMMAND_FROM_MODULE = "000B";

    /**
     * Der TRAINPOS-Befehl überträgt die aktuelle Zugpositionen von Zusi an den Client.
     */
    public static final String COMMAND_FROM_TRAINPOS = "000D";

    /**
     * Der SWITCHPOS-Befehl überträgt eine geänderte Weichenstellung von Zusi an den Client.
     */
    public static final String COMMAND_FROM_SWITCHPOS = "000F";

    /**
     * Der SIGNALPOS-Befehl überträgt eine geänderte Signalstellung von Zusi an den Client.
     */
    public static final String COMMAND_FROM_SIGNALPOS = "0010";

    /**
     * Der ROUTEPOS-Befehl überträgt die Info über das Stellen/Auflösen einer Fahrstraße von Zusi an den Client.
     */
    public static final String COMMAND_FROM_ROUTEPOS = "0011";

    /**
     * Der ALLTRAINPOS-Befehl überträgt alle aktuelle Zugpositionen von Zusi an den Client.
     */
    public static final String COMMAND_FROM_ALLTRAINPOS = "0014";

    /**
     * Der SWITCH-Befehl überträgt das Kommando zum Stellen einer Weiche vom Client an Zusi.
     */
    public static final String COMMAND_TO_SWITCH = "010C";

    /**
     * Der SIGNALASPECT-Befehl überträgt das Kommando zum Stellen eines Signalsbegriffs anhand der Signalmatrix vom Client an Zusi.
     */
    public static final String COMMAND_TO_SIGNALASPECT = "010D";


}
