package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilityConvertingHex;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeBase;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolUtilEncoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolUtilEncoder.class);

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

    private String getBakedStream(ZusiProtocolNode node, boolean encap, String stream){
        String part = getNodeStream(encap, node);
        stream = stream.replace("#", part);

        return stream;
    }

    private String recurEncode(boolean encap, String stream, ZusiProtocolNode node){
        stream = getBakedStream(node, encap, stream);

        for(ZusiProtocolNode n : node.getNodes()){
            encap = n.isStartNode() && node.isStartNode() && node.getNodes().size() > 1;
            stream = recurEncode(encap, stream, n);
        }

        return stream;
    }

    /**
     *
     * @param node
     * @return
     */
    public String encode(ZusiProtocolNode node)  {
        String stream = recurEncode(false, "#", node);
        return stream.replace("#", "");
    }

    /**
     *
     * @param root
     * @return
     * @throws Exception
     */
    public String encode(ZusiProtocolNodeBase root) throws Exception{

        String messages = "";

        for(ZusiProtocolNode child : root.getNodes()){
            messages += encode(child);
        }

        return messages;
    }


}
