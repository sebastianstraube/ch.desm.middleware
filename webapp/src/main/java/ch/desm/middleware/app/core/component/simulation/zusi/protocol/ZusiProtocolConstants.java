package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolConstants {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolConstants.class);

    protected static final String NODE_END = "FFFFFFFF";
    protected static final String NODE_START = "00000000";
    protected static final String CLIENT_TYPE = "DESM-Middleware";
    protected static final String CLIENT_VERSION = "1.0";
}
