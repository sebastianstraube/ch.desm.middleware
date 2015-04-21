package ch.desm.middleware.app.core.component.simulation.zusi.message;

import ch.desm.middleware.app.core.common.Pair;
import ch.desm.middleware.app.core.component.simulation.zusi.protocol.ZusiProtocolConstants;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Sebastian on 09.03.2015.
 */
public class ZusiMessageEndpoint {

    private static Logger LOGGER = Logger.getLogger(ZusiMessageEndpoint.class);

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
     * @param stream e.g. 0003-0113-0001::0001:07,0002:00,0003:03,0004:2,0005:0
     */
    public ZusiMessageEndpoint(String stream){
        setStream(stream);
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean hasGroupId(String id){
        return groupId.toUpperCase().startsWith(id.toUpperCase());
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
        return this.groupId.split(ZusiProtocolConstants.DELIMITER_GROUP);
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

        if(stream.contains(ZusiProtocolConstants.DELIMITER_GROUP) &&
                stream.contains(ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE)){
            groupId = stream.substring(0, stream.indexOf(ZusiProtocolConstants.DELIMITER_GROUP));
            stream = stream.substring(stream.indexOf(ZusiProtocolConstants.DELIMITER_GROUP)+ZusiProtocolConstants.DELIMITER_GROUP.length(), stream.length());

            String[] parameter = stream.split(ZusiProtocolConstants.DELIMITER_PARAMETER);
            if(parameter.length <= 0){
                parameter = new String[1];
                parameter[0] = stream.substring(stream.indexOf(ZusiProtocolConstants.DELIMITER_GROUP)+2, stream.length());
            }
            for(String el : parameter) {
                String key = el.substring(0, el.indexOf(ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE));
                String value = el.substring(el.indexOf(ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE) + 1, el.length());
                parameterList.add(new Pair(key, value));
            }
        }else{
            groupId = stream;
        }
    }

    @Override
    public String toString(){
        String s = this.getGroupId() + ZusiProtocolConstants.DELIMITER_GROUP;

        for(Pair<String, String> el : parameterList){
            s+= el.getLeft();
            s+= ZusiProtocolConstants.DELIMITER_PARAMETER_VALUE;
            s+= el.getRight();
            s+= ZusiProtocolConstants.DELIMITER_PARAMETER;
        }

        return s.substring(0, s.length()-1);
    }
}
