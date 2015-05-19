package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebastian on 06.03.2015.
 */
public abstract class ZusiProtocolNodeBase {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeBase.class);

    /**
     *
     */
    protected LinkedList<ZusiProtocolNode> nodes;

    /**
     *
     */
    public ZusiProtocolNodeBase(){
        nodes = new LinkedList<ZusiProtocolNode>();
    }

    /**
     *
     * @param n
     */
    public void addNode(ZusiProtocolNode n){
        nodes.add(n);
    }

    /**
     *
     * @return
     */
    protected LinkedList<ZusiProtocolNode> getNodes(){
        return nodes;
    }

}

