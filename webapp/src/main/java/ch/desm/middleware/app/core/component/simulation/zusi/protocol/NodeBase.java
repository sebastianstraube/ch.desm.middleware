package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import java.util.LinkedList;

/**
 * Created by Sebastian on 06.03.2015.
 */
// listNodes contains message structure
// one message in listNodes is one message for transfer
 class NodeBase {

    /**
     *
     */
    protected LinkedList<Node> nodes;

    /**
     *
     */
    public NodeBase(){
        nodes = new LinkedList<>();
    }

    /**
     *
     * @param n
     */
    public void addNode(Node n){
        nodes.add(n);
    }

}
