package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 06.03.2015.
 */
public class ZusiProtocolNode extends ZusiProtocolNodeBase {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeRoot.class);

    private String node;
    private String id;
    private String data;

    /**
     *
     * @param stream
     */
    public ZusiProtocolNode(String stream){
        this.node = ZusiProtocolNodeHelper.getNode(stream);
        this.id = ZusiProtocolNodeHelper.getId(stream);
        this.data = ZusiProtocolNodeHelper.getData(stream);
    }

    /**
     *
     * @param id
     * @param data
     */
    public ZusiProtocolNode(String id, String data){
        this.node = ZusiProtocolNodeHelper.getNodeHex(data);
        this.id = id;
        this.data = data;
    }

    public String getNode(){
        return node;
    }

    public String getId(){
        return id;
    }

    public String getData(){
        return data;
    }

    public boolean isStartNode(){
        return node.equals(ZusiProtocolConstants.NODE_START);
    }

    public String getStream(){
        return node+id+data;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ZusiProtocolNode)){
            return false;
        }

        ZusiProtocolNode n = (ZusiProtocolNode) o;
        boolean val = this.node.equalsIgnoreCase(n.getNode());
        val = val && this.id.equalsIgnoreCase(n.getId());
        val = val && this.data.equalsIgnoreCase(n.getData());
        return val;
    }
}

