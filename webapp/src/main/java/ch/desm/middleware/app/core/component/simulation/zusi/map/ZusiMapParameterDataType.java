package ch.desm.middleware.app.core.component.simulation.zusi.map;

import ch.desm.middleware.app.core.component.common.ComponentMapBase;
import ch.desm.middleware.app.core.component.simulation.zusi.message.ZusiParameterConverter;

import java.text.NumberFormat;
import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiMapParameterDataType extends ComponentMapBase {

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    protected void init(){
        map.put("0300-1400-0100::0100", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0200", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0300", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0400", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0500", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0600", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0700", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0800", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0900", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0300-1400-0100::0a00", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0100-0200::0100", ZusiParameterConverter.ZUSINUMBERFORMAT_STRING);
        map.put("0200-0a00::0100", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0200-0a00::1900", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0200-0a00::5500", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
        map.put("0200-0a00::1300", ZusiParameterConverter.ZUSINUMBERFORMAT_SINGLE);
    }

}
