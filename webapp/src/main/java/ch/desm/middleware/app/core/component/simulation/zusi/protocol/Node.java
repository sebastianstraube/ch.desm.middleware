package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;

import java.util.Iterator;

/**
 * Created by Sebastian on 06.03.2015.
 */
class Node extends NodeBase {
    /**
     * id of node
     */
    private Integer id;

    /**
     * nr of hex bytes for en- and decoding e.g. (x0001) has 2 bytes
     */
    private int nrBytes;

    /**
     * data store, represented as int array
     */
    private int[] data;

    /**
     *
     * @param id
     */
    public Node(int id){
        this(id, "");
    }

    /**
     *
     * @param hexId
     */
    public Node(String hexId){
        this(Integer.valueOf(hexId, 16), "");
    }

    /**
     *
     * @param hexId
     */
    public Node(String hexId, String hexData){
        this(Integer.valueOf(hexId, 16), hexData);
    }

    /**
     *
     * @return
     */
    public int getNrBytes(){
        return nrBytes;
    }

    /**
     *
     * @return
     */
    public int[] getDataAsArray(){
        return data;
    }

    /**
     *
     * @return
     */
    public String getDataAsHex(){
        return UtilConvertingHex.toHex(data, 4);
    }

    /**
     *
     * @return
     */
    public Integer getId(){
        return id;
    }

    /**
     *
     * @return
     */
    public String getIdAsHex(){
        return UtilConvertingHex.toHex(id, 4);
    }

    /**
     *
     * @param id
     * @param data
     */
    public Node(int id, String data){
        this.id = id;
        this.data = new int[data.length()];
        for(int i=0; i<data.length();i++){
            this.data[i] = Integer.valueOf(data.charAt(i));
        }
        this.nrBytes = (this.data.length*2) + (data.isEmpty() ? 0 : 2);
    }

    /**
     *
     * @param id
     * @param data
     */
    public Node(int id, int data){
        this.id = id;
        this.data = getArray(data);
        this.nrBytes = (this.data.length*2) + (data==0 ? 0 : 2);
    }

    /**
     *
     * @param data
     * @return
     */
    private int[] getArray(int data){
        int[] a = new int[1];
        a[0] = data;

        return a;
    }
}

