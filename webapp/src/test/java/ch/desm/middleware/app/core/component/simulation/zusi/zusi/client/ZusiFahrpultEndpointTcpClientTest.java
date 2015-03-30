package ch.desm.middleware.app.core.component.simulation.zusi.zusi.client;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;

/**
 * Created by Sebastian on 10.03.2015.
 */
public class ZusiFahrpultEndpointTcpClientTest {

    private ZusiService service;

    public ZusiFahrpultEndpointTcpClientTest(ZusiService service){
        this.service = service;
    }

    public void testStream(){

        service.getEndpointFahrpult().emulateEndpointMessage(testStreamInput_Geschwindigkeit());

    }


    /**
     *
     * @return
     */
    private String testStreamInput_Geschwindigkeit(){
        return "000000000200000000000a00060000000100c3b9273effffffffffffffff";
    }

}
