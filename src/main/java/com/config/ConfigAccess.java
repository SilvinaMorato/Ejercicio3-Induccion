package com.config;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;

public class ConfigAccess {

    private static final  String ACCESS_TOKEN ="TEST-8149926617663342-050809-cebb6d6ab90f5927b89e686f88c6c678-405890407";
    private static final  String CLIENT_SECRET="v40NsuhLzXhWEUG9oBYFcBux4Kt50bQm";
    private static final String CLIENT_ID= "8149926617663342";

 //Method of access Configuration

    public static void accessConfig() throws MPException {

       MercadoPago.SDK.setClientSecret(CLIENT_SECRET);
       MercadoPago.SDK.setClientId(CLIENT_ID);
       MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);

       System.out.println("Credenciales OK");
    }


    public static String getAccessToken() {
        return ACCESS_TOKEN;
    }

    public static String getClientSecret() {
        return CLIENT_SECRET;
    }

    public static String getClientId() {
        return CLIENT_ID;
    }
}
