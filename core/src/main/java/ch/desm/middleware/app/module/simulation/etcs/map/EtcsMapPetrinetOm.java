package ch.desm.middleware.app.module.simulation.etcs.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

/**
 * Created by Sebastian on 28.11.2014.
 */
public class EtcsMapPetrinetOm extends ComponentMapBase {

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    protected void init(){
    }
}
