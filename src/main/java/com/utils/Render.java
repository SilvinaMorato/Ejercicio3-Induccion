package com.utils;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class Render {

    public static ModelAndView RenderView (Request req, Response res) throws Exception{
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView(model, "/form-3" );
    }


}
