package ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol.node;

import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiEndpointMessage;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelperHex;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeRoot;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 05.04.2015.
 */
public class ZusiProtocolNodeHelperTest extends ZusiProtocolNodeHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeHelperTest.class);

    /**
     *
     * @param stream
     * @return
     */
    public boolean testGetGlobalId(String stream, ZusiService service){
        ZusiProtocolNodeRoot root = null;
        try {
            root = service.getDecoder().decode(stream);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        String globalID = ZusiProtocolNodeHelper.getGlobalId(root);
        ZusiProtocolNodeRoot test = getRoot(globalID);
        String globalIdTest = getGlobalId(test);

        return globalID.equals(globalIdTest);
    }

    /**
     *
     * @param globalId
     * @return
     */
    public boolean testGetRoot(String globalId){
        boolean test = false;
        try {
            ZusiProtocolNodeRoot root1 = getRoot(globalId);
            String globalId1 = getGlobalId(root1);
            test = globalId.equalsIgnoreCase(globalId1);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        return test;
    }

    /**
     *
     * @param globalId
     * @return
     */
    public boolean testGetRootIntegrated(String globalId){
        boolean test = false;
        try {
            ZusiProtocolNodeRoot root1 = getRoot(globalId);
            String globalId1 = getGlobalId(root1);
            boolean test1 = globalId.equalsIgnoreCase(globalId1);

            ZusiProtocolNodeRoot root2 = getRoot(globalId1);
            String globalId2 = getGlobalId(root2);
            boolean test2 = globalId.equalsIgnoreCase(globalId2);

            test = test1 && test2;
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e);
        }

        return test;
    }

    /**
     *
     * @return
     */
    public boolean testEncodeDecode(ZusiService service, String stream) {

        boolean isGood = false;
        try {
            ZusiProtocolNodeRoot root = service.getDecoder().decode(stream);
            String encodeFromZusi = service.getEncoder().encode(root);

            ZusiProtocolNodeRoot root2 = new ZusiProtocolNodeRoot();
            ZusiProtocolNode start = new ZusiProtocolNode("0100", "");
            ZusiProtocolNode hello = new ZusiProtocolNode("0100", "");
            ZusiProtocolNode protocolVersion = new ZusiProtocolNode("0100", "0200");
            ZusiProtocolNode clientType = new ZusiProtocolNode("0200", "0200");

            String datafahrpult = ZusiProtocolNodeHelperHex.toHex("Fahrpult");
            String dataVersion = ZusiProtocolNodeHelperHex.toHex("2.0");
            ZusiProtocolNode text = new ZusiProtocolNode("0300", datafahrpult);
            ZusiProtocolNode version = new ZusiProtocolNode("0400", dataVersion);

            root2.addNode(start);
            start.addNode(hello);
            hello.addNode(protocolVersion);
            hello.addNode(clientType);
            hello.addNode(text);
            hello.addNode(version);

            String encodeFromMiddleware = service.getEncoder().encode(root2);
            if (encodeFromZusi.equalsIgnoreCase(encodeFromMiddleware)) isGood = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isGood;
    }

    /**
     *
     * @return
     */
    public boolean testEncodeDecodeNeededData(ZusiService service, String s){

        String cmp = "";
        try {

            ZusiProtocolNodeRoot root = new ZusiProtocolNodeRoot();
            ZusiProtocolNode client_fahrpult = new ZusiProtocolNode("0200", "");
            ZusiProtocolNode needed_data = new ZusiProtocolNode("0300", "");
            ZusiProtocolNode fuehrerstandsAnzeigen = new ZusiProtocolNode("0A00", "");
            ZusiProtocolNode geschwindigkeit = new ZusiProtocolNode("0100", "0100");

            root.addNode(client_fahrpult);
            client_fahrpult.addNode(needed_data);
            needed_data.addNode(fuehrerstandsAnzeigen);
            fuehrerstandsAnzeigen.addNode(geschwindigkeit);

            cmp = service.getEncoder().encode(root);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s.equalsIgnoreCase(cmp);
    }

    /**
     *
     * @return
     */
    public boolean testCmpZusiProtocolNodeBase(){

        ZusiProtocolNodeRoot root1 = new ZusiProtocolNodeRoot();
        ZusiProtocolNodeRoot root2 = new ZusiProtocolNodeRoot();

        ZusiProtocolNode root1_client_fahrpult = new ZusiProtocolNode("0200", "");
        ZusiProtocolNode root1_needed_data = new ZusiProtocolNode("0300", "");
        ZusiProtocolNode root1_fuehrerstandsAnzeigen = new ZusiProtocolNode("0A00", "");
        ZusiProtocolNode root1_geschwindigkeit = new ZusiProtocolNode("0100", "0100");

        ZusiProtocolNode root2_client_fahrpult = new ZusiProtocolNode("0200", "");
        ZusiProtocolNode root2_needed_data = new ZusiProtocolNode("0300", "");
        ZusiProtocolNode root2_fuehrerstandsAnzeigen = new ZusiProtocolNode("0A00", "");
        ZusiProtocolNode root2_geschwindigkeit = new ZusiProtocolNode("0100", "0100");

        root1.addNode(root1_client_fahrpult);
        root1_client_fahrpult.addNode(root1_needed_data);
        root1_needed_data.addNode(root1_fuehrerstandsAnzeigen);
        root1_fuehrerstandsAnzeigen.addNode(root1_geschwindigkeit);

        root2.addNode(root2_client_fahrpult);
        root2_client_fahrpult.addNode(root2_needed_data);
        root2_needed_data.addNode(root2_fuehrerstandsAnzeigen);
        root2_fuehrerstandsAnzeigen.addNode(root2_geschwindigkeit);

        return root1.equals(root2);
    }

    /**
     *
     * @return
     */
    public boolean testCmpZusiProtocolNode(){
        ZusiProtocolNode n1 = new ZusiProtocolNode("0A0", "");
        ZusiProtocolNode n2 = new ZusiProtocolNode("0A00", "");
        return n1.equals(n2);
    }

    /**
     *  from MW Message > ZusiProtocolMessage > ZusiProtocolNodeBase > Zusi hex stream > ZusiNodeBase
     * @param middlewareMessage
     * @return
     */
    public boolean testIntegratedMiddlewareMessage(ZusiService service, String middlewareMessage) throws Exception {
        //middleware message object
        MessageMiddleware mm = service.getTranslator().toMiddlewareMessage(middlewareMessage);
        //0300-1301-0100::0100:11,0200:00,0300:01,0400:00,0500:00;;;hauptschalter;aus;taste n;?;zusi;#
        //zusi protocol transfer object
        ZusiEndpointMessage zpm = new ZusiEndpointMessage(mm.getGlobalId());
        //0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0
        //zusi data transfer object
        ZusiProtocolNodeRoot root = service.getCommand().getInput(zpm);
        //decode to zusi hex stream
        String zusiHexStream = service.getEncoder().encode(root);
        //000000000200000000000a010000000001000400000001000b0004000000020000000400000003000100040000000400000006000000050000000000FFFFFFFFFFFFFFFFFFFFFFFF
        //get global id from hex stream
        String globalId = ZusiProtocolNodeHelper.getGlobalId(zusiHexStream, service);
        //build tree from global id
        ZusiProtocolNodeRoot cmpRoot =  ZusiProtocolNodeHelper.getRoot(globalId);

        return cmpRoot.equals(root);
    }

    /**
     *
     * @param stream
     * @param service
     * @return
     * @throws Exception
     */
    public boolean testIntegratedStream(ZusiService service, String stream) throws Exception {
        String globalId = ZusiProtocolNodeHelper.getGlobalId(stream, service);
        //zusi protocol transfer object
        ZusiEndpointMessage zpm = new ZusiEndpointMessage(globalId);
        //0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0
        //zusi data transfer object
        ZusiProtocolNodeRoot root = service.getCommand().getInput(zpm);
        //decode to zusi hex stream
        String zusiHexStream = service.getEncoder().encode(root);
        //000000000200000000000a010000000001000400000001000b0004000000020000000400000003000100040000000400000006000000050000000000FFFFFFFFFFFFFFFFFFFFFFFF
        //get global id from hex stream
        String globalId2 = ZusiProtocolNodeHelper.getGlobalId(zusiHexStream, service);
        //build tree from global id
        ZusiProtocolNodeRoot cmpRoot =  ZusiProtocolNodeHelper.getRoot(globalId2);

        return cmpRoot.equals(root);
    }


    /**
     *
     * @return true
     */
    public boolean testEncode(String stream, ZusiService service){
        String streamCmp = "";
        try {
            ZusiProtocolNodeRoot root = service.getDecoder().decode(stream);
            streamCmp = service.getEncoder().encode(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return streamCmp.equalsIgnoreCase(stream);
    }

    /**
     *
     * @return
     */
    private String getStreamInput_HauptschalterEin(){
        return "0003-0113-0001::0001:11,0002:00,0003:01,0004:2,0005:0";
    }


    /**
     *
     * @return
     */
    private String getStreamInput_HauptschalterAus(){
        return "0003-0113-0001::0001:11,0002:00,0003:01,0004:0,0005:0;;;hauptschalter;aus;taste n;?;zusi;#";
    }

    /**
     *
     * @return
     */
    private String getStreamInput_StromabnehmerHeben(){
        return "0003-0113-0001::0001:2B,0002:00,0003:07,0004:1,0005:0";
    }

    /**
     *
     * @return
     */
    private String getStreamInput_RichtungsschalterVorwärts(){
        return "0003-0113-0001::0001:07,0002:00,0003:03,0004:2,0005:0";
    }

    /**
     *
     * @return
     */
    public String getStreamConnect() {
        String message =
                "000000000100"+"000000000100"+"0400000001000200"+"0400000002000200"+"0A00000003004661687270756C74"+"050000000400322E30"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String getStreamOk() {
        String message =
                "000000000200"+"000000000300"+"000000000A00"+"0400000001000100"+"0400000001001B00"+"FFFFFFFF"+"FFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String getStreamNok() {
        String message =
                "00"+"0200"+"00000000"+"0300"+"00000000"+"0A00"+"04000000"+"0100"+"0100"+"04000000"+"0100"+"1B00"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    /**
     *
     * @return
     */
    public String getStreamOkAck() {
        String message =
                "000000000200"+"000000000400"+"03000000010000"+"FFFFFFFF"+"FFFFFFFF";
        return message;
    }

    public String getStreamOkNoData(){
        String message =
                "000000000200"+"000000000a00"+"ffffffffffffffff";
        return message;
    }


}
