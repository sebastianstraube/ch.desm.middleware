package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolNodeDecoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeDecoder.class);

    /**
     *
     * @param stream
     * @return
     * @throws Exception
     */
    public ZusiProtocolNodeRoot decode(String stream) throws Exception {

        ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
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
}
