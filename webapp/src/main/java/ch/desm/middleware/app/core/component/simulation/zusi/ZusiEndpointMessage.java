package ch.desm.middleware.app.core.component.simulation.zusi;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiEndpointMessage extends ZusiEndpointMessageService{

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private String message;
    public ZusiEndpointMessage(ZusiService service, String message) throws Exception {
        super(service);
        this.message = message;
    }


    public String getMessageStream(){
        return this.message;
    }

    public String getMiddlewareMessage(){

        //do conversation from message to middleware message

        return "";
    }

    /**********************************/
    //Fahrpult Daten (<- Zusi)
    /*
    12.3.3.3. Befehl 00 0A – DATA_FTD (Zusi → Cient) Der DATA_FTD-Befehl überträgt Fahrpult-Nutzdaten von Zusi an den Client. Diese Daten werden von Zusi bedarfsweise gesendet, also nur, wenn sich die jeweilige Größe geändert hat (läßt sich im  Simulator unter „Einstellungen → Sonstiges“ ändern).
     */

    /**********************************/


    /**********************************/
    /*
    12.3.4. Anwendung 03 („Ausbildersteuerung“) Es folgen die Kommandos für alle Anwendungen, die sich beim Hello-Befehl mit Typ 03 angemeldet haben.
    Diese sind auf Clients zugeschnitten, die als Ausbilderstand von außen interaktiv auf das Geschehen in der Simulation zugreifen möchten wie z.B. Fahrstraßen/Signale
    nach Bedarf manuell stellen. Zusätzlich sind auch Kommandos zur Steuerung des Simulators enthalten. So kann der Simulator über den Client ferngesteuert werden,
    ohne Zusi am Simulationsrechner bedienen zu müssen.
     */
    /*
    12.3.4.1. Befehl 00 03 – NEEDED_DATA (Client  Zusi) → Mit dem NEEDED_DATA-Befehl teilt der Client Zusi mit, welche Daten er benötigt.
     */

    /*
    12.3.4.2. Befehl 00 04 – ACK_NEEDED_DATA (Zusi  Client) → Entscheidung, ob die benötigten Daten akzeptiert werden. Der Befehl wird von Zusi nach dem NEEDED_DATA-Befehl an den Client gesendet.
     */

    /*
    12.3.4.10. Befehl 00 11 – ROUTEPOS (Zusi  Client) → Der ROUTEPOS-Befehl überträgt die Info über das Stellen/Auflösen einer Fahrstraße vom Client an Zusi
     */

    /*
    12.3.4.8. Befehl 00 0F – SWITCHPOS (Zusi  Client) → Der SWITCHPOS-Befehl überträgt eine geänderte Weichenstellung von Zusi an den Client.
     */

    /*
    12.3.4.6. Befehl 00 0D – TRAINPOS (Zusi  Client) → Der TRAINPOS-Befehl überträgt die aktuelle Zugpositionen von Zusi an den Client.
     */
    /**********************************/


    /**********************************/
    //Bedienungen Fahrpult (<- Zusi)
    /*
    12.3.3.4. Befehl 00 0B – DATA_OPERATION (Zusi → Cient) Der DATA_OPERATION-Befehl überträgt die Bedienung des Führerstands (Tastatur, Maus, TCP usw.) von Zusi an den Client.
     */

    /**********************************/


    /**********************************/
    //Zugsicherungssystem
    /*
    12.3.3.3.2.1. Grundblock Für jedes Zugsicherungssystem wird zunächst der folgende Grundblock verschickt, gefolgt von systemspezifischen Werten, die in den folgenden Kapiteln aufgeführt werden.
     */

    /*
    12.3.3.3.3. Status Türen Um auch komplexere Systeme darstellen zu können, wird der Status des Türschließsystems in einer Struktur übertragen. Wenn es eine Änderung gab, wird immer das komplette Paket übertragen, auch wenn sich z.B. nur ein Wert verändert hat.
     */
    /**********************************/

}
