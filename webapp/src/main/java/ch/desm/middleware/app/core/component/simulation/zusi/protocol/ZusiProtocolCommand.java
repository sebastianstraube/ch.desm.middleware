package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiEndpointMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeRoot;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolCommand {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolCommand.class);

    /**
     *
     * @param service
     * @param globalId
     * @return
     */
    public String getStreamFromZusi(ZusiService service, String globalId) throws Exception {
        ZusiProtocolNodeRoot root = ZusiProtocolNodeHelper.getRoot(globalId);
        String stream = service.getEncoder().encode(root);
        return stream;
    }

    /**
     *
     * @param service
     * @param globalId
     * @return
     */
    public String getStreamToZusi(ZusiService service, String globalId) throws Exception {
        ZusiProtocolNodeRoot root = ZusiProtocolNodeHelper.getRoot(globalId);
        String stream = service.getEncoder().encode(root);
        return stream;
    }

    /**
     *
     * 12.3.3.6. Befehl 01 0A – INPUT (Client → Zusi) Der INPUT-Befehl überträgt Nutzdaten vom Client an Zusi. Diese Daten sollten nur bedarfsweise gesendet werden, also nur, wenn sich die jeweilige Größe geändert hat. Bei Schaltern wird die absolute Schalterstellung übermittelt. Bei den Schaltern mit mehr als einer Schaltstellung gibt der Wert 0 immer die Grundstellung an. Ein übertragener Wert größer 0 gibt die jeweilige Raste in positive Schaltrichtung an, negative Werte können für die andere Richtung in Frage kommen (z.B. Kombischalter als Fahrschalter mit integrierter dynamischer Bremse)
     * @param message
     * @return
     */
    public ZusiProtocolNodeRoot getInput(ZusiEndpointMessage message){
        ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
        ZusiProtocolNode lastNode = null;

        ZusiProtocolNode client = new ZusiProtocolNode("0200", "");
        ZusiProtocolNode command = new ZusiProtocolNode("0A01", ""); //command input
        ZusiProtocolNode keyboardInput = new ZusiProtocolNode("0100", ""); //keyboard input

        root.addNode(client);
        client.addNode(command);
        command.addNode(keyboardInput);
        lastNode = keyboardInput;

        //Keyboard Commands
        for(String id : message.getGroupIdAsArray()){
            String id1 = message.getParameterList().get(0).getLeft();
            String data1 = message.getParameterList().get(0).getRight();
            String id2 = message.getParameterList().get(1).getLeft();
            String data2 = message.getParameterList().get(1).getRight();
            String id3 = message.getParameterList().get(2).getLeft();
            String data3 = message.getParameterList().get(2).getRight();
            String id4 = message.getParameterList().get(3).getLeft();
            String data4 = message.getParameterList().get(3).getRight();
            String id5 = message.getParameterList().get(4).getLeft();
            String data5 = message.getParameterList().get(4).getRight();

            ZusiProtocolNode zuordnung = new ZusiProtocolNode(id1, data1); //2 Byte
            ZusiProtocolNode kommando = new ZusiProtocolNode(id2, data2); //2 Byte
            ZusiProtocolNode aktion = new ZusiProtocolNode(id3, data3); //2 Byte
            ZusiProtocolNode schalterposition = new ZusiProtocolNode(id4, data4); //4 Byte
            ZusiProtocolNode spezielleFunktion = new ZusiProtocolNode(id5, data5); //2 Byte

            lastNode.addNode(zuordnung);
            lastNode.addNode(kommando);
            lastNode.addNode(aktion);
            lastNode.addNode(schalterposition);
            lastNode.addNode(spezielleFunktion);
        }

        return root;
    }
}
