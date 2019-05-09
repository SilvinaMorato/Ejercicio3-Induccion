package com;

import com.config.ConfigAccess;
import com.config.ConfigSpark;

import com.mercadopago.exceptions.MPException;
import com.routers.RestEndInit;

public class Main {

    public static void main (String[] arg) throws MPException{

        ConfigSpark.sparkConfig();
        ConfigAccess.accessConfig();
        /**
         * Initialize the application
         */
        new RestEndInit().init();



    }
}
