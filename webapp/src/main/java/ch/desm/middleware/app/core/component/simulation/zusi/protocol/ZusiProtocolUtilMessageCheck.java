package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolUtilMessageCheck {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolUtilMessageCheck.class);

    /**
     *
     * @param message
     * @return
     */
    public boolean isMessageComplete(String message){
        return getSingleZusiMessageIndex(message) <= 0? false : true;
    }

    /**
     *
     * @param message
     * @return
     */
    public String extractSingleZusiMessage(String message){
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

        boolean isValid = true;
        if(!hasValidCharacteristic(message)){
            isValid = false;
        }

        int cntStartNode = 0;
        int cntEndNode = 0;
        int cntValidMessageLength = 0;
        String id = "";
        try{
            while(isValid && !message.isEmpty()){
                if(message.length() < 8){
                    isValid = false;
                    break;
                }
                if(cntStartNode != 0 && cntStartNode == cntEndNode){
                    isValid = true;
                    break;
                }

                String start = message.substring(0, 8);
                //String id = "";

                if(start.equals("00000000")){
                    cntStartNode++;
                    id = message.substring(8, 12);
                }else if (start.equalsIgnoreCase("FFFFFFFF")){
                    cntEndNode++;
                }else{
                    id = message.substring(8, 12);
                }

                int nodeLength = getNodeLength(start, id);
                message = message.substring(nodeLength);
                cntValidMessageLength += nodeLength;
            }

        }catch(Exception e){
            LOGGER.log(Level.ERROR, e);
        }


        return isValid == true ? cntValidMessageLength : -1;
    }

    /**
     *
     * @param message
     * @return
     */
    private boolean hasValidCharacteristic(String message){
        if(message.length() < 40 ||
                !message.startsWith("00000000") ||
                !message.toUpperCase().contains("FFFFFFFF")){
            return false;
        }

        return true;
    }

    /**
     *
     * @param node
     * @param id
     * @return
     */
    private int getNodeLength(String node, String id){
        node = UtilConvertingHex.swapEndian(node);
        int length = 0;

        if(node.equalsIgnoreCase("FFFFFFFF")){
            length = node.length();
        }else{
            int nrBytes = Integer.parseInt(node, 16);
            if(nrBytes > 0){
                length += node.length() + nrBytes*2;
            }else{
                length += node.length() + id.length();
            }
        }

        return length;
    }
}
