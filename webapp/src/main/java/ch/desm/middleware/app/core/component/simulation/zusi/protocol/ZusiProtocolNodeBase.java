package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import java.util.LinkedList;

/**
 * Created by Sebastian on 06.03.2015.
 */
// listNodes contains message structure
// one message in listNodes is one message for transfer
 class ZusiProtocolNodeBase {

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

}
