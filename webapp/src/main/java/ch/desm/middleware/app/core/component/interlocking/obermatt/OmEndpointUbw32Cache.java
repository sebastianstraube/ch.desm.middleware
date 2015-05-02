package ch.desm.middleware.app.core.component.interlocking.obermatt;

import java.util.HashMap;

/**
 * Created by Sebastian on 22.11.2014.
 */
public class OmEndpointUbw32Cache {

    HashMap<String ,String>  state;

    public OmEndpointUbw32Cache(){
        state = new HashMap<String, String>();
    }

    private boolean isStateAvailable(String key){
        return state.get(key) != null;
    }

    public boolean isStateChanged(String key, String value){

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
