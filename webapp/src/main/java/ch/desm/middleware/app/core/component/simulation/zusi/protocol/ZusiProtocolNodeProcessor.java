package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiProtocolNodeProcessor {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeProcessor.class);
    private ZusiProtocolEncoderDecoder encodeDecode;

    public ZusiProtocolNodeProcessor(){
        this.encodeDecode = new ZusiProtocolEncoderDecoder();
    }

    public ZusiProtocolEncoderDecoder getEncodeDecoder(){
        return encodeDecode;
    }

    /**
     *
     * @param message
     * @return
     */
    protected ZusiProtocolNodeBase toNode(String message) throws Exception {
        return encodeDecode.decode(message);
    }

    /**
     *
     * @param hexMessage
     * @return
     * @throws Exception
     */
    public String getGlobalId(String hexMessage) throws Exception{
        return getGlobalId(encodeDecode.decode(hexMessage));
    }

    /**
     *
     * @param globalId
     * @return
     */
    public ZusiProtocolNodeBase getRoot(String globalId){
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        String tmpId = globalId;
        ZusiProtocolNode lastNode = null;
        String[] id = globalId.substring(0, globalId.lastIndexOf("::")).split("-");
        String[] parameter = globalId.substring(globalId.lastIndexOf("::")+2, globalId.length()).split(",");

        root = buildRootNode(root, lastNode, id, parameter);

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
    protected ZusiProtocolNodeBase buildRootNode(ZusiProtocolNodeBase root, ZusiProtocolNode lastNode, String[] id, String[] parameter){
        for(int i=0; i<id.length; i++){
            ZusiProtocolNode n = new ZusiProtocolNode(id[i]);

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
            lastNode = n;
        }

        String[] nrParamerter = Arrays.toString(parameter).trim().split(",");

        for(int i=0; i<nrParamerter.length; i++){
            String parameterId = parameter[i].substring(0, parameter[i].lastIndexOf(":"));
            String parameterValue = parameter[i].substring(parameter[i].lastIndexOf(":")+1, parameter[i].length());
            ZusiProtocolNode n = new ZusiProtocolNode(Integer.valueOf(parameterId, 16).intValue(), Integer.valueOf(parameterValue, 16).intValue(), parameterValue.length());

            if(lastNode == null){
                root.addNode(n);
            }else{
                lastNode.addNode(n);
            }
            lastNode = n;
        }
        return root;
    }

    /**
     *
     * @param root
     * @return
     */
    public String getGlobalId(ZusiProtocolNodeBase root){
        String id ="";
        for(ZusiProtocolNode n : root.nodes){
            id += getGlobalId(n, 0);
        }

        return id;
    }

    /**
     *
     * e.g. 2-4::1:DATA
     *
     * @param n
     * @param nrParameter
     * @return
     */
    protected String getGlobalId(ZusiProtocolNode n, int nrParameter){
        String nodeId ="";
        nodeId += n.getIdHex();

        if(n.getDataArray().length <= 0){
            int expandLength = 4;
            if(n.getDataArray().length >= 1){
                expandLength = 2;
            }
            nodeId += ":" + n.getDataHex(expandLength);
        }

        if(!n.nodes.isEmpty()){
            for(ZusiProtocolNode next : n.nodes) {
                String parChar = "";
                if(next.getDataArray().length <= 0) {
                    parChar = "-";
                }else if(next.getDataArray().length >= 0){

                    if(nrParameter == 0){
                        parChar="::";
                    }else{
                        parChar = ",";
                    }
                    nrParameter++;
                }
                nodeId += parChar + getGlobalId(next, nrParameter);
            }
        }

        return nodeId;
    }


}