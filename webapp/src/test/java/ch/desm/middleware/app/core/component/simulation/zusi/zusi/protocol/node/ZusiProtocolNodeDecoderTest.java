package ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNode;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeDecoder;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelper;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolNodeDecoderTest extends ZusiProtocolNodeDecoder {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeDecoderTest.class);

    public boolean testGetNodeStream(String stream, boolean encap, ZusiProtocolNode node){
        String cmp = ZusiProtocolNodeHelper.getNodeStream(encap, node).replace("#", "");
        return cmp.equalsIgnoreCase(stream);
    }

}
