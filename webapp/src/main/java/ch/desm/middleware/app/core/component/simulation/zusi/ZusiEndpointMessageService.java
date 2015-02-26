package ch.desm.middleware.app.core.component.simulation.zusi;

import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiEndpointMessageService {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private ZusiService service;

    public ZusiEndpointMessageService(ZusiService service){
        this.service = service;
    }

    // listNodes contains message structure
    // one message in listNodes is one message for transfer
    protected class NodeBase {
        protected LinkedList<Node> nodes;

        public NodeBase(){
            nodes = new LinkedList<>();
        }

        public void addNode(Node n){
            nodes.add(n);
        }
    }

    protected class Node extends NodeBase {
        /**
         * id of node
         */
        private Integer id;

        /**
         * nr of hex bytes for en- and decoding e.g. (x0001) has 2 bytes
         */
        private int nrBytes;

        /**
         * data store, represented as int array
         */
        private int[] data;

        public Node(int id){
            this(id, "");
        }

        public Node(int id, String data){
            this.id = id;
            this.data = new int[data.length()];
            for(int i=0; i<data.length();i++){
                this.data[i] = Integer.valueOf(data.charAt(i));
            }
            this.nrBytes = (this.data.length*2) + (data.isEmpty() ? 0 : 2);
        }

        public Node(String hexId, String data){
            String idSwapped = getSwappedEndian(hexId);
            int id = Integer.valueOf(idSwapped, 16);
            this.data = new int[data.length()];
            for(int i=0; i<data.length();i++){
                this.data[i] = Integer.valueOf(data.charAt(i));
            }
            this.nrBytes = (this.data.length*2) + (data.isEmpty() ? 0 : 2);
        }

        public Node(int id, int data){
            this.id = id;
            this.data = getArray(data);
            this.nrBytes = (this.data.length*2) + (data==0 ? 0 : 2);
        }

        private int[] getArray(int data){
            int[] a = new int[1];
            a[0] = data;

            return a;
        }
    }

    private NodeBase encodeMessage(String message) throws Exception {

        NodeBase root = new NodeBase();
        Node lastGroupNode = null;

        while(!message.isEmpty()){

            String node = "";
            String id = "";
            int dataBytes = 0;

            if(message.length() >= 8){
                node = message.substring(0, 8);
            }
            if(message.length() >= 12){
                id= message.substring(8, 12);
            }

            if(!isNodeEnd(node)){
                String nodeSwapped = getSwappedEndian(node);
                String idSwapped = getSwappedEndian(id);
                String data = "";

                int anzBytes = Integer.valueOf(nodeSwapped, 16);
                int idValue = Integer.valueOf(idSwapped, 16);

                //if start node 00000000
                if(anzBytes == 0 ){

                    //start node is not set
                    if(lastGroupNode == null){
                        lastGroupNode = new Node(idValue, data);
                        root.addNode(lastGroupNode);

                    //start node exists
                    }else{
                        Node nextNode = new Node(idValue, data);
                        lastGroupNode.addNode(nextNode);
                        lastGroupNode = nextNode;
                    }

                //if node with id:xxxx or with length xx000000
                }else{
                    dataBytes = anzBytes*2 - 4;
                    data = message.substring(12, 12+dataBytes);
                    String dataValue = getStream(data);
                    Node nextNode = new Node(idValue, dataValue);
                    lastGroupNode.addNode(nextNode);
                }

                message = message.substring(12+dataBytes, message.length());
            }else{
                message = message.substring(8, message.length());
            }
        }

        return root;
    }

    public String decodeMessage(NodeBase node){

        String messages = "";
        for(Node n : node.nodes){
            String message = buildEncodedMessage(n);
            int countGroups = getGroupNodesCount(n, 0);
            for(int i=0; i<countGroups; i++){
                message += "FFFFFFFF";
            }
            messages += message;
        }

        return messages.toUpperCase();
    }

    public LinkedList<String> convertToMiddlewareMessage(String stream) throws Exception {
        NodeBase root = encodeMessage(stream);
        return convertToMiddlewareMessage(root);
    }

    public String convertToZusiStream(String middlewareMessage) {
        NodeBase root = convertToObject(middlewareMessage);
        return decodeMessage(root);
    }

    /**
     *
     * @param root
     * @return
     */
    private LinkedList<String> convertToMiddlewareMessage(NodeBase root){
        LinkedList<String> middlewareMessage = new LinkedList<>();
        //TODO conversion to Middleware global ID
        //looking in Map for ID
        LinkedList<String> id = convertObjectToMiddlewareId(root);

        return middlewareMessage;
    }

    /**
     *
     * @param middlewareMessage
     * @return
     */
    private NodeBase convertToObject(String middlewareMessage){
        NodeBase root = new NodeBase();

        //TODO algorithm to investigate middlewareMessage structure

        return root;
    }

    private LinkedList<String> convertObjectToMiddlewareId(NodeBase root){
        LinkedList<String> idList = new LinkedList<>();

        //TODO algithmus to extract middleware ID

        return idList;
    }

    protected int getGroupNodesCount(Node node, int count){
        if(node == null) {
            return count;
        }else if(node.nrBytes == 0){
            count++;
        }

        for(Node n : node.nodes){
            count = getGroupNodesCount(n, count);
        }

        return count;
    }

    protected String buildEncodedMessage(Node node){
        String message = "";

        if(node == null) {
            return message;
        }

        message += getStream(node.nrBytes, 8);
        message += getStream(node.id, 4);
        message += getStream(node.data);

        for(Node n : node.nodes){
            message += buildEncodedMessage(n);
        }

        return message;
    }

    protected boolean isNodeEnd(String s){
        if( Long.valueOf(s, 16) == Long.valueOf("FFFFFFFF", 16)){
            return true;
        }

        return false;
    }

    protected String getStream(int[] data){
        String hex = "";

        if(!(data.length == 0)){

            for(int i=0; i<data.length; i++){
                int code = data[i];
                String hexVal = Integer.toHexString(code);
                hex += expandHexString(hexVal, 4);
            }
        }

        return getSwappedEndian(hex);
    }


    protected String getStream(String hexStream){
        String s = "";
        if(!hexStream.isEmpty()){
            if(hexStream.length() == 4){
                hexStream = getSwappedEndian(hexStream);
                s = String.valueOf(Integer.valueOf(hexStream, 16));
            }else{
                String hexCode = "";
                for(int i=0; i<hexStream.length(); i+=2){
                    hexCode = "" + hexStream.charAt(i) + hexStream.charAt(i+1);
                    int code = Integer.valueOf(hexCode, 16);
                    s += (char)code;
                }
            }
        }

        return s;
    }

    protected String getStream(int i, int length){
        String hex = "";
        hex += Integer.toHexString(i);
        hex = expandHexString(hex, length);

        return getSwappedEndian(hex);
    }

    protected String expandHexString(String hex, int length){
        while(hex.length() < length){
            hex = "0" + hex;
        }

        return hex;
    }

    protected String getSwappedEndian(String s){
        String swapped = "";
        String bytes = "";
        int upperBound = s.length()-1;
        for(int i=upperBound; i>= 0; i--){
            bytes = s.charAt(i) + bytes;
            if((i%2 == 0) && ( i!= upperBound)){
                swapped += bytes;
                bytes = "";
            }
        }

        return swapped;
    }

    public String getMessageConnect(){
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

        return decodeMessage(root);
    }

    public String getMessageStreamConnect() {
        String test =
                "00000000" +
                        "0100" +
                        "00000000" +
                        "0100" +
                        "04000000" +
                        "0100" +
                        "0200" +
                        "04000000" +
                        "0200" +
                        "0200" +
                        "0A000000" +
                        "0300" +
                        "4661687270756C74" +
                        "05000000" +
                        "0400" +
                        "322E30" +
                        "FFFFFFFF" +
                        "FFFFFFFF";
        return test;
    }

    public String getMessageStreamNeededData() {
        String test =
                "00000000" +
                        "0200" +
                        "00000000" +
                        "0300" +
                        "00000000" +
                        "0A00" +
                        "04000000" +
                        "0100" +
                        "0100" +
                        "04000000" +
                        "0100" +
                        "1B00" +
                        "FFFFFFFF" +
                        "FFFFFFFF" +
                        "FFFFFFFF";
        return test;
    }

    /**
     * Needed Data > Zusi
     * @return
     */
    public String getMessageNeededData(){
        String encode = "";

        try {
            NodeBase root = new NodeBase();
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

            encode = decodeMessage(root);

            String messageStream = getMessageStreamNeededData();
            if(!encode.equals(messageStream)){
                throw new Exception("wrong encoding");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encode;
    }

    public boolean testEncodeDecode(){

        boolean isGood = false;
        try {
            NodeBase root = encodeMessage(getMessageStreamConnect());
            String encodeFromZusi = decodeMessage(root);

            NodeBase root2 = new NodeBase();
            Node start = new Node(1);
            Node hello = new Node(1);
            Node protokollVersion = new Node(1, "2");
            Node clientType = new Node(2, "2");
            Node text = new Node(3, "Fahrpult");
            Node version = new Node(4, "2.0");

            root2.addNode(start);
            start.addNode(hello);
            hello.addNode(protokollVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String encodeFromMiddleware = decodeMessage(root2);

            if(encodeFromZusi.equals(encodeFromMiddleware)){
                isGood = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isGood;
    }

}
