package ch.desm.middleware.app.core.component.simulation.zusi.protocol.node;

import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sebastian on 06.03.2015.
 */
public class ZusiProtocolNode extends ZusiProtocolNodeBase {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNode.class);

    private ZusiProtocolNode prevNode;
    private String node;
    private String id;
    private String data;

    /**
     * only root node
     */
    public ZusiProtocolNode(){

    }

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
    public ZusiProtocolNode(ZusiProtocolNode prevNode, String id, String data){
        this.prevNode = prevNode;
        this.node = ZusiProtocolNodeHelper.getNodeHex(data);
        this.id = id;
        this.data = data;
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
        return node!= null && node.equals(ZusiProtocolConstants.NODE_START);
    }

    public boolean isParameterNode(){
        return !data.isEmpty();
    }

    public String getStream(){
        return node+id+data;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof ZusiProtocolNode)){
            return false;
        }
        ZusiProtocolNode cmp = (ZusiProtocolNode) o;
        boolean b = this.equals(cmp);
        if(b) b = b && (this.getNodes().equals(cmp.getNodes()));
        if(b) b = b && traverse(b, nodes, cmp.getNodes());

        return b;
    }

    /**
     *
     * @param n
     * @return
     */
    private boolean equals(ZusiProtocolNode n){
        boolean val = (this.getNode()== null && n.getNode()== null) || this.getNode().equalsIgnoreCase(n.getNode());
        val = val && ((this.getId() == null && n.getId() == null) || this.getId().equalsIgnoreCase(n.getId()));
        val = val && ((this.getData() == null && n.getData() == null) || this.getData().equalsIgnoreCase(n.getData()));
        return val;
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


    /**
     *
     * @param nodes
     * @return
     */
    private String traverse(List<ZusiProtocolNode> nodes){
        Iterator<ZusiProtocolNode> iter = nodes.iterator();
        String s="";
        while(iter.hasNext()){
            ZusiProtocolNode node = iter.next();
            s += "\n" + node.toString();
            traverse(node.getNodes());
        }

        return s;
    }

    public String toString(){
        return "node: " + node + ", id: " + id + ", data: " + data + traverse(nodes);
    }
}

