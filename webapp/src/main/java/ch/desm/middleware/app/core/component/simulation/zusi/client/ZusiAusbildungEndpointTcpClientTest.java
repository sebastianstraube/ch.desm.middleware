package ch.desm.middleware.app.core.component.simulation.zusi.client;

import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;

/**
 * Created by Sebastian on 10.03.2015.
 */
public class ZusiAusbildungEndpointTcpClientTest {

    ZusiService service;

    public ZusiAusbildungEndpointTcpClientTest(ZusiService service){
        this.service = service;
    }

    public void testStream(){

        service.getEndpointAusbildung().emulateEndpointMessage(testStreamInput_Geschwindigkeit());

    }


    /**
     *
     * @return
     */
    private String testStreamInput_Geschwindigkeit(){
        return "000000000200000000000a00060000000100c3b9273effffffffffffffff";
    }

}
