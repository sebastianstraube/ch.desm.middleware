package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;

/**
 * Created by Sebastian on 10.03.2015.
 */
public class ZusiAusbildungBrokerClientTest {

    ZusiService service;

    public ZusiAusbildungBrokerClientTest(ZusiService service){
        this.service = service;
    }

    public void testStream(){

        service.getBrokerClientAusbildung().emulateBrokerMessage(testStreamInput_HauptschalterEin());
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
    private String testStreamInput_HauptschalterEin(){
        return "0002-010a-0001::0001:11,0002:00,0003:07,0004:02,0005:0000;;;hauptschalter;ein;taste h;on;zusi;#";
    }

    /**
     *
     * @return
     */
    private String testStreamInput_HauptschalterAus(){
        return "0002-010a-0001::0001:11,0002:00,0003:07,0004:00,0005:0000;;;hauptschalter;ein;taste h;on;zusi;#";
    }

    /**
     *
     * @return
     */
    private String testStreamInput_StromabnehmerHeben(){
        return "";
    }

    /**
     *
     * @return
     */
    private String testStreamInput_RichtungsschalterVorwärts(){
        return "";
    }
}
