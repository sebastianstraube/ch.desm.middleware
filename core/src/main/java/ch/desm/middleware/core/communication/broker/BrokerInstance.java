package ch.desm.middleware.core.communication.broker;

/**
 * Created by Sebastian on 08.05.2016.
 */
public final class BrokerInstance {

    private static Broker instance = null;

    public static Broker getSingleton() {
        if(instance == null) instance = new Broker();
        return instance;
    }




}
