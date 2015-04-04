package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolConstants {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolConstants.class);

    public static final String CLIENT_TYPE = "DESM-Middleware";
    public static final String CLIENT_VERSION = "1.0";

    /**
     * 12.3.3.3.2. Status Zugsicherung Um auch komplexere Systeme darstellen zu können, wird der Status des Zugsicherungssystems in einer Struktur übertragen. Wenn es eine Änderung bei der Zugsicherung gab, wird immer das komplette Paket übertragen, auch wenn sich z.B. nur ein Wert verändert hat.
     * 12.3.3.3.2.1. Grundblock Für jedes Zugsicherungssystem wird zunächst der folgende Grundblock verschickt, gefolgt von systemspezifischen Werten, die in den folgenden Kapiteln aufgeführt werden.
     */
    private static final String GROUPID_COMMAND_STATE_ZUSI = "0002-010A-0001";

    /**
     * 12.3.3.6. Befehl 01 0A – INPUT (Client → Zusi) Der INPUT-Befehl überträgt Nutzdaten vom Client an Zusi. Diese Daten sollten nur bedarfsweise gesendet werden, also nur, wenn sich die jeweilige Größe geändert hat. Bei Schaltern wird die absolute Schalterstellung übermittelt. Bei den Schaltern mit mehr als einer Schaltstellung gibt der Wert 0 immer die Grundstellung an. Ein übertragener Wert größer 0 gibt die jeweilige Raste in positive Schaltrichtung an, negative Werte können für die andere Richtung in Frage kommen (z.B. Kombischalter als Fahrschalter mit integrierter dynamischer Bremse)
     */
    private static final String GROUPID_COMMAND_INPUT = "0002-010A-0001";

    /**
     * 12.3.4.13. Befehl 00 14 – ALLTRAINPOS (Zusi  Client) Der ALLTRAINPOS-Befehl überträgt alle aktuelle Zugpositionen von Zusi an den Client.
     */
    private static final String GROUPID_COMMAND_ALLTRAINPOS = "0001-0002";
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
