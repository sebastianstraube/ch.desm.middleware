package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelperHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolMessageHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolMessageHelper.class);

    /**
     *
     * @param message
     * @return
     */
    public String getSingleZusiMessage(String message){
        int index = getSingleZusiMessageIndex(message);
        String s = index > 0 ? message.substring(0, index) : "" ;

        return s;
    }

    /**
     *
     * @param message
     * @return
     */
    private int getSingleZusiMessageIndex(String message){
        int cntStartNode = 0;
        int cntEndNode = 0;
        int cntValidMessageLength = 0;
        boolean isValid = true;
        int nodeLength = 0;
        String partMessage = message;

        if(!hasValidCharacteristic(partMessage)){
            isValid = false;
        }

        try{
            while(isValid && !partMessage.isEmpty()){
                if(cntStartNode != 0 && cntStartNode == cntEndNode){
                    break;
                }
                if(partMessage.length() < 8){
                    isValid = false;
                    break;
                }
                String id = "";
                String start = partMessage.substring(0, 8);
                if(start.equals(ZusiProtocolConstants.NODE_START)){
                    cntStartNode++;
                    id = partMessage.substring(8, 12);
                }else if (start.equalsIgnoreCase(ZusiProtocolConstants.NODE_END)){
                    cntEndNode++;
                }else{
                    id = partMessage.substring(8, 12);
                }

                nodeLength = getNodeLength(start, id);
                partMessage = partMessage.substring(nodeLength);
                cntValidMessageLength += nodeLength;
            }

        }catch(StringIndexOutOfBoundsException e){
            LOGGER.log(Level.ERROR, "wrong stream node length: " + nodeLength + " in message: " + partMessage + ", origin message: " + message);
        }

        if(cntStartNode != cntEndNode) isValid = false;
        return isValid == true ? cntValidMessageLength : -1;
    }

    /**
     *
     * @param message
     * @return
     */
    private boolean hasValidCharacteristic(String message){
        boolean isValid = true;
        if(message.length() < 40) isValid = isValid && false;
        if(!message.startsWith(ZusiProtocolConstants.NODE_START)) isValid = isValid && false;
        if(!message.toUpperCase().contains(ZusiProtocolConstants.NODE_END))isValid = isValid && false;

        if(!isValid) LOGGER.log(Level.TRACE, "hasValidCharacteristic skip message: " + message);

        return isValid;
    }

    /**
     *
     * @param node
     * @param id
     * @return
     */
    private int getNodeLength(String node, String id){
        node = ZusiProtocolNodeHelperHex.swapEndian(node);
        int length = 0;

        //when id empty then it's an start node "00000000"
        int nrBytes = id.isEmpty() ? 0 : Integer.parseInt(node, 16);
        if(nrBytes > 0){
            length += node.length() + nrBytes*2;
        }else{
            length += node.length() + id.length();
        }

        return length;
    }
}
