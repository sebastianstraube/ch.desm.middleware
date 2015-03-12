package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolCommandFrom {

    private static final String GROUPID_COMMAND = "0002-000A";

    /**
     *
     * @param service
     * @param globalId
     * @return
     */
    public String getCommandStream(ZusiService service, String globalId) throws Exception {
        ZusiProtocolNodeBase root = service.getProtocolService().getRoot(globalId);
        String stream = service.getProtocolService().decode(root);
        return stream;
    }

    public static boolean isCommandInput(ZusiProtocolMessage message){
        return message.hasGroupId(GROUPID_COMMAND);
    }


}
