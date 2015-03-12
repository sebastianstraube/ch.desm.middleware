package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiServiceTest;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolNodeConverterTest extends ZusiProtocolNodeConverter {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeConverterTest.class);

    /**
     *
     * @param stream
     * @return
     */
    public boolean testEncode(String stream){
        ZusiProtocolNodeBase root = null;
        try {
            root = encode(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        return root != null;
    }

    /**
     *
     * @param hexStream
     * @return
     */
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

    /**
     *
     * @param globalId
     * @return
     */
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
            ZusiProtocolNodeBase root = encode(testStreamConnect());
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

    /**
     *
     * @return
     */
    public boolean testEncodeDecodeNeededData(){

        String s = testStreamNeededDataFahrpult();
        String cmp = "";
        try {
            cmp = getMessageNeededDataFahrpult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s.equalsIgnoreCase(cmp);
    }

    ZusiServiceTest service;
    public ZusiProtocolNodeConverterTest(ZusiServiceTest service){
        this.service = service;
    }

    /**
     *  from MW Message > ZusiProtocolMessage > ZusiProtocolNodeBase > Zusi hex stream > ZusiNodeBase
     * @param middlewareMessage
     * @return
     */
    public boolean testGetConvertToInputCommand(String middlewareMessage) throws Exception {
        //zusi group message: "Hauptschalter Aus"
        //String zusiGroupMessage = "0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0";
        //middleware message
        //String mwMessage = "0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#";

        //middleware message object
        MessageMiddleware mm = service.getTranslator().toMiddlewareMessage(middlewareMessage);
        //zusi protocol transfer object
        ZusiProtocolMessage zpm = new ZusiProtocolMessage(mm.getGlobalId());
        //zusi data transfer object
        ZusiProtocolNodeBase root = this.convertToInputCommand(zpm);
        //decode to zusi hex stream
        String zusiHexStream = service.getProtocolService().decode(root);
        //get global id from hex stream
        String globalId = this.getGlobalId(zusiHexStream);
        //build tree from global id
        ZusiProtocolNodeBase cmpRoot = service.getProtocolService().getRoot(globalId);

        return cmpRoot.equals(root);
    }

    /**
     *
     * @return
     */
    private String testStreamInput_HauptschalterEin(){
        return "0003-0113-0001::0001:11,0002:00,0003:01,0004:2,0005:0";
    }


    /**
     *
     * @return
     */
    private String testStreamInput_HauptschalterAus(){
        return "0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#";
    }

    /**
     *
     * @return
     */
    private String testStreamInput_StromabnehmerHeben(){
        return "0003-0113-0001::0001:2B,0002:00,0003:07,0004:1,0005:0";
    }

    /**
     *
     * @return
     */
    private String testStreamInput_RichtungsschalterVorwärts(){
        return "0003-0113-0001::0001:07,0002:00,0003:03,0004:2,0005:0";
    }

    /**
     *
     * @return
     */
    public String testStreamConnect() {
        String message =
                "00000000"+"0100"+"00000000"+"0100"+"04000000"+"0100"+"0200"+"04000000"+"0200"+"0200"+"0A000000"+"0300"+"4661687270756C74"+"05000000"+"0400"+"322E30"+"FFFFFFFF" + "FFFFFFFF";
        return message;
    }

    /**
     *
     * 00 02 <Knoten> Client-Anwendung 02
     * 00 03 <Knoten> Befehl NEEDED_DATA
     * 00 0A <Knoten> Untergruppe Führerstandsanzeigen
     * 00 01 Word Führerstands-ID gemäß nachfolgender Tabellen
     * 00 01 Word Beliebig viele weitere Führerstands-IDs
     *
     * @return stream with needed parameter: Geschwindigkeit (x0001)
     */
    public String testStreamNeededDataFahrpult() {
        String message = "00000000"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"FFFFFFFF"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

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

    public String testStreamNoData(){
        String message =
                "00000000"+"0200"+"00000000"+"0a00"+""+"ffffffffffffffff";
        return message;
    }

    /**
     * Needed Data > Zusi
     * @return
     */
    public String getMessageNeededDataFahrpult() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode client_fahrpult = new ZusiProtocolNode(2);
        ZusiProtocolNode needed_data = new ZusiProtocolNode(3);
        ZusiProtocolNode fuehrerstandsAnzeigen = new ZusiProtocolNode(10);
        ZusiProtocolNode geschwindigkeit = new ZusiProtocolNode(1, 1, 4);

        root.addNode(client_fahrpult);
        client_fahrpult.addNode(needed_data);
        needed_data.addNode(fuehrerstandsAnzeigen);
        fuehrerstandsAnzeigen.addNode(geschwindigkeit);

        return decode(root);
    }
}
