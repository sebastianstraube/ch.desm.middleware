package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 24.02.2015.
 */
public class ZusiProtocolNodeHelperHex {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeHelperHex.class);

    /**
     *
     * @param data
     * @return
     */
    public static String toHex(String data){
        String message = "";

        for(int i=0; i<data.length(); i++){
            int x = ((int) data.charAt(i) & 0xFF);
            message += toHex(x ,2);
        }

        return message;
    }

    /**
     *
     * @param message
     * @return
     */
    public static String toHex(byte[] message){
        String hexMessage = "";
        for(int i=0; i<message.length; i++){
            int j = (message[i] & 0xFF);
            hexMessage += toHex(j ,2);
        }

        return hexMessage;
    }

    /**
     *
     * @param i
     * @param length
     * @return
     */
    static public String toHex(int i, int length){
        String hex = Integer.toHexString(i);
        hex = ZusiProtocolNodeHelperHex.expandHexString(hex, length);
        return swapEndian(hex);
    }

    /**
     *
     * @param data
     * @param length
     * @return
     */
    static public String toHex(int[] data, int length){
        String hex = "";

        for(int i=0; i<data.length; i++){
           hex += toHex(data[i], length);
        }

        return hex;
    }

    /**
     *
     * @param hex stream
     * @return a hex stream with swapped byte order
     */
    static public String swapEndian(String hex){
        if(hex.isEmpty()){
            return hex;
        }

        String swapped = "";
        String bytes = "";
        int upperBound = hex.length()-1;
        for(int i=upperBound; i>= 0; i--){
            bytes = hex.charAt(i) + bytes;
            if((i%2 == 0) && ( i!= upperBound)){
                swapped += bytes;
                bytes = "";
            }
        }

        return swapped;
    }

    /**
     *
     * @param hex is a hexadecimal stream
     * @return the character stream of the hexadecimal stream
     */
    static public String getCharStream(String hex){
        String s = "";
        if(!hex.isEmpty()){
            if(hex.length() == 4){
                hex = ZusiProtocolNodeHelperHex.swapEndian(hex);
                s = String.valueOf(Integer.valueOf(hex, 16));
            }else{
                String hexCode = "";
                for(int i=0; i<hex.length(); i+=2){
                    hexCode = "" + hex.charAt(i) + hex.charAt(i+1);
                    int code = Integer.valueOf(hexCode, 16);
                    s += (char)code;
                }
            }
        }

        return s;
    }

    /**
     *
     * @param hex value
     * @param length minimum length of expanded hex value
     * @return
     */
    static public String expandHexString(String hex, int length){
        while(hex.length() < length){
            hex = "0" + hex;
        }

        return hex;
    }

    /**
     *
     * @param message
     * @return
     */
    static public String removeControleCharacter(String message){
        return message.replaceAll("[\u0000-\u001f]", "");
    }

    public static float getFloat(String hexNumber){
        int unsigned = Integer.parseUnsignedInt(hexNumber, 16);
        return Float.intBitsToFloat(unsigned);
    }

    public static String getHex(float number){
        String hex = Float.toHexString(number);
        return hex;
    }
}
