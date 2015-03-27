package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolMessageChecker {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolMessageChecker.class);

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
        String s;
        if(index <= 0) {
            s = "";
        }else{
            s = message.substring(0, index);
        }

        return s;
    }

    /**
     * e.g. 00000000020000000000040003000000010000ffffffffffffffff000000000200000000000a00ffffffffffffffff000000000200000000000a0006000000010000000000060000001b0000000000ffffffffffffffff
     * @param message
     * @return
     */
    protected int getSingleZusiMessageIndex(String message){
        int length = 0;
        int cntStartNode = 0;
        int cntEndNode = 0;
        boolean isValid = false;

        if(message.startsWith("00000000") && message.length() >= 40){

            while(!isValid){

                if(message.length() < 8){
                    length = -1;
                    break;
                }

                int nodeLength = 8;
                int dataLength = 0;
                int idLength = 0;
                String node = message.substring(0, nodeLength);
                String nodeSwapped = UtilConvertingHex.swapEndian(node);

                //if start node
                if(node.equalsIgnoreCase("00000000")){
                    cntStartNode++;
                    dataLength = 4;
                    //if data node
                }else if(node.equalsIgnoreCase("FFFFFFFF")){
                    cntEndNode++;
                }else{
                    int val = Integer.valueOf(nodeSwapped, 16);
                    //if start node
                    if(val == 0){
                        idLength = 4;
                    }
                    dataLength = val*2 + idLength;
                }

                int partLength = nodeLength+dataLength;
                if(cntStartNode == cntEndNode){
                    isValid = true;
                }else{
                    try{
                        message = message.substring(partLength, message.length());
                    } catch(StringIndexOutOfBoundsException e){
                        LOGGER.log(Level.ERROR, e + " with message: " + message + ", partLength: " + partLength + ", messageLength: " + message.length());
                        length = 0;
                        partLength = 0;
                        break;
                    }

                }

                length+=partLength;
            }
        }

        return length;
    }
}
