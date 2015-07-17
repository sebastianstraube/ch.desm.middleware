package ch.desm.middleware.app.common;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 24.02.2015.
 */
public class HexTranslator {

    private static Logger LOGGER = Logger.getLogger(HexTranslator.class);

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
     * @return
     */
    static public String toHex(int i){
        String hex = Integer.toHexString(i);
        return swapEndian(hex);
    }

    /**
     *
     * @param i
     * @param length
     * @return
     */
    static public String toHex(int i, int length){
        String hex = Integer.toHexString(i);
        hex = HexTranslator.expandHexString(hex, length);
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
        if(hex.length() <= 1){
            return "0" + hex;
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
                hex = HexTranslator.swapEndian(hex);
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

    static int toInt(String hex){
        byte[] b = getByteStream(hex);
        int val = byteArrayToInt(0,b, b.length, 0);

        return val;
    }

    /*
    b[3] & 0xFF |
    (b[2] & 0xFF) << 8 |
    (b[1] & 0xFF) << 16 |
    (b[0] & 0xFF) << 24;
     */
    public static int byteArrayToInt(int val, byte[] b, int length, int shift){
        if(length > 0){
            length--;
            val = b[length] & 0xFF << shift;
            val |= byteArrayToInt(val, b, length, shift + 8);
        }

        return val;
    }

    private static byte[] getByteStream(String hexMessage){

        hexMessage = HexTranslator.removeControleCharacter(hexMessage);

        byte[] byteStream = new byte[hexMessage.length()/2];
        for(int i=0; i<hexMessage.length()/2; i++){
            String value = "" + hexMessage.charAt(i*2) + hexMessage.charAt(i*2+1);
            Integer val = Integer.valueOf(value, 16);
            byteStream[i] = val.byteValue();
        }

        return byteStream;
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
        hexNumber = swapEndian(hexNumber);
        int val = Integer.parseInt(hexNumber, 16);
        float f = Float.intBitsToFloat(val);
        return f;
    }

    public static String getHex(float number){
        String hex = Float.toHexString(number);
        return hex;
    }
}
