package ch.desm.middleware.module.desm.simulation.zusi.protocol.node;

import ch.desm.middleware.common.UtilityHex;
import ch.desm.middleware.module.desm.simulation.zusi.ZusiService;
import ch.desm.middleware.module.desm.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Sebastian on 06.03.2015.
 */
public class ZusiProtocolNodeHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeHelper.class);

    protected ZusiService service;
    public ZusiProtocolNodeHelper(ZusiService service){
        this.service = service;
    }
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
        String dataHex = UtilityHex.toHex(length, 8);
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
        int dataLength = hasData(stream) ? getNrDataBytes(stream) : 0;
        return stream.substring(12, 12 + dataLength);
    }

    /**
     *
     * @param stream
     * @return
     */
    static int getNrDataBytes(String stream){
        String node = stream.substring(0, 8);
        node = UtilityHex.swapEndian(node);
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
     * TODO - check static immuatable object
     * @param encap
     * @param node
     * @return
     */
    public static String getNodeStream(boolean encap, ZusiProtocolNode node){
        String stream ="";
        if(node.isStartNode() && encap) stream += ZusiProtocolConstants.NODE_END;
        stream += node.getNode() == null ? "" : node.getNode() ;
        stream += node.getId() == null ? "" : node.getId();
        stream += node.getData() == null ? "" : node.getData();
        stream += ZusiProtocolConstants.DELIMITER_SUBMESSAGE;
        if(node.isStartNode() && !encap) stream += ZusiProtocolConstants.NODE_END;

        return stream;
    }

    /**
     *
     * @param globalId
     * @return
     */
    public ZusiProtocolNode getRoot(String globalId){
        ZusiProtocolNode root = new ZusiProtocolNode();
        String[] id = globalId.substring(0, globalId.lastIndexOf(ZusiProtocolConstants.DELIMITER_GROUP)).split(ZusiProtocolConstants.DELIMITER_GROUP_VALUE);
        String[] parameter = globalId.substring(globalId.lastIndexOf(ZusiProtocolConstants.DELIMITER_GROUP)+2, globalId.length()).split(ZusiProtocolConstants.DELIMITER_PARAMETER);
        root = getRootNode(root, null, id, parameter);
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
    protected ZusiProtocolNode getRootNode(ZusiProtocolNode root, ZusiProtocolNode lastNode, String[] id, String[] parameter){
        // groups
        for(int i=0; i<id.length; i++){
            ZusiProtocolNode n = new ZusiProtocolNode(root, id[i], "");
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
            ZusiProtocolNode n = new ZusiProtocolNode(lastNode, parameterId, parameterValue);

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
    public LinkedList<String> getGlobalId(String hexMessage) throws Exception{
        ZusiProtocolNode root = service.getCodec().decode(hexMessage);
        return getGlobalId(root);
    }

    /**
     *
     * @param root
     * @return
     */
    public LinkedList<String> getGlobalId(ZusiProtocolNode root){
        String globalIdMessage ="";
        for(ZusiProtocolNode n : root.nodes){
            globalIdMessage += getGlobalId(n, 0);
        }
        LinkedList<String> globalIds = decodeGlobalId(globalIdMessage);

        return globalIds;
    }

    public LinkedList<String> decodeGlobalId(String message){

        String[] subMessages = getGlobalIdSubMessage(message);
        LinkedList<String> messages = new LinkedList<String>();

        for(int i=0; i<subMessages.length; i++){
            int idxStart = subMessages[i].indexOf(ZusiProtocolConstants.DELIMITER_GROUP);
            int idxEnd = subMessages[i].length();
            String m = getGlobalIdGroupId(message) + subMessages[i].substring(idxStart, idxEnd);
            messages.add(m);
        }

        return messages;
    }

    private boolean hasGroupId(String globalId){
        return globalId.indexOf(ZusiProtocolConstants.DELIMITER_GROUP) > 0;
    }

    private String getGlobalIdGroupId(String globalId){
        return hasGroupId(globalId) ? globalId.substring(0, globalId.indexOf(ZusiProtocolConstants.DELIMITER_GROUP)) : "";
    }

    public boolean hasSubMessage(String globalId){
        return globalId.indexOf(ZusiProtocolConstants.DELIMITER_SUBMESSAGE) > 0;
    }

    private String[] getGlobalIdSubMessage(String globalId){
        return hasSubMessage(globalId) ? globalId.split(ZusiProtocolConstants.DELIMITER_SUBMESSAGE) : new String[0];
    }

    public boolean hasParameter(String globalId){
        return globalId.indexOf(ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE) > 0;
    }

    /**
     * e.g. 2-4::1:DATA
     *
     * @param node
     * @param nrParameter
     * @return
     */
    public String getGlobalId(ZusiProtocolNode node, int nrParameter){
        String nodeId = node.getId();
        if(!node.isStartNode()) nodeId += ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE + node.getData();

        for(ZusiProtocolNode next : node.nodes){
            String parChar = getParameterChar(next, nrParameter);
            if(!next.isStartNode())nrParameter++;

            nodeId += parChar;
            nodeId += getGlobalId(next, nrParameter);
            if(nrParameter > 0 && node.nodes !=null && next.equals(node.nodes.getLast())) {
                nrParameter = 0;
                nodeId += ZusiProtocolConstants.DELIMITER_SUBMESSAGE;
            }

        }

        if(hasGroupId(nodeId) && !hasParameter(nodeId) && nrParameter == 0){
            nodeId = nodeId + ZusiProtocolConstants.DELIMITER_SUBMESSAGE;
        }

        return nodeId;
    }

    private String getParameterChar(ZusiProtocolNode node, int nrParameter){
        String parChar;

        if(node.isStartNode()) {
            parChar = ZusiProtocolConstants.DELIMITER_GROUP_VALUE;
        }else{
            if(nrParameter == 0){
                parChar= ZusiProtocolConstants.DELIMITER_GROUP;
            }else{
                parChar = ZusiProtocolConstants.DELIMITER_PARAMETER;
            }
        }
        return parChar;
    }
}

