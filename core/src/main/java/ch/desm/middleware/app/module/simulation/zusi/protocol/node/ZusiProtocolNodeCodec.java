package ch.desm.middleware.app.module.simulation.zusi.protocol.node;

import ch.desm.middleware.app.module.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolNodeCodec {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeCodec.class);

    /**
     *
     * @param stream
     * @return
     * @throws Exception
     */
    public ZusiProtocolNode decode(String stream) throws Exception {

        ZusiProtocolNode root = new ZusiProtocolNode();
        try {
            ZusiProtocolNode lastNode = null;
            ZusiProtocolNode lastStartNode = null;
            boolean nodeEncapsulated = false;
            //stream is empty when the whole stream is decoded
            while (!stream.isEmpty()) {

                int messageLength;

                // is there is an end node, remove and go further
                if (stream.toUpperCase().startsWith(ZusiProtocolConstants.NODE_END)) {
                    nodeEncapsulated = true;
                    messageLength = 8;
                } else
                // has start node
                if (stream.startsWith(ZusiProtocolConstants.NODE_START)) {
                    messageLength = 8 + 4 + ZusiProtocolNodeHelper.getData(stream).length();
                    String subStream = stream.substring(0, messageLength);
                    ZusiProtocolNode newNode = new ZusiProtocolNode(lastNode, subStream);

                    //if there is no existing node
                    if (lastNode == null) {
                        lastNode = newNode;
                        root.addNode(lastNode);
                    }
                    else if(nodeEncapsulated){
                        lastStartNode.getPrevNode().addNode(newNode);
                        lastNode = newNode;
                    }
                    // add root node to last processed node
                    else{
                        lastNode.addNode(newNode);
                        lastNode = newNode;
                        lastStartNode = newNode;
                    }
                }
                // has id node
                else {
                    ZusiProtocolNode newNode = processParameter(stream);
                    newNode.setPrevNode(lastNode);
                    lastNode.addNode(newNode);
                    messageLength = 8 + 4 + ZusiProtocolNodeHelper.getData(stream).length();
                    //process parameter and come back when start or end nodes not found
                }

                stream = stream.substring(messageLength);
            }
        } catch(StringIndexOutOfBoundsException e){
            throw new Exception("inconsistent message: " + stream);
        } catch (NumberFormatException e) {
            throw new Exception("parse error with message: " + stream);
        }
        return root;
    }

    /**
     *
     * @param stream
     * @return
     */
    private ZusiProtocolNode processParameter(String stream){
        ZusiProtocolNode node = new ZusiProtocolNode(stream);
        return node;
    }

    /**
     *
     * @param root
     * @return
     * @throws Exception
     */
    public String encode(ZusiProtocolNode root) throws Exception{

        String messages = "";

        for(ZusiProtocolNode next : root.getNodes()){
            String stream = doEncode(false, ZusiProtocolConstants.DELIMITER_SUBMESSAGE, next, null);
            String replace = stream.replace(ZusiProtocolConstants.DELIMITER_SUBMESSAGE, "");
            messages += replace;
        }

        return messages;
    }

    /**
     *
     * @param encap
     * @param stream
     * @param node
     * @return
     */
    private String doEncode(boolean encap, String stream, ZusiProtocolNode node, ZusiProtocolNode parentNode) {
        stream = getBakedStream(node, encap, stream);

        for(ZusiProtocolNode next : node.getNodes()){
            if(parentNode != null &&
                    parentNode.getNodes() != null &&
                    parentNode.getNodes().size() > 1 &&
                    node.getPrevNode() != null &&
                    node.getPrevNode().getNodes() != null &&
                    !node.getPrevNode().getNodes().isEmpty() &&
                    node.getPrevNode().getNodes().getLast().equals(node)){
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
