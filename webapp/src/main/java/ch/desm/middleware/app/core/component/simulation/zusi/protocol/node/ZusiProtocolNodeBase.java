package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sebastian on 06.03.2015.
 */
public abstract class ZusiProtocolNodeBase {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeRoot.class);

    /**
     *
     */
    protected LinkedList<ZusiProtocolNode> nodes;

    /**
     *
     */
    public ZusiProtocolNodeBase(){
        nodes = new LinkedList<>();
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

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof ZusiProtocolNodeBase)){
            return false;
        }
        ZusiProtocolNodeBase nodeCmp = (ZusiProtocolNodeBase) o;
        boolean b = nodes.size() == nodeCmp.getNodes().size();
        if(b) b = b && traverse(b, nodes, nodeCmp.getNodes());

        return b;
    }

    /**
     *
     * @param b
     * @param nodes
     * @param nodesCmp
     * @return
     */
    private boolean traverse(boolean b, List<ZusiProtocolNode> nodes, List<ZusiProtocolNode> nodesCmp){
        Iterator<ZusiProtocolNode> iter = nodes.iterator();
        Iterator<ZusiProtocolNode> iterCmp = nodesCmp.iterator();
        b = b && (iter.hasNext() == iterCmp.hasNext());
        while(b && iter.hasNext() && iterCmp.hasNext()){
            ZusiProtocolNode node = iter.next();
            ZusiProtocolNode nodeCmp = iterCmp.next();
            b = b && node.equals(nodeCmp);
            if(!b) break;
            b = b && traverse(b, node.getNodes(), nodeCmp.getNodes());
        }

        return b;
    }



}

