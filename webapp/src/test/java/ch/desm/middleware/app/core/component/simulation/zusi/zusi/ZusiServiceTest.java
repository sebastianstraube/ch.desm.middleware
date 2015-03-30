package ch.desm.middleware.app.core.component.simulation.zusi.zusi;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import ch.desm.middleware.app.core.component.simulation.zusi.zusi.protocol.ZusiProtocolNodeProcessorTest;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class ZusiServiceTest extends ZusiService {

    private ZusiProtocolNodeProcessorTest zusiProtocolNodeConverterTest;
    /**
     *
     * @param broker
     * @param ip
     * @param port
     */
    public ZusiServiceTest(Broker broker, String ip, int port){
        super(broker, ip, port);
        this.zusiProtocolNodeConverterTest = new ZusiProtocolNodeProcessorTest(this);
    }

    /**
     *
     * @return
     */
    public ZusiProtocolNodeProcessorTest getZusiProtocolNodeConverterTest(){
        return zusiProtocolNodeConverterTest;
    }

}
