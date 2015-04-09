package ch.desm.middleware.app.core.component.simulation.zusi.message;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.node.ZusiProtocolNodeHelperHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.text.NumberFormat;
import java.util.LinkedList;

/**
 * Created by Sebastian on 09.04.2015.
 */
public class ZusiParameterConverter {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointMessage.class);

    public static final String ZUSINUMBERFORMAT_SINGLE = "ZUSI_NUMBERFORMAT_SINGLE";
    public static final String ZUSINUMBERFORMAT_STRING = "ZUSI_NUMBERFORMAT_STRING";

    private NumberFormat numberFormat;
    private ZusiService service;

    public ZusiParameterConverter(ZusiService service){
        this.service = service;
        numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumFractionDigits(0);
    }

    public String getNumber(String globalId, String parameter){
        String format = service.getZusiMapParameter().getValue(globalId);

        switch(format){
            case ZUSINUMBERFORMAT_SINGLE: {
                float val = ZusiProtocolNodeHelperHex.getFloat(parameter);
                return numberFormat.format(val);
            }
            case ZUSINUMBERFORMAT_STRING: {
                String val = ZusiProtocolNodeHelperHex.getCharStream(parameter);
                return val;
            }
            default: LOGGER.log(Level.TRACE, "unsupported numberformat with globalId: " + globalId + ", parameter: " + parameter);
        }
        return "";
    }
}
