package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.component.simulation.zusi.client.ZusiFahrpultEndpointTcpClient;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiProtocolStream {

    private static Logger LOGGER = Logger.getLogger(ZusiFahrpultEndpointTcpClient.class);

    private String stream;

    public ZusiProtocolStream() {
        this.stream = "";
    }

    public void addStream(String message){
        this.stream += message;
    }

    public String getStream(){
        return stream;
    }

    public void setStream(String stream){
        this.stream = stream;
    }

    public void cutStream(int to){
        stream = stream.substring(to);
    }

}
