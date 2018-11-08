package com.bloglaptrinh.app.common.utils;

import com.bloglaptrinh.app.domain.PaggingResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.List;

public class JsonConverter<T> {

    public List toListObject(String json){

        Gson gson = new Gson();
        TypeToken<List<T>> token = new TypeToken<List<T>>(){};
        List list = gson.fromJson(json, token.getType());
        return list;
    }

    public Object toObject(String json){
        Gson gson = new Gson();
        TypeToken<PaggingResult> token = new TypeToken<PaggingResult>(){};
        Object obj = gson.fromJson(json, token.getType());
        return obj;
    }

    /*public List toListObject(String json){
        Gson gson = new Gson();
        TypeToken<PaggingResult> token = new TypeToken<PaggingResult>(){};
        List obj = gson.fromJson(json, token.getType());
        return obj;
    }*/

    public static String generateJsonObject(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public static List toJson(Object obj){
        Gson gson = new Gson();
        TypeToken<List<User>> token = new TypeToken<List<User>>(){};
        List list = gson.fromJson(json, token.getType());
        return list;
    }*/
}
