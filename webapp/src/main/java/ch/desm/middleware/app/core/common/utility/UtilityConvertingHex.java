package ch.desm.middleware.app.core.common.utility;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 24.02.2015.
 */
public class UtilityConvertingHex {

    private static Logger LOGGER = Logger.getLogger(UtilityConvertingHex.class);

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
        hex = UtilityConvertingHex.expandHexString(hex, length);

        return hex;
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
     * @param hexStream is a hexadecimal stream
     * @return the character stream of the hexadecimal stream
     */
    static public String getCharStream(String hexStream){
        String s = "";
        if(!hexStream.isEmpty()){
            if(hexStream.length() == 4){
                hexStream = UtilityConvertingHex.swapEndian(hexStream);
                s = String.valueOf(Integer.valueOf(hexStream, 16));
            }else{
                String hexCode = "";
                for(int i=0; i<hexStream.length(); i+=2){
                    hexCode = "" + hexStream.charAt(i) + hexStream.charAt(i+1);
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
}
