package com.utils;

import spark.Request;

import java.io.IOException;

public class RequesUtil {

    private RequesUtil(){};

    public static <T> T getBodyParameter(Request request, Class<T> tClass) throws IOException {

        return (Json.INSTANCE.requestToMap(request.body(),tClass ));
    }



}
