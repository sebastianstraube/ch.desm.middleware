package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.utility.UtilConvertingHex;
import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 06.03.2015.
 */
class ZusiProtocolNode extends ZusiProtocolNodeBase {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolNodeBase.class);

    public static final int BYTE_LENGTH_BYTE = 1;
    public static final int BYTE_LENGTH_SHORTINT = 1;
    public static final int BYTE_LENGTH_WORD = 2;
    public static final int BYTE_LENGTH_SMALLINT = 2;
    public static final int BYTE_LENGTH_INTEGER = 4;
    public static final int BYTE_LENGTH_SINGLE = 4;
    public static final int BYTE_LENGTH_DOUBLE = 8;
    public static final int BYTE_LENGTH_NODEID = 2;
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
    private int[] dataArray;

    /**
     *
     */
    private String data;

    /**
     *
     */
    private boolean isDataStream;

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
    public ZusiProtocolNode(String hexId, String dataArray){
        this(Integer.valueOf(hexId, 16), dataArray);
    }

    /**
     *
     * @param id
     * @param data
     */
    public ZusiProtocolNode(int id, String data){
        this.isDataStream = true;
        this.id = id;
        this.data = data;
        this.dataArray = convertData(data);
        this.nrBytes = data.length();
    }

    /**
     *
     * @param id
     * @param data
     */
    public ZusiProtocolNode(int id, int data, int nrBytes){
        this.isDataStream = false;
        this.id = id;
        this.data = String.valueOf(data);
        this.dataArray = getDataArray(data, nrBytes);
        this.nrBytes = nrBytes;
    }

    /**
     *
     * @param data
     * @return
     */
    private int[] convertData(String data){
        int dataArray[]= new int[data.length()];

        for(int i=0; i<data.length();i++){
            dataArray[i] = Integer.valueOf(data.charAt(i));
        }

        return dataArray;
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
    public boolean isDataStream(){
        return isDataStream;
    }


    /**
     *
     * @return
     */
    public int[] getDataArray(){
        return dataArray;
    }

    /**
     *
     * @return
     */
    public String getDataHex(int length){
        return UtilConvertingHex.toHex(dataArray, length);
    }

    /**
     *
     * @return
     */
    public String getData(){
        return this.data;
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
    public String getIdHex(){
        return UtilConvertingHex.toHex(id, 4);
    }

    /**
     *
     * @param data
     * @return
     */
    private int[] getDataArray(int data, int length){
        int[] a = new int[length];
        for(int i=0; i<length;i++){
            if(i<length-1) {
                a[i] = 0;
            }else{
                a[i] = data;
            }
        }

        return a;
    }

}

