package ch.desm.middleware.app.module.simulation.zusi.protocol.node;

import ch.desm.middleware.app.module.simulation.zusi.ZusiServiceTest;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolNodeCodecTest extends ZusiProtocolNodeCodec {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeCodecTest.class);

    public boolean testGetNodeStream(ZusiServiceTest service, String stream, boolean encap, ZusiProtocolNode node){
        String cmp = service.getZusiProtocolNodeHelperTest().getNodeStream(encap, node).replace("#", "");
        return cmp.equalsIgnoreCase(stream);
    }

    public boolean testGetNodeStream(String stream, boolean encap, ZusiProtocolNode node){
        String cmp = ZusiProtocolNodeHelper.getNodeStream(encap, node).replace("#", "");
        return cmp.equalsIgnoreCase(stream);
    }

    public boolean testEncode(ZusiProtocolNode root, String cmp){
        String stream = "";
        try {
            stream = encode(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cmp.equalsIgnoreCase(stream);
    }

}
