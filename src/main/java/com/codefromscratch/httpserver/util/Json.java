package com.codefromscratch.httpserver.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import java.io.IOException;

public class Json {
    private static ObjectMapper myObjectMapper = new ObjectMapper();

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return om;
    }

    public static JsonNode parse(String jsonSrc) throws IOException {
        return myObjectMapper.readTree(jsonSrc);
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException {
        return myObjectMapper.treeToValue(node, clazz);
    }

    public static JsonNode toJson(Object obj){
        return myObjectMapper.valueToTree(obj);
    }

    public String stringify(JsonNode node) throws JsonProcessingException {
        return generateJson(node, false);
    }

    public String stringifyBool(JsonNode node) throws JsonProcessingException {
        return generateJson(node, true);
    }

    public String generateJson(Object o, boolean bool) throws JsonProcessingException {
        ObjectWriter objectWriter = myObjectMapper.writer();
        if(bool){
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(o);
    }
}
