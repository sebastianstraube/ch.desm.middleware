package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import ch.desm.middleware.app.core.common.Pair;

import java.util.*;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiProtocolMessage {

    /**
     *
     */
    String stream;

    /**
     *
     */
    private String groupId;

    /**
     *
     */
    private List<Pair> parameterList;

    /**
     *
     * @param stream
     */
    public ZusiProtocolMessage(String stream){
        this.stream = stream;
        parseStream(stream);
    }

    /**
     *
     * @param stream
     */
    private void parseStream(String stream){
        groupId = stream.substring(0, stream.indexOf("::"));
        parameterList = new ArrayList<Pair>();

        stream = stream.substring(stream.indexOf("::")+2, stream.length());
        String[] parameter = stream.split(",");
        for(String el : parameter) {
            String key = el.substring(0, el.indexOf(":"));
            String value = el.substring(el.indexOf(":") + 1, el.length());
            parameterList.add(new Pair(key, value));
        }
    }

    public boolean hasGroupId(String id){
        return id.equalsIgnoreCase(groupId);
    }

    public boolean hasParameter(String key, String value){
        boolean hasParameter = false;
        for(Pair el : parameterList){
            if(el.getLeft().equals(key) && el.getRight().equals(value)){
                hasParameter = true;
            }
        }

        return hasParameter;
    }



}
