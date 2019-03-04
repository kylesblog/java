package com.example.develop.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.protocol.Message;

public class MessageMap {
   static ObjectMapper objectMapper = new ObjectMapper();

    public static String objectTOJson(Object ob)throws Exception{
        try {
            return objectMapper.writeValueAsString(ob);
        } catch (Exception e) {
            throw e;
        }
    }

    public <T> T JsonTOObject(String json, Class<T> args)throws Exception{
        try {
            return objectMapper.readValue(json, args);
        } catch (Exception e) {
            throw e;
        }
    }

}
