package ch.desm.middleware.app.core.component.simulation.zusi;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiMessage {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpoint.class);

    LinkedList tree = new LinkedList<>();

    private static final int BYTE_LENGTH_NODE = 4;
    private static final int BYTE_LENGTH_ATTRIBUTE = 4;
    private static final int BYTE_LENGTH_ID  = 2;

    //1 = Verbindungsaufbau
    //  1 = hello
    //      1 = protokoll version
    //      2 = client type
    //      3 = Klartext
    //      4 = Version
    private static final int ID_NODE_START =        0;
    private static final int ID_NODE_END =        255;

    private static final int ID_CONNECT =        1;
    private static final int ID_HELLO =          1;
    private static final int ID_PROTOCOL =       1;
    private static final int ID_CLIENT_TYPE =    2;
    private static final int ID_FAHRPULT =       2;
    private static final int ID_TEXT =           3;
    private static final int ID_VERSION =        4;

    private static final String SEPERATOR = ";";

    public void test(){
        String message="";
        message = addStartNode(message);
        message = addId(message, "254");
    }

    public String convertByteLength(int anzByte, String bytes){
        while(bytes.length() <= anzByte){
            bytes += bytes + "0";
        }


        return bytes;
    }

    public String addStartNode(String stream){
        return stream += "00000000";
    }

    public String addEndNode(String stream){
        return stream += "FFFFFFFF";
    }

    //id = 0x0001 (short)
    public String addId(String stream, String id){
        String byteStream = "";
        byte[] bytes = toBytes(Integer.valueOf(id), ByteOrder.LITTLE_ENDIAN);

        stream += toByteStream(bytes);
        return stream;
    }

    public byte[] toBytes(short s) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putShort(s);
        byte[] bytes = buffer.array();
        String str = "";
        for(int i=0; i<bytes.length; i++){
           str += Integer.toHexString(bytes[i]);
        }

        return bytes;
    }

    public byte[] toBytes(int id, ByteOrder order) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(order);
        buffer.putInt(id);
        byte[] bytes = buffer.array();
        String str = "";
        for(int i=0; i<bytes.length; i++){
            str += Integer.toHexString(bytes[i]);
        }
        return bytes;

    }

    public byte[] toBytes(String s) {
        ByteBuffer buffer = ByteBuffer.allocate(s.length());
        for(int i=0; i<s.length(); i++){
            buffer.putChar(s.charAt(i));
        }

        return buffer.array();
    }

    public String toByteStream(byte[] bytes){
        String stream = "";
        for(int i=0; i<bytes.length;i++){
            stream += bytes[i];
        }
        return stream;
    }


    //id = 0001
    public String addNodeAttribute(String stream, String id, String data){
        //length
        stream += "";
        stream += swapEndian(Integer.valueOf(id));
        stream += swapEndian(data);

        return stream;
    }

    public int getUnsignedByte(int val){
        return val & 0xFF;
    }

    public String swapEndian(String data){
        char[] chars = data.toCharArray();
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());
        return Arrays.toString(bytes);
    }

    public int swapEndian(int i){
            return ((i<<24)+((i<<8)&0x00FF0000)+((i>>8)&0x0000FF00)+(i>>>24));
    }


    public byte[] getByteValue(String s){
        byte[] bs = null;
        try {
            bs = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return bs;
    }






    public String initMessage(){
        String message="";


        message = "0";   // NODE_START               "00 00 00 00"
            message += "1";                     // ID Verbindung aufbauen   "01 00"
            message = "0";   // NODE_START               "00 00 00 00"
                message += "1";             // ID Hello                 "01 00"
                    message += "4";             // DATA_LENGTH              "04 00 00 00"
                        message += "1";         // ID Protokoll             "01 00"
                        message += "2";         // DATA                     "02 00"
                    message += "4";             // DATA_LENGTH              "04 00 00 00"
                        message += "2";         // ID Client-Type           "02 00"
                        message += "2";         // ID Fahrpult              "02 00"
                    message += "10";            // DATA_LENGTH              "0A 00 00 00"
                        message += "3";         // ID Klartext              "03 00"
                        message += "Fahrpult";  // DATA                     "46 61 68 72 70 75 6C 74"
                    message += "5";             // DATA_LENGTH              "05 00 00 00"
                        message += "4";         // ID Version               "04 00"
                        message += "2.0";       // DATA                     "32 2E 30"
            message = "4294967295";        // NODE_END                 "FF FF FF FF"
        message = "4294967295";            // NODE_END                 "FF FF FF FF"

        return message;
    }



}
