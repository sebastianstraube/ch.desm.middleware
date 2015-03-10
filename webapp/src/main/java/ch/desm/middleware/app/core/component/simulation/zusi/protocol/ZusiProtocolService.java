package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiProtocolService {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolService.class);
    protected static final String NODE_END = "FFFFFFFF";
    protected static final String NODE_START = "00000000";
    protected static final String CLIENT_TYPE = "DESM-Middleware";
    protected static final String CLIENT_VERSION = "1.0";

    /**
     *
     * @param hexMessage
     * @return
     */
    protected ZusiProtocolNodeBase encode(String hexMessage) throws Exception{

        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode lastNode = null;

        while(!hexMessage.isEmpty()){
            if(hexMessage.length() <= 12){
                throw new Exception("wrong format of message: " + hexMessage);
            }

            String startNode = "";
            String endNode = "";
            String id = "";
            int dataBytes = 0;

            startNode = hexMessage.substring(0, 8);
            id= hexMessage.substring(8, 12);
            endNode = hexMessage.substring(hexMessage.length()-8, hexMessage.length());

            String startNodeSwapped = UtilConvertingHex.swapEndian(startNode);
            String idSwapped = UtilConvertingHex.swapEndian(id);
            String hexData = "";
            int nrBytes = 0;
            int idValue = 0;
            try {
                nrBytes = Integer.valueOf(startNodeSwapped, 16);
                idValue = Integer.valueOf(idSwapped, 16);
            } catch (NumberFormatException e) {
                return null;
            }
            //if start node 00000000
            if(startNode.equalsIgnoreCase(NODE_START)){
                //start node is not set
                if(lastNode == null){
                    lastNode = new ZusiProtocolNode(idValue, hexData);
                    root.addNode(lastNode);

                //start node exists
                }else{
                    ZusiProtocolNode nextNode = new ZusiProtocolNode(idValue, hexData);
                    lastNode.addNode(nextNode);
                    lastNode = nextNode;
                }

            //if node with id:xxxx or with length xx000000
            }else{
                dataBytes = nrBytes*2 - 4;
                hexData = "";
                try{
                    hexData = hexMessage.substring(12, 12+dataBytes);
                } catch(StringIndexOutOfBoundsException e){
                    throw new Exception("message: " + hexMessage + " inconsistent with data part:" +dataBytes);
                }

                String dataValue = UtilConvertingHex.getCharStream(hexData);
                ZusiProtocolNode nextNode = new ZusiProtocolNode(idValue, dataValue);
                lastNode.addNode(nextNode);
            }

            if(endNode.equalsIgnoreCase(NODE_END) ){
                hexMessage = hexMessage.substring(12+dataBytes, hexMessage.length()-8);
            }else{
                hexMessage = hexMessage.substring(12+dataBytes, hexMessage.length());
            }
        }
        return root;
    }

    /**
     *
     * @param node
     * @return
     */
    protected String decode(ZusiProtocolNodeBase node) throws Exception{

        String messages = "";
        for(ZusiProtocolNode n : node.nodes){
            String message = getStream(n);
            int countGroups = countNodes(n, 0);
            for(int i=0; i<countGroups; i++){
                message += NODE_END;
            }
            messages += message.toUpperCase();
        }

        return messages.toUpperCase();
    }

    /**
     *
     * @param node
     * @param count
     * @return
     */
    protected int countNodes(ZusiProtocolNode node, int count){
        if(node == null) {
            return count;
        }else if(node.getNrBytes() == 0){
            count++;
        }

        for(ZusiProtocolNode n : node.nodes){
            count = countNodes(n, count);
        }

        return count;
    }

    /**
     *
     * @param node
     * @return
     */
    protected String getStream(ZusiProtocolNode node){
        String message = "";

        if(node == null) {
            return message;
        }

        message += UtilConvertingHex.swapEndian(UtilConvertingHex.toHex(node.getNrBytes(), 8));
        message += UtilConvertingHex.swapEndian(UtilConvertingHex.toHex(node.getId(), 4));

        //only character data
        if(node.getDataAsArray().length > 1){
            message += UtilConvertingHex.toHex(node.getDataAsArray(), 2);
        //decimal data
        }else{
            int[] dataArray = node.getDataAsArray();
            message += UtilConvertingHex.swapEndian(UtilConvertingHex.toHex(dataArray, 4));
        }

        for(ZusiProtocolNode n : node.nodes){
            message += getStream(n);
        }

        return message;
    }

    /**
     *
     * @param message
     * @return
     */
    protected ZusiProtocolNodeBase toNode(String message) throws Exception {
        return encode(message);
    }

    /**
     *
     * @param hexMessage
     * @return
     * @throws Exception
     */
    public String getGlobalId(String hexMessage) throws Exception{
        return getGlobalId(encode(hexMessage));
    }

    /**
     *
     * @param globalId
     * @return
     */
    protected ZusiProtocolNodeBase getRoot(String globalId){
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        String tmpId = globalId;
        ZusiProtocolNode lastNode = null;
        String[] id = globalId.substring(0, globalId.lastIndexOf("::")).split("-");
        String[] parameter = globalId.substring(globalId.lastIndexOf("::")+2, globalId.length()).split(",");

        root = buildRootTree(root, lastNode, id, parameter);

        return root;
    }

    /**
     *
     * @param root
     * @param lastNode
     * @param id
     * @param parameter
     * @return
     */
    protected ZusiProtocolNodeBase buildRootTree(ZusiProtocolNodeBase root, ZusiProtocolNode lastNode, String[] id, String[] parameter){
        for(int i=0; i<id.length; i++){
            ZusiProtocolNode n = new ZusiProtocolNode(id[i]);

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
            ZusiProtocolNode n = new ZusiProtocolNode(Integer.valueOf(parameterId, 16).intValue(), Integer.valueOf(parameterValue, 16).intValue());

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
            lastNode = n;
        }
        return root;
    }

    /**
     *
     * @param root
     * @return
     */
    public String getGlobalId(ZusiProtocolNodeBase root){

        String id ="";

        for(ZusiProtocolNode n : root.nodes){
            id += getGlobalId(n, 0);
        }

        return id;
    }

    /**
     *
     * e.g. 2-4::1:DATA
     *
     * @param n
     * @param nrParameter
     * @return
     */
    protected String getGlobalId(ZusiProtocolNode n, int nrParameter){
        String nodeId = "";
        nodeId += n.getIdAsHex();
        if(n.getDataAsArray().length > 0){
            nodeId += ":" + n.getDataAsHex();
        }

        if(!n.nodes.isEmpty()){
            for(ZusiProtocolNode next : n.nodes) {
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
     * @param message
     * @return
     */
    public boolean isMessageComplete(String message){
        return getSingleZusiMessageIndex(message) <= 0? false : true;
    }

    /**
     *
     * @param message
     * @return
     */
    public String extractSingleZusiMessage(String message){
        int index = getSingleZusiMessageIndex(message);
        String s;
        if(index <= 0) {
            s = "";
        }else{
            s = message.substring(0, index);
        }

        return s;
    }

    /**
     * e.g. 00000000020000000000040003000000010000ffffffffffffffff000000000200000000000a00ffffffffffffffff000000000200000000000a0006000000010000000000060000001b0000000000ffffffffffffffff
     * @param message
     * @return
     */
    protected int getSingleZusiMessageIndex(String message){
        int length = 0;
        int cntStartNode = 0;
        int cntEndNode = 0;
        boolean isValid = false;
        if(message.length() >= 50){

            while(!isValid){

                if(message.length() < 8){
                    length = -1;
                    break;
                }

                int nodeLength = 8;
                int dataLength = 4;
                String node = message.substring(0, nodeLength);
                String nodeSwapped = UtilConvertingHex.swapEndian(node);

                //if start node
                if(node.equalsIgnoreCase("00000000")){
                    cntStartNode++;
                //if data node
                }else if(node.equalsIgnoreCase("FFFFFFFF")){
                    cntEndNode++;
                    dataLength = 0;
                }else{
                    int val = Integer.valueOf(nodeSwapped, 16);
                    dataLength = val*2;
                }

                int partLength = nodeLength+dataLength;
                if(cntStartNode == cntEndNode){
                    isValid = true;
                }else{
                    message = message.substring(partLength, message.length());
                }

                length+=partLength;
            }
        }

        return length;
    }

    /**
     *
     * @return
     */
    public String getMessageConnectFahrpult() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode start = new ZusiProtocolNode(1);
        ZusiProtocolNode hello = new ZusiProtocolNode(1);
        ZusiProtocolNode protocolVersion = new ZusiProtocolNode(1, 2);
        ZusiProtocolNode clientType = new ZusiProtocolNode(2, 2);
        ZusiProtocolNode text = new ZusiProtocolNode(3, CLIENT_TYPE + "(Fahrpult)");
        ZusiProtocolNode version = new ZusiProtocolNode(4, CLIENT_VERSION);

        root.addNode(start);
        start.addNode(hello);
        hello.addNode(protocolVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);

        return decode(root);
    }

    /**
     * Needed Data > Zusi
     * @return
     */
    public String getMessageNeededDataFahrpult() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode client_fahrpult = new ZusiProtocolNode(2);
        ZusiProtocolNode needed_data = new ZusiProtocolNode(3);
        ZusiProtocolNode fuehrerstandsAnzeigen = new ZusiProtocolNode(10);
        ZusiProtocolNode geschwindigkeit = new ZusiProtocolNode(1, 1);

        root.addNode(client_fahrpult);
        client_fahrpult.addNode(needed_data);
        needed_data.addNode(fuehrerstandsAnzeigen);
        fuehrerstandsAnzeigen.addNode(geschwindigkeit);

        return decode(root);
    }


    /**
     *
     * @return
     */
    public String getMessageConnectAusbildung() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode start = new ZusiProtocolNode(1);
        ZusiProtocolNode hello = new ZusiProtocolNode(1);
        ZusiProtocolNode protocolVersion = new ZusiProtocolNode(1, 2);
        ZusiProtocolNode clientType = new ZusiProtocolNode(2, 3);
        ZusiProtocolNode text = new ZusiProtocolNode(3, CLIENT_TYPE + "(Ausbildung)");
        ZusiProtocolNode version = new ZusiProtocolNode(4, CLIENT_VERSION);

        root.addNode(start);
        start.addNode(hello);
        hello.addNode(protocolVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);


        return decode(root);
    }

    public String getMessageNeededDataAusbildung() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode client_ausbilder = new ZusiProtocolNode(3);
        ZusiProtocolNode needed_data = new ZusiProtocolNode(3);
        ZusiProtocolNode trainpos = new ZusiProtocolNode(1);
        trainpos.setData(ZusiProtocolAusbildungssteuerung.COMMAND_FROM_TRAINPOS);

        root.addNode(client_ausbilder);
        client_ausbilder.addNode(needed_data);
        needed_data.addNode(trainpos);

        return decode(root);
    }
}
