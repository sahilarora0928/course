package com.idemia.core.dobcore.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TransformJsonUtil {

    private static final Logger LOGGER = Logger.getLogger(TransformJsonUtil.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TransformJsonUtil() {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public static String toJsonString(Object o) {
        String jsonString = null;
        try {
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            jsonString = objectMapper.writer().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return jsonString;
    }

    public static <T> T jsonStringToObject(Class<T> theClass, String s) {
        T data = null;
        try {
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            data = objectMapper.readValue(s, theClass);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return data;
    }

}
