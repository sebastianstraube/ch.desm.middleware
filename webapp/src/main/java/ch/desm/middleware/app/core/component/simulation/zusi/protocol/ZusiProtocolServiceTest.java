package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolServiceTest extends ZusiProtocolService {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolServiceTest.class);

    /**
     *
     * @return
     */
    public String testStream1() {
        String message =
                "00000000"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String testStream2() {
        String message =
                "00"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    /**
     *
     * @return ACK_NEEDED Data Befehl akzeptiert
     */
    public String testStream3() {
        String message =
                "00000000020000000000040003000000010000FFFFFFFFFFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String testStreamAck() {
        String message =
                "00000000"+"0200"+"00000000"+"0400"+"03000000"+"0100"+"00"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    public boolean testEncode(String stream){
        ZusiProtocolNodeBase root = null;
        try {
            root = encode(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        return root != null;
    }

    public boolean testGetGlobalId(String hexStream){
        ZusiProtocolNodeBase root = null;
        try {
            root = encode(hexStream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        String globalID = getGlobalId(root);
        ZusiProtocolNodeBase test = getRoot(globalID);
        String globalIdTest = getGlobalId(test);

        return globalID.equals(globalIdTest);
    }

    public boolean testGetRoot(String globalId){
        ZusiProtocolNodeBase root = null;
        try {
            root = getRoot(globalId);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        String globalID = getGlobalId(root);
        ZusiProtocolNodeBase test = getRoot(globalID);
        String globalIdTest = getGlobalId(test);

        return globalID.equals(globalIdTest);
    }

    /**
     *
     * @return
     */
    public boolean testEncodeDecode() {

        boolean isGood = false;
        try {
            ZusiProtocolNodeBase root = encode(getStreamConnect());
            String encodeFromZusi = decode(root);

            ZusiProtocolNodeBase root2 = new ZusiProtocolNodeBase();
            ZusiProtocolNode start = new ZusiProtocolNode(1);
            ZusiProtocolNode hello = new ZusiProtocolNode(1);
            ZusiProtocolNode protocolVersion = new ZusiProtocolNode(1, "2");
            ZusiProtocolNode clientType = new ZusiProtocolNode(2, "2");
            ZusiProtocolNode text = new ZusiProtocolNode(3, "Fahrpult");
            ZusiProtocolNode version = new ZusiProtocolNode(4, "2.0");

            root2.addNode(start);
            start.addNode(hello);
            hello.addNode(protocolVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String encodeFromMiddleware = decode(root2);

            if (encodeFromZusi.equals(encodeFromMiddleware)) {
                isGood = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isGood;
    }

    public boolean testEncodeDecodeNeededData(){

        String s = getStreamNeededData();
        String cmp = "";
        try {
            cmp = getMessageNeededData();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return s.equalsIgnoreCase(cmp);
    }

    /**
     *
     * @return
     */
    public String getStreamConnect() {
        String message =
                "00000000"+"0100"+"00000000"+"0100"+"04000000"+"0100"+"0200"+"04000000"+"0200"+"0200"+"0A000000"+"0300"+"4661687270756C74"+"05000000"+"0400"+"322E30"+"FFFFFFFF" + "FFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String getStreamNeededData() {
        String message = "00000000"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }
}
