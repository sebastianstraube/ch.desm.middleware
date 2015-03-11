package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.Pair;

import java.util.*;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolMessage {

    public static final String DELIMITER_GROUP = "::";
    public static final String DELIMITER_GROUP_VALUE = "-";
    public static final String DELIMITER_PARAMETER = ",";
    public static final String DELIMITER_PARAMETER_VALUE = ":";

    /**
     *
     */
    private String stream;

    /**
     *
     */
    private String groupId;

    /**
     *
     */
    private List<Pair<String, String>> parameterList;

    /**
     *
     */
    public ZusiProtocolMessage(){
        this.stream = "";
        this.groupId ="";
        this.parameterList = new ArrayList<>();
    }

    /**
     *
     * @param stream e.g. 0003-0113-0001::0001:07,0002:00,0003:03,0004:2,0005:0
     */
    public ZusiProtocolMessage(String stream){
        setStream(stream);
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean hasGroupId(String id){
        return id.equalsIgnoreCase(groupId);
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public boolean hasParameter(String key, String value){
        boolean hasParameter = false;
        for(Pair el : parameterList){
            if(el.getLeft().equals(key) && el.getRight().equals(value)){
                hasParameter = true;
            }
        }

        return hasParameter;
    }

    /**
     *
     * @param stream
     */
    public void setStream(String stream){
        this.stream = stream;
        parseStream(stream);
    }

    /**
     *
     * @return
     */
    public String getGroupId(){
        return this.groupId;
    }

    /**
     *
     * @return
     */
    public String[] getGroupIdAsArray(){
        return this.groupId.split(DELIMITER_GROUP);
    }

    /**
     *
     * @return
     */
    public List<Pair<String, String>> getParameterList(){
        return this.parameterList;
    }

    /**
     * e.g. 0003-0113-0001::0001:07,0002:00,0003:03,0004:2,0005:0
     * @param stream
     */
    private void parseStream(String stream){
        parameterList = new ArrayList<>();

        if(stream.contains(DELIMITER_GROUP) &&
                stream.contains(DELIMITER_PARAMETER) &&
                stream.contains(DELIMITER_PARAMETER_VALUE)){
            groupId = stream.substring(0, stream.indexOf(DELIMITER_GROUP));
            stream = stream.substring(stream.indexOf(DELIMITER_GROUP)+DELIMITER_GROUP.length(), stream.length());
            String[] parameter = stream.split(DELIMITER_PARAMETER);
            for(String el : parameter) {
                String key = el.substring(0, el.indexOf(DELIMITER_PARAMETER_VALUE));
                String value = el.substring(el.indexOf(DELIMITER_PARAMETER_VALUE) + 1, el.length());
                parameterList.add(new Pair(key, value));
            }
        }else{
            groupId = stream;
        }
    }
}
