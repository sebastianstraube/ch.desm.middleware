package ch.desm.middleware.module.desm.simulation.zusi.protocol;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolConstants {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolConstants.class);

    public static final String CLIENT_TYPE = "DESM-Middleware";
    public static final String CLIENT_VERSION = "1.0";
    public static final int CLIENT_TYPE_AUSBILDUNG = 3;
    public static final int CLIENT_TYPE_FAHRPULT = 2;

    public static final String NODE_START = "00000000";
    public static final String NODE_END = "FFFFFFFF";
    public static final String DELIMITER_SUBMESSAGE = "#";
    public static final String DELIMITER_GROUP = "::";
    public static final String DELIMITER_GROUP_VALUE = "-";
    public static final String DELIMITER_PARAMETER = ",";
    public static final String DELIMITER_PARAMETER_VALUE = ":";

    public static final String MAP_PARAMETER_VALUE_GESCHWINDIGKEIT = "MAP_PARAMETER_VALUE_GESCHWINDIGKEIT";
    public static final String MAP_PARAMETER_VALUE_GESAMTWEG = "MAP_PARAMETER_VALUE_GESAMTWEG";

    /**
     * 12.3.3.3.2. Status Zugsicherung Um auch komplexere Systeme darstellen zu können, wird der Status des Zugsicherungssystems in einer Struktur übertragen. Wenn es eine Änderung bei der Zugsicherung gab, wird immer das komplette Paket übertragen, auch wenn sich z.B. nur ein Wert verändert hat.
     * 12.3.3.3.2.1. Grundblock Für jedes Zugsicherungssystem wird zunächst der folgende Grundblock verschickt, gefolgt von systemspezifischen Werten, die in den folgenden Kapiteln aufgeführt werden.
     */
    private static final String GROUPID_COMMAND_STATE_ZUSI = "0200-0A01-0100";

    /**
     * 12.3.3.6. Befehl 01 0A – INPUT (Client → Zusi) Der INPUT-Befehl überträgt Nutzdaten vom Client an Zusi. Diese Daten sollten nur bedarfsweise gesendet werden, also nur, wenn sich die jeweilige Größe geändert hat. Bei Schaltern wird die absolute Schalterstellung übermittelt. Bei den Schaltern mit mehr als einer Schaltstellung gibt der Wert 0 immer die Grundstellung an. Ein übertragener Wert größer 0 gibt die jeweilige Raste in positive Schaltrichtung an, negative Werte können für die andere Richtung in Frage kommen (z.B. Kombischalter als Fahrschalter mit integrierter dynamischer Bremse)
     */
    private static final String GROUPID_COMMAND_INPUT = "0200-0A01-0100";

    /**
     * 12.3.4.13. Befehl 00 14 – ALLTRAINPOS (Zusi  Client) Der ALLTRAINPOS-Befehl überträgt alle aktuelle Zugpositionen von Zusi an den Client.
     */
    private static final String GROUPID_COMMAND_ALLTRAINPOS = "0100-0200";
    /**
     * Der MODUL-Befehl überträgt ein Streckenmodul (st3-Datei) und weitere zugehörige Dateien (Signale) von Zusi an den Client.
     */
    public static final String COMMAND_FROM_MODULE = "0B00";

    /**
     * Der TRAINPOS-Befehl überträgt die aktuelle Zugpositionen von Zusi an den Client.
     */
    public static final String COMMAND_FROM_TRAINPOS = "0D00";

    /**
     * Der SWITCHPOS-Befehl überträgt eine geänderte Weichenstellung von Zusi an den Client.
     */
    public static final String COMMAND_FROM_SWITCHPOS = "0F00";

    /**
     * Der SIGNALPOS-Befehl überträgt eine geänderte Signalstellung von Zusi an den Client.
     */
    public static final String COMMAND_FROM_SIGNALPOS = "1000";

    /**
     * Der ROUTEPOS-Befehl überträgt die Info über das Stellen/Auflösen einer Fahrstraße von Zusi an den Client.
     */
    public static final String COMMAND_FROM_ROUTEPOS = "1100";

    /**
     * Der ALLTRAINPOS-Befehl überträgt alle aktuelle Zugpositionen von Zusi an den Client.
     */
    public static final String COMMAND_FROM_ALLTRAINPOS = "1400";

    /**
     * Der SWITCH-Befehl überträgt das Kommando zum Stellen einer Weiche vom Client an Zusi.
     */
    public static final String COMMAND_TO_SWITCH = "0C01";

    /**
     * Der SIGNALASPECT-Befehl überträgt das Kommando zum Stellen eines Signalsbegriffs anhand der Signalmatrix vom Client an Zusi.
     */
    public static final String COMMAND_TO_SIGNALASPECT = "0D01";
}
