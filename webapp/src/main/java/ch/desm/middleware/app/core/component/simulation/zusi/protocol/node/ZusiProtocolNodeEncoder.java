package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolNodeEncoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeEncoder.class);

    /**
     *
     * @param root
     * @return
     * @throws Exception
     */
    public String encode(ZusiProtocolNodeRoot root) throws Exception{

        String messages = "";

        for(ZusiProtocolNode next : root.getNodes()){
            messages += encode(next);
        }

        return messages;
    }

    /**
     *
     * @param node
     * @return
     */
    public String encode(ZusiProtocolNode node)  {
        String stream = doEncode(false, ZusiProtocolConstants.DELIMITER_SUBMESSAGE, node, null);
        String replace = stream.replace(ZusiProtocolConstants.DELIMITER_SUBMESSAGE, "");
        return replace;
    }

    /**
     *
     * @param encap
     * @param stream
     * @param node
     * @return
     */
    private String doEncode(boolean encap, String stream, ZusiProtocolNode node, ZusiProtocolNode parentNode){
        stream = getBakedStream(node, encap, stream);

        for(ZusiProtocolNode next : node.getNodes()){
            if(parentNode != null && parentNode.getNodes() != null && parentNode.getNodes().size() > 1 && node.getPrevNode().getNodes().getLast().equals(node)){
                encap = node.isStartNode() && next.isStartNode();
            }
            if(next.isStartNode()) parentNode = node;
            stream = doEncode( encap, stream, next, parentNode);
        }

        return stream;
    }

    /**
     *
     * @param node
     * @param encap
     * @param stream
     * @return
     */
    private String getBakedStream(ZusiProtocolNode node, boolean encap, String stream){
        String part = ZusiProtocolNodeHelper.getNodeStream(encap, node);
        return stream.replace(ZusiProtocolConstants.DELIMITER_SUBMESSAGE, part);
    }


}
