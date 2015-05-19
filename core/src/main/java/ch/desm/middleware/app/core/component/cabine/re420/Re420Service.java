package ch.desm.middleware.app.core.component.cabine.re420;

import ch.desm.middleware.app.core.communication.broker.Broker;
import ch.desm.middleware.app.core.communication.endpoint.serial.EndpointRs232;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiBrokerClient;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiEndpointTcpClient;

/**
 * Created by Sebastian on 11.04.2015.
 */
public class Re420Service {

    private Re420BrokerClient broker;
    private Re420EndpointUbw32 endpointUbw;
    private Re420EndpointFabisch endpointFabisch;


    /**
     *
     * @param broker
     */
    public Re420Service(Broker broker, EndpointRs232.EnumSerialPorts ubw, EndpointRs232.EnumSerialPorts fabi){
        this.broker = new Re420BrokerClient(broker, this);
        this.endpointUbw = new Re420EndpointUbw32(ubw);
        this.endpointFabisch = new Re420EndpointFabisch(fabi);
    }

    public Re420EndpointUbw32 getendpointUbw(){
        return this.endpointUbw;
    }

    public Re420EndpointFabisch getendpointFabisch(){
        return this.endpointFabisch;
    }
}
