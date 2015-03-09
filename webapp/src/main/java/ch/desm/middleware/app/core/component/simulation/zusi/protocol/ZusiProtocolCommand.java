package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolCommand {

    private static final String GROUPID_COMMAND_INPUT = "0003-0113-0001";

    /**
     *
     *
     ID ID Datentyp Bedeutung
     Global ID
     00 03 <Knoten> Ausbilder-Anwendung 03
     01 13 <Knoten> Befehl INPUT
     00 01 <Knoten> Tastatureingaben
     00 01 Word     Tastaturzuordnung
     00 02 Word     Tastaturkommando

     Parameter
     00 03 Word     Tastaturaktion
     00 04 SmallInt Schalterposition
     00 05 Single   Parameter für  spezielle Funktionen, im Regelfall 0

     * @param message
     * @return
     */
    public String commandInput(ZusiProtocolMessage message) {

        if(isCommandInput(message)){

        }

        return null;
    }

    public boolean isCommandInput(ZusiProtocolMessage message){
        return message.hasGroupId(GROUPID_COMMAND_INPUT);
    }


}
