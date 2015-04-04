package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilityConvertingHex;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeBase;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolUtilDecoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolUtilDecoder.class);

    private String getHexData(ZusiProtocolNode node){
        int[] dataArray = node.getDataArray();
        String hexData = "";
        //only character data
        if (dataArray.length > 1) {
            hexData = UtilityConvertingHex.toHex(dataArray, 2);
            if (!node.isDataStream()) {
                hexData = UtilityConvertingHex.swapEndian(hexData);
            }
        }
        //decimal data
        else {
            int nrBytes = dataArray.length <= 1 ? 2 : 4;
            hexData = UtilityConvertingHex.toHex(dataArray, nrBytes);
        }

        return hexData;
    }

    private String getNodeStream(boolean encap, ZusiProtocolNode node){
        String stream ="";
        int idByteLength = node.isStartNode() ? 0 : 2;

        if(node.isStartNode() && encap){
            stream += "FFFFFFFF";
        }

        stream += UtilityConvertingHex.swapEndian(UtilityConvertingHex.toHex(node.getNrBytes() + idByteLength, 8));
        stream += UtilityConvertingHex.swapEndian(UtilityConvertingHex.toHex(node.getId(), 4));
        stream += getHexData(node);
        stream += "#";

        if(node.isStartNode() && !encap){
            stream += "FFFFFFFF";
        }

        return stream;
    }

    /**
     *
     * @param stream
     * @return
     * @throws Exception
     */
    public ZusiProtocolNodeBase decode(String stream) throws Exception {
        ZusiProtocolNodeBase root = decodeStream(stream);

        return root;
    }

    /**
     *
     * @param stream is a hex stream with zusi data format
     * @return a node object of the representing stream
     * @throws Exception
     */
    private ZusiProtocolNodeBase decodeStream(String stream) throws Exception {

        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        try {
            ZusiProtocolNode nodeLast = null;

            //stream is empty when the whole stream is decoded
            while (!stream.isEmpty()) {
                // has start node
                if (stream.startsWith("00000000")) {

                    String id = stream.substring(8, 12);
                    String idSwapped = UtilityConvertingHex.swapEndian(id);
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
        String dataValue = UtilityConvertingHex.getCharStream(getData(stream));
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
        String nodeSwap = UtilityConvertingHex.swapEndian(node);
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
        String idSwapped = UtilityConvertingHex.swapEndian(id);
        int idValue = Integer.valueOf(idSwapped, 16);

        return idValue;
    }

}
