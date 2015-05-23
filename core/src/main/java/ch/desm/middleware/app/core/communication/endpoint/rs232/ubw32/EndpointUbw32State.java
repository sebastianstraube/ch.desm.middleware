package ch.desm.middleware.app.core.communication.endpoint.rs232.ubw32;

import java.util.HashMap;

/**
 * Created by Sebastian on 22.11.2014.
 */
public class EndpointUbw32State {

    HashMap<String ,String> state;

    public EndpointUbw32State(){
        state = new HashMap<String, String>();
    }

    private boolean isStateAvailable(String key){
        return state.get(key) != null;
    }

    public boolean hasChanged(String key, String value){

        boolean isChanged = false;
        if(isStateAvailable(key)){
            String cmpValue = state.get(key);

            if(!cmpValue.equals(value)){
                isChanged = true;
            }
        }else{
            isChanged = true;
        }

        //update the value of the key
        state.put(key, value);

        return isChanged;
    }


}
