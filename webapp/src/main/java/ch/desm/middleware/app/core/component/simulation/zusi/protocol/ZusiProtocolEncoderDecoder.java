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
    public String encode(ZusiProtocolNode node){
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
     * @param stream
     * @return
     * @throws Exception
     */
    public ZusiProtocolNodeBase encode(String stream) throws Exception {
        ZusiProtocolNodeBase root = processNodeStartEnd(stream);

        return root;
    }

    /**
     *
     * @param node
     * @return
     * @throws Exception
     */
    public String decode(ZusiProtocolNodeBase node) throws Exception{

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
     * @param stream is a hex stream with zusi data format
     * @return a node object of the representing stream
     * @throws Exception
     */
    private ZusiProtocolNodeBase processNodeStartEnd(String stream) throws Exception {

        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        try {
            ZusiProtocolNode nodeLast = null;

            //stream is empty when the whole stream is decoded
            while (!stream.isEmpty()) {
                // has start node
                if (stream.startsWith("00000000")) {

                    String id = stream.substring(8, 12);
                    String idSwapped = UtilConvertingHex.swapEndian(id);
                    int idValue = Integer.valueOf(idSwapped, 16);
                    ZusiProtocolNode nodeNext = new ZusiProtocolNode(idValue);
                    //if there is no existing node
                    if (nodeLast == null) {
                        nodeLast = nodeNext;
                        root.addNode(nodeLast);
                    } else {
                        nodeLast.addNode(nodeNext);
                        nodeLast = nodeNext;
                    }
                    stream = stream.substring(12);
                }
                // is there is an end node, remove and go further
                else if (stream.toUpperCase().startsWith("FFFFFFFF")) {
                    stream = stream.substring(8);
                }
                // has id node
                else {
                    nodeLast.addNode(processParameter(stream));
                    //process parameter and come back when start or end nodes not found
                    //startNode.length() + id.length() + hexData.length()
                    stream = stream.substring(8 + 4 + getData(stream).length());
                }

            }
        } catch(StringIndexOutOfBoundsException e){
            throw new Exception("inconsistent message: " + stream);
        } catch (NumberFormatException e) {
            throw new Exception("parse error with message: " + stream);
        }
        return root;
    }

    private ZusiProtocolNode processParameter(String stream){
        ZusiProtocolNode node = new ZusiProtocolNode(getIdValue(stream), getDataValue(stream));
        return node;
    }

    /**
     *
     * @param stream
     * @return
     */
    private String getDataValue(String stream){
        String dataValue = UtilConvertingHex.getCharStream(getData(stream));
        return dataValue;
    }

    /**
     *
     * @param stream
     * @return
     */
    private String getData(String stream) {
        String hexData = stream.substring(12, 12 + getNrDataBytes(stream));
        return hexData;
    }

    /**
     *
     * @param stream
     * @return
     */
    private int getNrDataBytes(String stream){
        int dataBytes = getNrBytes(stream) * 2 - 4;
        return dataBytes;
    }

    /**
     *
     * @param stream
     * @return
     */
    private int getNrBytes(String stream){
        String node = stream.substring(0, 8);
        String nodeSwap = UtilConvertingHex.swapEndian(node);
        int nrBytes = Integer.valueOf(nodeSwap, 16);

        return nrBytes;
    }

    /**
     *
     * @param stream
     * @return
     */
    private int getIdValue(String stream){
        String id = stream.substring(8, 12);
        String idSwapped = UtilConvertingHex.swapEndian(id);
        int idValue = Integer.valueOf(idSwapped, 16);

        return idValue;
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
