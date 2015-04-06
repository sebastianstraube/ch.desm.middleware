package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolNodeEncoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeEncoder.class);

    /**
     *
     * @param node
     * @return
     */
    public String encode(ZusiProtocolNode node)  {
        String stream = recurEncode(false, ZusiProtocolConstants.DELIMITER_SUBMESSAGE, node);
        String replace = stream.replace(ZusiProtocolConstants.DELIMITER_SUBMESSAGE, "");
        return replace;
    }

    /**
     *
     * @param root
     * @return
     * @throws Exception
     */
    public String encode(ZusiProtocolNodeRoot root) throws Exception{

        String messages = "";

        for(ZusiProtocolNode child : root.getNodes()){
            messages += encode(child);
        }

        return messages;
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

    /**
     *
     * @param encap
     * @param stream
     * @param node
     * @return
     */
    private String recurEncode(boolean encap, String stream, ZusiProtocolNode node){
        stream = getBakedStream(node, encap, stream);

        for(ZusiProtocolNode n : node.getNodes()){
            encap = n.isStartNode() && node.isStartNode() && node.getNodes().size() > 1;
            stream = recurEncode(encap, stream, n);
        }

        return stream;
    }


}
