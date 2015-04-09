package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import com.sun.istack.internal.Nullable;
import org.apache.log4j.Logger;

import java.util.LinkedList;

/**
 * Created by Sebastian on 06.03.2015.
 */
public class ZusiProtocolNode extends ZusiProtocolNodeBase {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeRoot.class);

    @Nullable
    ZusiProtocolNode prevNode;

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
     * @param stream
     */
    public ZusiProtocolNode(ZusiProtocolNode prevNode, String stream){
        this.prevNode = prevNode;
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

    /**
     *
     * @param id
     * @param data
     */
    public ZusiProtocolNode(ZusiProtocolNode prevNode, String id, String data){
        this(id, data);
        this.prevNode = prevNode;
    }

    public void setPrevNode(ZusiProtocolNode prevNode){
        this.prevNode = prevNode;
    }

    public ZusiProtocolNode getPrevNode(){
        return this.prevNode;
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

    public boolean isParameterNode(){
        return !data.isEmpty();
    }

    public String getStream(){
        return node+id+data;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ZusiProtocolNode)) return false;
        ZusiProtocolNode n = (ZusiProtocolNode) o;
        boolean val = this.node.equalsIgnoreCase(n.getNode());
        val = val && this.id.equalsIgnoreCase(n.getId());
        val = val && this.data.equalsIgnoreCase(n.getData());
        return val;
    }
}

