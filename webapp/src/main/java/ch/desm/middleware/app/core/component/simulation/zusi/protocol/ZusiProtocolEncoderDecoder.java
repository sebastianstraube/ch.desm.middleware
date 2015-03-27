package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolEncoderDecoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolEncoderDecoder.class);

    /**
     *
     * @param node
     * @return
     */
    protected String encode(ZusiProtocolNode node){
        String message = "";
        int idByteLength = 0;
        if(node == null) {
            return message;
        }


        if(node.getNrBytes() > 0){
            idByteLength = 2;
        }
        message += UtilConvertingHex.swapEndian(UtilConvertingHex.toHex(node.getNrBytes() + idByteLength, 8));
        message += UtilConvertingHex.swapEndian(UtilConvertingHex.toHex(node.getId(), 4));

        int[] dataArray = node.getDataArray();
        //only character data
        if(dataArray.length > 1){
            String hexData = UtilConvertingHex.toHex(dataArray, 2);
            if(!node.isDataStream()){
                hexData = UtilConvertingHex.swapEndian(hexData);
            }
            message += hexData;

            //decimal data
        }else{
            String hexData = UtilConvertingHex.toHex(dataArray, 4);
            message += hexData;
        }

        for(ZusiProtocolNode n : node.nodes){
            message += encode(n);
        }

        return message;
    }

    /**
     *
     * @param hexMessage
     * @return
     */
    protected ZusiProtocolNodeBase encode(String hexMessage) throws Exception{

        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode lastNode = null;

        while(!hexMessage.isEmpty()){
            if(hexMessage.length() < 14){
                throw new Exception("wrong format of message: " + hexMessage);
            }
            try {
                String startNode = hexMessage.substring(0, 8);
                String startNodeSwapped = UtilConvertingHex.swapEndian(startNode);
                String id = hexMessage.substring(8, 12);
                String idSwapped = UtilConvertingHex.swapEndian(id);
                String endNode = hexMessage.substring(hexMessage.length() - 8, hexMessage.length());
                String hexData = "";

                int dataBytes = 0;
                int nrBytes = Integer.valueOf(startNodeSwapped, 16);
                int idValue = Integer.valueOf(idSwapped, 16);

                //if there is no data length, then add id data length
                if(nrBytes == 0){
                    nrBytes = 2;
                }
                //if start node 00000000
                if(startNode.equalsIgnoreCase(ZusiProtocolConstants.NODE_START)){
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

                if(endNode.equalsIgnoreCase(ZusiProtocolConstants.NODE_END) ){
                    hexMessage = hexMessage.substring(12+dataBytes, hexMessage.length()-8);
                }else{
                    hexMessage = hexMessage.substring(12+dataBytes, hexMessage.length());
                }

            } catch (NumberFormatException e) {
                throw new Exception("parse error with message: " + hexMessage);
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
            String message = encode(n);
            int countGroups = countNodes(n, 0);
            for(int i=0; i<countGroups; i++){
                message += ZusiProtocolConstants.NODE_END;
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
    private int countNodes(ZusiProtocolNode node, int count){
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
}
