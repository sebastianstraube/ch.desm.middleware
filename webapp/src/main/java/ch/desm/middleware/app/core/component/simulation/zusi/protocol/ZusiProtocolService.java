package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiEndpointTcpClient;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.websocket.EncodeException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiProtocolService {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);
    private static final String NODE_END = "FFFFFFFF";
    private static final String NODE_START = "00000000";

    public ZusiProtocolService(){
    }

    /**
     *
     * @param message
     * @return
     */
    private NodeBase encode(String message) throws Exception{

        NodeBase root = new NodeBase();
        Node lastNode = null;

        while(!message.isEmpty()){
            if(message.length() <= 12){
                throw new Exception("wrong format of message: " + message);
            }

            String startNode = "";
            String endNode = "";
            String id = "";
            int dataBytes = 0;

            startNode = message.substring(0, 8);
            id= message.substring(8, 12);
            endNode = message.substring(message.length()-8, message.length());

            String startNodeSwapped = UtilConvertingHex.swapEndian(startNode);
            String idSwapped = UtilConvertingHex.swapEndian(id);
            String hexData = "";
            int anzBytes = 0;
            int idValue = 0;
            try {
                anzBytes = Integer.valueOf(startNodeSwapped, 16);
                idValue = Integer.valueOf(idSwapped, 16);
            } catch (NumberFormatException e) {
                return null;
            }
            //if start node 00000000
            if(startNode.equalsIgnoreCase(NODE_START)){
                //start node is not set
                if(lastNode == null){
                    lastNode = new Node(idValue, hexData);
                    root.addNode(lastNode);

                //start node exists
                }else{
                    Node nextNode = new Node(idValue, hexData);
                    lastNode.addNode(nextNode);
                    lastNode = nextNode;
                }

            //if node with id:xxxx or with length xx000000
            }else{
                dataBytes = anzBytes*2 - 4;
                hexData = "";
                try{
                    hexData = message.substring(12, 12+dataBytes);
                } catch(StringIndexOutOfBoundsException e){
                    throw new Exception("message: " + message + " inconsistent with data part:" +dataBytes);
                }

                String dataValue = UtilConvertingHex.getCharStream(hexData);
                Node nextNode = new Node(idValue, dataValue);
                lastNode.addNode(nextNode);
            }

            if(endNode.equalsIgnoreCase(NODE_END) ){
                message = message.substring(12+dataBytes, message.length()-8);
            }else{
                message = message.substring(12+dataBytes, message.length());
            }
        }
        return root;
    }

    /**
     *
     * @param node
     * @return
     */
    private String decode(NodeBase node) throws Exception{

        String messages = "";
        for(Node n : node.nodes){
            String message = getMessage(n);
            int countGroups = countNodes(n, 0);
            for(int i=0; i<countGroups; i++){
                message += NODE_END;
            }
            messages += message;
        }

        return messages.toUpperCase();
    }

    /**
     *
     * @param node
     * @param count
     * @return
     */
    private int countNodes(Node node, int count){
        if(node == null) {
            return count;
        }else if(node.getNrBytes() == 0){
            count++;
        }

        for(Node n : node.nodes){
            count = countNodes(n, count);
        }

        return count;
    }

    /**
     *
     * @param node
     * @return
     */
    private String getMessage(Node node){
        String message = "";

        if(node == null) {
            return message;
        }

        message += UtilConvertingHex.toHex(node.getNrBytes(), 8);
        message += UtilConvertingHex.toHex(node.getId(), 4);
        message += UtilConvertingHex.swapEndian(UtilConvertingHex.toHex(node.getDataAsArray(), 4));

        for(Node n : node.nodes){
            message += getMessage(n);
        }

        return message;
    }

    /**
     *
     * @param message
     * @return
     */
    private NodeBase toNode(String message) throws Exception {
        return encode(message);
    }

    public NodeBase getRoot(String globalId){
        NodeBase root = new NodeBase();
        String tmpId = globalId;
        Node lastNode = null;
        String[] id = globalId.substring(0, globalId.lastIndexOf("::")).split("-");
        String[] parameter = globalId.substring(globalId.lastIndexOf("::")+2, globalId.length()).split(",");

        root = buildRootTree(root, lastNode, id, parameter);

        return root;
    }

    private NodeBase buildRootTree(NodeBase root, Node lastNode, String[] id, String[] parameter){
        for(int i=0; i<id.length; i++){
            Node n = new Node(id[i]);

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
            lastNode = n;
        }

        String[] nrParamerter = Arrays.toString(parameter).split(",");

        for(int i=0; i<nrParamerter.length; i++){
            String parameterId = parameter[i].substring(0, parameter[i].lastIndexOf(":"));
            String parameterValue = parameter[i].substring(parameter[i].lastIndexOf(":")+1, parameter[i].length());
            Node n = new Node(Integer.valueOf(parameterId, 16).intValue(), Integer.valueOf(parameterValue, 16).intValue());

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
            lastNode = n;
        }
        return root;
    }

    public String getGlobalId(NodeBase root){

        String id ="";

        for(Node n : root.nodes){
            id += getGlobalId(n, 0);
        }

        return id;
    }

    //2-4::1:DATA
    private String getGlobalId(Node n, int nrParameter){
        String nodeId = "";
        nodeId += n.getIdAsHex();
        if(n.getDataAsArray().length > 0){
            nodeId += ":" + n.getDataAsHex();
        }

        if(!n.nodes.isEmpty()){
            for(Node next : n.nodes) {
                String parChar = "";
                if(next.getDataAsArray().length <= 0) {
                    parChar = "-";
                }else if(next.getDataAsArray().length >= 0){

                    if(nrParameter == 0){
                        parChar="::";
                    }else{
                        parChar = ",";
                    }
                    nrParameter++;
                }
                nodeId += parChar + getGlobalId(next, nrParameter);
            }
        }

        return nodeId;
    }

    /**
     *
     * @param middlewareMessage
     * @return
     */
    public String getZusiStream(String middlewareMessage) throws Exception{
        NodeBase root = null;
        try {
            root = toNode(middlewareMessage);
        } catch (EncodeException e) {
            e.printStackTrace();
        }
        return decode(root);
    }


    /**
     *
     * @param message
     * @return
     */
    public boolean isMessageComplete(String message){

        int cntStartNode = 0;
        int cntEndNode = 0;
        boolean changed = true;
        while((cntStartNode == cntEndNode) && changed == true){

            changed = false;
            if(message.length() < 12){
                return false;
            }

            String startNode = message.substring(0, 8);
            String id = message.substring(8, 12);
            String endNode = message.substring(message.length()-8, message.length());

            message = message.substring(startNode.length(), message.length());
            message = message.substring(id.length(), message.length());
            message = message.substring(0, message.length()-endNode.length());

            if(startNode.equalsIgnoreCase(NODE_START)){
                cntStartNode++;
                changed = true;
            }

            if(endNode.equalsIgnoreCase(NODE_END)){
                cntEndNode++;
                changed = true;
            }
        }

        return (cntStartNode == cntEndNode) && cntStartNode >= 1 && cntEndNode >= 1;
    }

    /**
     *
     * @return
     */
    public String getMessageConnect() throws Exception{
        NodeBase root = new NodeBase();
        Node start = new Node(1); //0
        Node hello = new Node(1); // 0
        Node protokollVersion = new Node(1, "2"); //4
        Node clientType = new Node(2, "2"); //4
        Node text = new Node(3, "Fahrpult"); //10
        Node version = new Node(4, "2.0"); //5

        root.addNode(start);
        start.addNode(hello);
        hello.addNode(protokollVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);

        return decode(root);
    }


    /**
     * Needed Data > Zusi
     * @return
     */
    public String getMessageNeededData() throws Exception{NodeBase root = new NodeBase();
        Node client_fahrpult = new Node(2);
        Node needed_data = new Node(3);
        Node fuehrerstandsAnzeigen = new Node(10); // Führerstandsanzeigen
        Node geschwindigkeit = new Node(1, 1); //Geschwindigkeit
        Node schleudern = new Node(1, 27); // Schleudern

        root.addNode(client_fahrpult);
        client_fahrpult.addNode(needed_data);
        needed_data.addNode(fuehrerstandsAnzeigen);
        fuehrerstandsAnzeigen.addNode(geschwindigkeit);
        fuehrerstandsAnzeigen.addNode(schleudern);

        return decode(root);
    }



    /**
     *
     * @return
     */
    public String getStreamConnect() {
        String message =
                "00000000"+"0100"+"00000000"+"0100"+"04000000"+"0100"+"0200"+"04000000"+"0200"+"0200"+"0A000000"+"0300"+"4661687270756C74"+"05000000"+"0400"+"322E30"+"FFFFFFFF" + "FFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String getStreamNeededData() {
        String message = "00000000"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String testStream1() {
        String message =
                "00000000"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String testStream2() {
        String message =
                "00"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    /**
     *
     * @return ACK_NEEDED Data Befehl akzeptiert
     */
    public String testStream3() {
        String message =
                "00000000020000000000040003000000010000FFFFFFFFFFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String testStreamAck() {
        String message =
                "00000000"+"0200"+"00000000"+"0400"+"03000000"+"0100"+"00"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    public boolean testEncode(String stream){
        NodeBase root = null;
        try {
            root = encode(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        return root != null;
    }

    public boolean testGetGlobalId(String stream){
        NodeBase root = null;
        try {
            root = encode(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        String globalID = getGlobalId(root);
        NodeBase test = getRoot(globalID);
        String globalIdTest = getGlobalId(test);

        return globalID.equals(globalIdTest);
    }

    public boolean testGetRoot(String globalId){
        NodeBase root = null;
        try {
            root = getRoot(globalId);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        String globalID = getGlobalId(root);
        NodeBase test = getRoot(globalID);
        String globalIdTest = getGlobalId(test);

        return globalID.equals(globalIdTest);
    }

    /**
     *
     * @return
     */
    public boolean testEncodeDecode() {

        boolean isGood = false;
        try {
            NodeBase root = encode(getStreamConnect());
            String encodeFromZusi = decode(root);

            NodeBase root2 = new NodeBase();
            Node start = new Node(1);
            Node hello = new Node(1);
            Node protocolVersion = new Node(1, "2");
            Node clientType = new Node(2, "2");
            Node text = new Node(3, "Fahrpult");
            Node version = new Node(4, "2.0");

            root2.addNode(start);
            start.addNode(hello);
            hello.addNode(protocolVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String encodeFromMiddleware = decode(root2);

            if (encodeFromZusi.equals(encodeFromMiddleware)) {
                isGood = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isGood;
    }


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

     * @param idApp
     * @param idCmd
     * @param idKeyboardInput
     * @param parameter
     * @return
     */
    public String commandInput(String idApp, String idCmd, String idKeyboardInput, List<String> parameter) {

        return null;
    }
}
