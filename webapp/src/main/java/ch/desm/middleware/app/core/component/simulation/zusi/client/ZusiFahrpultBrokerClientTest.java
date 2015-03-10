package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;

/**
 * Created by Sebastian on 10.03.2015.
 */
public class ZusiFahrpultBrokerClientTest {

    ZusiService service;

    public ZusiFahrpultBrokerClientTest(ZusiService service){
        this.service = service;
    }

    public void testPrepareTrain(){

        service.getBrokerClient().emulateBrokerMessage(getStreamInput_HauptschalterAus());
/*
        service.getBrokerClient().emulateBrokerMessage(getStreamInput_HauptschalterEin());
        service.getBrokerClient().emulateBrokerMessage(getStreamInput_StromabnehmerHeben());
        service.getBrokerClient().emulateBrokerMessage(getStreamInput_RichtungsschalterVorwärts());
*/
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
}
