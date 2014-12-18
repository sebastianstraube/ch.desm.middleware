package ch.desm.middleware.app.core.component.simulation.zusi;

import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiEndpointMessageService {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    // listNodes contains message structure
    // one message in listNodes is one message for transfer
    public class NodeBase {
        protected LinkedList<Node> nodes;

        public NodeBase(){
            nodes = new LinkedList<>();
        }

        public void addNode(Node n){
            nodes.add(n);
        }
    }

    public class Node extends NodeBase {
        private Integer id;
        private int byteCounter;
        private String data;

        public Node(int id, int byteCounter){
            this(id, byteCounter, "");
        }

        public Node(int id, int byteCounter, String data){
            super();
            this.id = id;
            this.byteCounter = byteCounter;
            this.data = data;
        }

        public void setId(Integer id){
            this.id = id;
        }

        public void setData(String data){
            this.data = data;
        }
    }

    public NodeBase decodeMessage(String message) throws Exception {

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
                String nodeSwapped = swapEndian(node);
                String idSwapped = swapEndian(id);
                String data = "";

                int nodeValue = Integer.valueOf(nodeSwapped, 16);
                int idValue = Integer.valueOf(idSwapped, 16);

                //if start node 00000000
                if(nodeValue == 0 ){

                    //start node is not set
                    if(lastGroupNode == null){
                        lastGroupNode = new Node(idValue, nodeValue, data);
                        root.addNode(lastGroupNode);

                    //start node exists
                    }else{
                        Node nextNode = new Node(idValue, nodeValue, data);
                        lastGroupNode.addNode(nextNode);
                        lastGroupNode = nextNode;
                    }

                //if node with id:xxxx or with length xx000000
                }else{
                    dataBytes = nodeValue*2 - 4;
                    data = message.substring(12, 12+dataBytes);
                    String dataValue = getDataCharStream(data);
                    Node nextNode = new Node(idValue, nodeValue, dataValue);
                    lastGroupNode.addNode(nextNode);
                }

                message = message.substring(12+dataBytes, message.length());
            }else{
                message = message.substring(8, message.length());
            }
        }

        return root;
    }

    public String encodeMessage(NodeBase node){

        String messages = "";
        for(Node n : node.nodes){
            String message = buildEncodedMessage(n);
            int countGroups = lookupGroupNodes(n, 0);
            for(int i=0; i<countGroups; i++){
                message += "FFFFFFFF";
            }
            messages += message;
        }

        return messages.toUpperCase();
    }

    protected int lookupGroupNodes(Node node, int count){

        if(node == null) {
            return count;
        }

        if(node.byteCounter == 0){
            count++;
        }

        for(Node n : node.nodes){
            count = lookupGroupNodes(n, count);
        }

        return count;
    }

    protected String buildEncodedMessage(Node node){
        String message = "";

        if(node == null) {
            return message;
        }

        message += getStream(node.byteCounter, 8);
        message += getStream(node.id, 4);
        message += getDataHexStream(node.data);

        for(Node n : node.nodes){
            message += buildEncodedMessage(n);
        }

        return message;
    }

    protected boolean isNodeEnd(String s){
        long i = Long.valueOf(s, 16);
        long v = Long.valueOf("FFFFFFFF", 16);
        if( i == v){
            return true;
        }

        return false;
    }

    protected String getDataHexStream(String data){
        String hex = "";

        if(!data.isEmpty()){
            char[] array = data.toCharArray();

            for(int i=0; i<array.length; i++){
                int code = (int)data.charAt(i);
                String hexVal = Integer.toHexString(code);
                hex += expandHexString(hexVal, 2);
            }
        }

        return hex;
    }


    protected String getDataCharStream(String hexStream){
        String s = "";
        if(!hexStream.isEmpty()){
            if(hexStream.length() == 4){
                hexStream = swapEndian(hexStream);
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

        return swapEndian(hex);
    }

    protected String expandHexString(String hex, int length){
        while(hex.length() < length){
            hex = "0" + hex;
        }

        return hex;
    }

    protected String swapEndian(String s){
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

    public String getConnectMessageStream(){
        NodeBase root = new NodeBase();
        Node start = new Node(1, 0);
        Node hello = new Node(1, 0);
        Node protokollVersion = new Node(1, 4, "2");
        Node clientType = new Node(2, 4, "2");
        Node text = new Node(3, 10, "Fahrpult");
        Node version = new Node(4, 5, "2.0");

        root.addNode(start);
        start.addNode(hello);
        hello.addNode(protokollVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);

        return encodeMessage(root);
    }

    public String getConnectMessageStreamTest() {
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

    public void testEncodeDecode(){

        try {
            NodeBase root = decodeMessage(getConnectMessageStreamTest());
            String encodeFromZusi = encodeMessage(root);

            NodeBase root2 = new NodeBase();
            Node start = new Node(1, 0);
            Node hello = new Node(1, 0);
            Node protokollVersion = new Node(1, 4, "2");
            Node clientType = new Node(2, 4, "2");
            Node text = new Node(3, 10, "Fahrpult");
            Node version = new Node(4, 5, "2.0");

            root2.addNode(start);
            start.addNode(hello);
            hello.addNode(protokollVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String encodeFromMiddleware = encodeMessage(root2);

            if(encodeFromZusi.equals(encodeFromMiddleware)){
                boolean good = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
