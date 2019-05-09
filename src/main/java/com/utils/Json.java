package com.utils;

import com.dto.PaymentDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;



public enum Json {
    INSTANCE;


    public final ObjectMapper mapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public String convertToMap(String string)throws IOException{
        String body = string;
        if (body.length () == 0) {
            return  null;
        }
        if(isJSON(string)) {
            return  string;
        }

        Map<String,Object> map = asMap(body);
         return mapper.writeValueAsString(map);

    }

    private static  Map<String,Object> asMap(String body)throws UnsupportedEncodingException {

        Map<String,Object> map = new LinkedHashMap<>();

        String strDecoded = URLDecoder.decode( body, StandardCharsets.UTF_8.name());
        for ( String  keyValue : strDecoded.trim().split( "&" )){
            String[] tokens = keyValue.trim().split( "=" );
            String key = tokens[0];
            String value = tokens.length ==1 ? null : tokens[1];

            String[] keys = key.split("\\.");
            Map<String, Object> pointer = map;

            for(int i = 0; i < keys.length - 1; i++) {
                String currentKey = keys[i];

                Map<String, Object> nested = (Map<String, Object>) pointer.get(currentKey);

                if(nested == null) {
                    nested = new LinkedHashMap<>();
                }

                pointer.put(currentKey, nested);
                pointer = nested;
            }

            pointer.put(keys[keys.length - 1], value);

        }


    return map;

    }

    /**
     *
     * @param string
     * @param tClass
     * @param <T>
     * @return mapper
     * @throws Exception
     */
    public <T> T requestToMap(String string, Class<T> tClass) throws IOException{
        if (string.length() == 0) {
            return null;
        }

        if(!isJSON(string)) {
            string = convertToMap(string);
        }
        System.out.print( string );
        return  mapper.readValue(string,tClass);
    }

    private static  boolean isJSON(String json){

        try{
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(json);
            return  true;
        }catch (IOException e){
            return false;
        }

    }

}

