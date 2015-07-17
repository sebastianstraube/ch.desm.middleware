package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.common.HexTranslator;
import ch.desm.middleware.app.core.communication.message.MessageMiddleware;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 05.04.2015.
 */
public class ZusiProtocolNodeHelperTest extends ZusiProtocolNodeHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeHelperTest.class);

    public ZusiProtocolNodeHelperTest(ZusiService service){
        super(service);
    }
    /**
     *
     * @param stream
     * @return
     */
    public boolean testEncodeDecodeNodeGlobalId(String stream, ZusiService service) throws Exception {
        ZusiProtocolNode root = null;
        String encoded = null;
        root = service.getCodec().decode(stream);
        encoded = service.getCodec().encode(root);
        root = service.getCodec().decode(encoded);

        String globalId = service.getZusiProtocolNodeHelper().getGlobalId(root).get(0);
        ZusiProtocolNode rootCmp = getRoot(globalId);
        String globalIdTest = getGlobalId(rootCmp).get(0);

        return globalId.equalsIgnoreCase(globalIdTest);
    }

    /**
     *
     * @param stream
     * @return
     */
    public boolean testEncodeDecode(String stream, ZusiService service) throws Exception {
        ZusiProtocolNode root = null;
        String encoded = null;

        root = service.getCodec().decode(stream);
        encoded = service.getCodec().encode(root);

        return stream.equalsIgnoreCase(encoded);
    }

    /**
     *
     * @param globalId
     * @return
     */
    public boolean testGetRoot(String globalId){
        boolean test = false;

        ZusiProtocolNode root1 = getRoot(globalId);
        String globalId1 = getGlobalId(root1).get(0);
        test = globalId.equalsIgnoreCase(globalId1);

        return test;
    }

    /**
     *
     * @param globalId
     * @return
     */
    public boolean testGetRootIntegrated(String globalId){
        boolean test = false;

        ZusiProtocolNode root1 = getRoot(globalId);
        String globalId1 = getGlobalId(root1).get(0);
        boolean test1 = globalId.equalsIgnoreCase(globalId1);

        ZusiProtocolNode root2 = getRoot(globalId1);
        String globalId2 = getGlobalId(root2).get(0);
        boolean test2 = globalId.equalsIgnoreCase(globalId2);

        test = test1 && test2;

        return test;
    }

    /**
     *
     * @return
     */
    public boolean testEncodeDecodeRegisterFahrpult(ZusiService service, String stream) throws Exception {

        boolean isGood = false;

        ZusiProtocolNode root = service.getCodec().decode(stream);
        String encodeFromZusi = service.getCodec().encode(root);

        ZusiProtocolNode root2 = new ZusiProtocolNode();
        ZusiProtocolNode start = new ZusiProtocolNode(root2, "0100", "");
        ZusiProtocolNode hello = new ZusiProtocolNode(start, "0100", "");
        ZusiProtocolNode protocolVersion = new ZusiProtocolNode(hello, "0100", "0200");
        ZusiProtocolNode clientType = new ZusiProtocolNode(protocolVersion, "0200", "0200");

        String datafahrpult = HexTranslator.toHex("Fahrpult");
        String dataVersion = HexTranslator.toHex("2.0");
        ZusiProtocolNode text = new ZusiProtocolNode(clientType, "0300", datafahrpult);
        ZusiProtocolNode version = new ZusiProtocolNode(text, "0400", dataVersion);

        root2.addNode(start);
        start.addNode(hello);
        hello.addNode(protocolVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);

        String encodeFromMiddleware = service.getCodec().encode(root2);
        if (encodeFromZusi.equalsIgnoreCase(encodeFromMiddleware)) isGood = true;

        return isGood;
    }

    /**
     *
     * @return
     */
    public boolean testEncodeDecodeNeededDataFahrpult(ZusiService service, String s) throws Exception {
        ZusiProtocolNode root = new ZusiProtocolNode();
        ZusiProtocolNode client_fahrpult = new ZusiProtocolNode(root, "0200", "");
        ZusiProtocolNode needed_data = new ZusiProtocolNode(client_fahrpult, "0300", "");
        ZusiProtocolNode fuehrerstandsAnzeigen = new ZusiProtocolNode(needed_data, "0A00", "");
        ZusiProtocolNode geschwindigkeit = new ZusiProtocolNode(fuehrerstandsAnzeigen, "0100", "0100");

        root.addNode(client_fahrpult);
        client_fahrpult.addNode(needed_data);
        needed_data.addNode(fuehrerstandsAnzeigen);
        fuehrerstandsAnzeigen.addNode(geschwindigkeit);

        String cmp = service.getCodec().encode(root);

        return s.equalsIgnoreCase(cmp);
    }

    /**
     *
     * @return
     */
    public boolean testCmpZusiProtocolNodeBase(){

        ZusiProtocolNode root1 = new ZusiProtocolNode();
        ZusiProtocolNode root1_client_fahrpult = new ZusiProtocolNode(root1, "0200", "");
        ZusiProtocolNode root1_needed_data = new ZusiProtocolNode(root1_client_fahrpult, "0300", "");
        ZusiProtocolNode root1_fuehrerstandsAnzeigen = new ZusiProtocolNode(root1_needed_data, "0A00", "");
        ZusiProtocolNode root1_geschwindigkeit = new ZusiProtocolNode(root1_fuehrerstandsAnzeigen, "0100", "0100");

        ZusiProtocolNode root2 = new ZusiProtocolNode();
        ZusiProtocolNode root2_client_fahrpult = new ZusiProtocolNode(root2, "0200", "");
        ZusiProtocolNode root2_needed_data = new ZusiProtocolNode(root2_client_fahrpult, "0300", "");
        ZusiProtocolNode root2_fuehrerstandsAnzeigen = new ZusiProtocolNode(root2_needed_data, "0A00", "");
        ZusiProtocolNode root2_geschwindigkeit = new ZusiProtocolNode(root2_fuehrerstandsAnzeigen, "0100", "0100");

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
        ZusiProtocolNode n1 = new ZusiProtocolNode(null, "0A0", "");
        ZusiProtocolNode n2 = new ZusiProtocolNode(null, "0A00", "");
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
        //zusi data transfer object
        ZusiProtocolNode root = service.getZusiProtocolNodeHelper().getRoot(mm.getGlobalId());
        //decode to zusi hex stream
        String zusiHexStream = service.getCodec().encode(root);
        //000000000200000000000a010000000001000400000001000b0004000000020000000400000003000100040000000400000006000000050000000000FFFFFFFFFFFFFFFFFFFFFFFF
        //get global id from hex stream
        String globalId = service.getZusiProtocolNodeHelper().getGlobalId(zusiHexStream).get(0);
        //build tree from global id
        ZusiProtocolNode cmpRoot =  service.getZusiProtocolNodeHelper().getRoot(globalId);

        return cmpRoot.equals(root);
    }

    /**
     *
     * @param stream
     * @param service
     * @return
     * @throws Exception
     */
    public boolean testIntegratedInputStream(ZusiService service, String stream) throws Exception {
        String globalId = service.getZusiProtocolNodeHelper().getGlobalId(stream).get(0);
        //zusi data transfer object
        ZusiProtocolNode root = service.getZusiProtocolNodeHelper().getRoot(globalId);
        //decode to zusi hex stream
        String zusiHexStream = service.getCodec().encode(root);
        //000000000200000000000a010000000001000400000001000b0004000000020000000400000003000100040000000400000006000000050000000000FFFFFFFFFFFFFFFFFFFFFFFF
        //get global id from hex stream
        String globalId2 = service.getZusiProtocolNodeHelper().getGlobalId(zusiHexStream).get(0);
        //build tree from global id
        ZusiProtocolNode cmpRoot =  service.getZusiProtocolNodeHelper().getRoot(globalId2);

        boolean b = globalId.equalsIgnoreCase(globalId2);
        if(b) b = b && (cmpRoot.equals(root));
        return  b;
    }


    /**
     *
     * @return true
     */
    public boolean testDecodeEncode(String stream, ZusiService service) throws Exception {
        String streamCmp = "";
        ZusiProtocolNode root = service.getCodec().decode(stream);
        streamCmp = service.getCodec().encode(root);

        return streamCmp.equalsIgnoreCase(stream);
    }

    public boolean testGetGlobalId(String stream, String globalId) throws Exception {
        String testGlobalId = getGlobalId(stream).get(0);
        return globalId.equalsIgnoreCase(testGlobalId);
    }

}
