package ch.desm.middleware.module.desm.simulation.zusi.message;

import ch.desm.middleware.module.desm.simulation.zusi.ZusiEndpointTcpClient;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 06.12.2014.
 */
public class ZusiMessageProtocolStream {

    private static Logger LOGGER = Logger.getLogger(ZusiEndpointTcpClient.class);

    private String stream;

    public ZusiMessageProtocolStream() {
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
