package ch.desm.middleware.app.module.tyrusclient;

import ch.desm.middleware.app.module.tyrusclient.middleware.ManagementServiceStart;
import ch.desm.middleware.app.module.tyrusclient.reference.TyrusClientStart;

public class Start {

    public static void main(String [] args){

        TyrusClientStart.connect();
        //ManagementServiceStart.start();
    }


}