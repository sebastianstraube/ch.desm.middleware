package ch.desm.middleware.app.core;

import org.apache.log4j.Logger;

public class StartAppMain {

    private static Logger LOGGER = Logger.getLogger(StartAppMain.class);

    public static void main(String[] args){
        StartAppSingleton main = StartAppSingleton.getSingleton();
        main.start();
        main.doHangout();
    }
}
