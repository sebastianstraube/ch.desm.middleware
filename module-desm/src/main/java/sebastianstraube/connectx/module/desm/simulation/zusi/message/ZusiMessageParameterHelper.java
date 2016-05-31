package sebastianstraube.connectx.module.desm.simulation.zusi.message;

import sebastianstraube.connectx.module.desm.simulation.zusi.ZusiService;
import sebastianstraube.connectx.module.desm.simulation.zusi.protocol.ZusiProtocolConstants;
import sebastianstraube.connectx.core.common.UtilityHex;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.text.NumberFormat;

/**
 * Created by Sebastian on 09.04.2015.
 */
public class ZusiMessageParameterHelper {

    private static Logger LOGGER = Logger.getLogger(ZusiMessageEndpoint.class);

    public static final String ZUSINUMBERFORMAT_SINGLE = "ZUSI_NUMBERFORMAT_SINGLE";
    public static final String ZUSINUMBERFORMAT_STRING = "ZUSI_NUMBERFORMAT_STRING";

    private NumberFormat numberFormat;
    private ZusiService service;

    public ZusiMessageParameterHelper(ZusiService service){
        this.service = service;
        numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumFractionDigits(0);
    }

    public String getNumber(String globalId, String parameter){
        String format = service.getZusiMapParameterDataType().getValueForKey(globalId);

        switch(format){
            case ZUSINUMBERFORMAT_SINGLE: {
                float val = UtilityHex.getFloat(parameter);
                val = getVal(globalId, val);
                return String.valueOf(val);
            }
            case ZUSINUMBERFORMAT_STRING: {
                String val = UtilityHex.getCharStream(parameter);
                return val;
            }
            default: LOGGER.log(Level.TRACE, "unsupported numberformat with globalId: " + globalId + ", parameter: " + parameter);
        }
        return "";
    }

    private float getVal(String globalId, float val){
        String type = service.getZusiMapParameter().getValueForKey(globalId);
        switch(type){
            case(ZusiProtocolConstants.MAP_PARAMETER_VALUE_GESCHWINDIGKEIT):{
                val = val * 3.6f;
                Float.valueOf(numberFormat.format(val));
                break;
            }
        }

        return val;
    }
}
