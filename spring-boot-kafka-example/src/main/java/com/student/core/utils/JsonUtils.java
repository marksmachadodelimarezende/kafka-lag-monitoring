package com.student.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {

    public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    public static String toJson(Object json)  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
