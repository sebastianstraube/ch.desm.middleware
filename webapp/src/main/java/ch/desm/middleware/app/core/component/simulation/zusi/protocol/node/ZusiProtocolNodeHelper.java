package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Sebastian on 06.03.2015.
 */
public class ZusiProtocolNodeHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeRoot.class);

    /**
     *
     * @param stream
     * @return
     */
    static String getNode(String stream){
        String nodeHex = stream.substring(0, 8);
        return nodeHex;
    }

    /**
     *
     * @param data
     * @return
     */
    static String getNodeHex(String data){
        int length = data.length() == 0 ? 0 : (data.length() + 4) / 2;
        String dataHex = ZusiProtocolNodeHelperHex.toHex(length, 8);
        return dataHex;
    }

    /**
     *
     * @param stream
     * @return
     */
    public static String getId(String stream){
        String idHex = stream.substring(8, 12);
        return idHex;
    }

    /**
     *
     * @param stream
     * @return
     */
    static String getData(String stream){
        int dataLength = getNrBytes(stream);
        String data = hasData(stream) ? stream.substring(12, 12 + dataLength) : "";
        return data;
    }

    /**
     *
     * @param stream
     * @return
     */
    static int getNrBytes(String stream){
        String node = stream.substring(0, 8);
        node = ZusiProtocolNodeHelperHex.swapEndian(node);
        int val =  Integer.valueOf(node, 16).intValue();
        return val == 0 ? val : val * 2 - 4;
    }

    /**
     *
     * @param stream
     * @return
     */
    private static boolean hasData(String stream){
        return stream.length() > 12;
    }

    /**
     *
     * @param encap
     * @param node
     * @return
     */
    public static String getNodeStream(boolean encap, ZusiProtocolNode node){
        String stream ="";

        if(node.isStartNode() && encap){
            stream += ZusiProtocolConstants.NODE_END;
        }

        stream += node.getNode();
        stream += node.getId();
        stream += node.getData();
        stream += ZusiProtocolConstants.DELIMITER_SUBMESSAGE;

        if(node.isStartNode() && !encap){
            stream += ZusiProtocolConstants.NODE_END;
        }

        return stream;
    }

    /**
     *
     * @param globalId
     * @return
     */
    public static ZusiProtocolNodeRoot getRoot(String globalId){
        ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
        String tmpId = globalId;
        String[] id = globalId.substring(0, globalId.lastIndexOf(ZusiProtocolConstants.DELIMITER_GROUP)).split(ZusiProtocolConstants.DELIMITER_GROUP_VALUE);
        String[] parameter = globalId.substring(globalId.lastIndexOf(ZusiProtocolConstants.DELIMITER_GROUP)+2, globalId.length()).split(ZusiProtocolConstants.DELIMITER_PARAMETER);
        root = buildRootNode(root, null, id, parameter);
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
    static ZusiProtocolNodeRoot buildRootNode(ZusiProtocolNodeRoot root, ZusiProtocolNode lastNode, String[] id, String[] parameter){
        // groups
        for(int i=0; i<id.length; i++){
            ZusiProtocolNode n = new ZusiProtocolNode(id[i], "");

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
            lastNode = n;
        }

        // parameter
        String[] nrParamerter = Arrays.toString(parameter).trim().split(ZusiProtocolConstants.DELIMITER_PARAMETER);
        for(int i=0; i<nrParamerter.length; i++){
            String parameterId = parameter[i].substring(0, parameter[i].lastIndexOf(ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE));
            String parameterValue = parameter[i].substring(parameter[i].lastIndexOf(ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE) + 1, parameter[i].length());
            ZusiProtocolNode n = new ZusiProtocolNode(parameterId, parameterValue);

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
        }
        return root;
    }

    /**
     *
     * @param hexMessage
     * @return
     * @throws Exception
     */
    public static String getGlobalId(String hexMessage, ZusiService service) throws Exception{
        ZusiProtocolNodeRoot root = service.getDecoder().decode(hexMessage);
        return getGlobalId(root);
    }

    /**
     *
     * @param root
     * @return
     */
    public static String getGlobalId(ZusiProtocolNodeRoot root){
        String id ="";
        for(ZusiProtocolNode n : root.nodes){
            id += getGlobalId(n, 0);
        }

        return id;
    }

    /**
     * e.g. 2-4::1:DATA
     *
     * @param n
     * @param nrParameter
     * @return
     */
    private static String getGlobalId(ZusiProtocolNode n, int nrParameter){
        String nodeId ="";
        nodeId += n.getId();

        if(!n.isStartNode()){
            nodeId += ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE + n.getData();
        }

        for(ZusiProtocolNode next : n.nodes) {
            String parChar = "";
            if(next.isStartNode()) {
                parChar = ZusiProtocolConstants.DELIMITER_GROUP_VALUE;
            }else{
                if(nrParameter == 0){
                    parChar= ZusiProtocolConstants.DELIMITER_GROUP;
                }else{
                    parChar = ZusiProtocolConstants.DELIMITER_PARAMETER;
                }
                nrParameter++;
            }
            nodeId += parChar + getGlobalId(next, nrParameter);
        }
        return nodeId;
    }
}

