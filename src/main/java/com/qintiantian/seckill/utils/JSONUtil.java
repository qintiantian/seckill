package com.qintiantian.seckill.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONUtil {

	private static final ObjectMapper mapper =  new ObjectMapper();
	
	static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        mapper.registerModule(hibernate4Module);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
    }
	
	public static ObjectMapper  getObjectMapper() {
        return mapper;
	}
	
	public static String mapToJsonString(Object contentsObj) {
        try {
            return mapper.writeValueAsString(contentsObj);
        } catch (JsonProcessingException e) {
            log.error("Failed to write {} to string", contentsObj, e);
        }
        return "";
    }
}
