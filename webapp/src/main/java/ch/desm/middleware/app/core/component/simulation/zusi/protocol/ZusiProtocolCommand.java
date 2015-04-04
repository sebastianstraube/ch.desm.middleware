package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiProtocolMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeBase;
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
        ZusiProtocolNodeBase root = service.getProtocolNodeProcessor().getRoot(globalId);
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
        ZusiProtocolNodeBase root = service.getProtocolNodeProcessor().getRoot(globalId);
        String stream = service.getEncoder().encode(root);
        return stream;
    }

    /**
     *
     * @param message
     * @return
     */
    public ZusiProtocolNodeBase getInput(ZusiProtocolMessage message){
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode lastNode = null;

        ZusiProtocolNode client = new ZusiProtocolNode(2);
        ZusiProtocolNode command = new ZusiProtocolNode(266); //command input
        ZusiProtocolNode keyboardInput = new ZusiProtocolNode(1); //keyboard input

        root.addNode(client);
        client.addNode(command);
        command.addNode(keyboardInput);
        lastNode = keyboardInput;

        //Keyboard Commands
        for(String id : message.getGroupIdAsArray()){
            int id1 = Integer.valueOf(message.getParameterList().get(0).getLeft());
            int data1 = Integer.valueOf(message.getParameterList().get(0).getRight());
            int id2 = Integer.valueOf(message.getParameterList().get(1).getLeft());
            int data2 = Integer.valueOf(message.getParameterList().get(1).getRight());
            int id3 = Integer.valueOf(message.getParameterList().get(2).getLeft());
            int data3 = Integer.valueOf(message.getParameterList().get(2).getRight());
            int id4 = Integer.valueOf(message.getParameterList().get(3).getLeft());
            int data4 = Integer.valueOf(message.getParameterList().get(3).getRight());
            int id5 = Integer.valueOf(message.getParameterList().get(4).getLeft());
            int data5 = Integer.valueOf(message.getParameterList().get(4).getRight());

            ZusiProtocolNode zuordnung = new ZusiProtocolNode(id1, data1, 2); //2 Byte
            ZusiProtocolNode kommando = new ZusiProtocolNode(id2, data2, 2); //2 Byte
            ZusiProtocolNode aktion= new ZusiProtocolNode(id3, data3, 2); //2 Byte
            ZusiProtocolNode schalterposition = new ZusiProtocolNode(id4, data4, 2);//2byte
            ZusiProtocolNode spezielleFunktion = new ZusiProtocolNode(id5, data5, 4);//4byte

            lastNode.addNode(zuordnung);
            lastNode.addNode(kommando);
            lastNode.addNode(aktion);
            lastNode.addNode(schalterposition);
            lastNode.addNode(spezielleFunktion);
        }

        return root;
    }
}
