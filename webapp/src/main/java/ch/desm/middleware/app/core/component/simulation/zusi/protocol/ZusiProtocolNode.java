package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;

/**
 * Created by Sebastian on 06.03.2015.
 */
class ZusiProtocolNode extends ZusiProtocolNodeBase {
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
    public ZusiProtocolNode(int id){
        this(id, "");
    }

    /**
     *
     * @param hexId
     */
    public ZusiProtocolNode(String hexId){
        this(Integer.valueOf(hexId, 16), "");
    }

    /**
     *
     * @param hexId
     */
    public ZusiProtocolNode(String hexId, String data){
        this(Integer.valueOf(hexId, 16), data);
    }

    /**
     *
     * @param id
     * @param data
     */
    public ZusiProtocolNode(int id, String data){
        this.id = id;
        this.data = convertData(data);
        this.nrBytes = data.length() + (data.isEmpty() ? 0 : 2);
    }

    /**
     *
     * @param id
     * @param data
     */
    public ZusiProtocolNode(int id, int data){
        this.id = id;
        this.data = getArray(data);
        this.nrBytes = (this.data.length*2) + (data==0 ? 0 : 2);
    }

    /**
     *
     * @param data
     * @return
     */
    public int[] convertData(String data){
        int dataArray[]= new int[data.length()];
        for(int i=0; i<data.length();i++){
            dataArray[i] = Integer.valueOf(data.charAt(i));
        }

        return dataArray;
    }

    public void setData(String data){
        this.data = convertData(data);
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
     * @param data
     * @return
     */
    private int[] getArray(int data){
        int[] a = new int[1];
        a[0] = data;

        return a;
    }

}

