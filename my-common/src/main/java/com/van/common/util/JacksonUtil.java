package com.van.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public class JacksonUtil {

    /**
     * om
     */
    private static ObjectMapper om = new ObjectMapper();

    /**
     * Bean to json string.
     *
     * @param obj the obj
     * @return the string
     * @throws JsonProcessingException the json processing exception
     * @author : yangjunqing / 2018-05-18
     */
    public static String beanToJson(Object obj) throws JsonProcessingException {
        return om.writeValueAsString(obj);
    }

    /**
     * Json to bean t.
     *
     * @param <T>      the type parameter
     * @param json     the json
     * @param objClass the obj class
     * @return the t
     * @throws IOException the io exception
     * @author : yangjunqing / 2018-05-18
     */
    public static <T> T jsonToBean(String json, Class<T> objClass) throws IOException {
        return om.readValue(json, objClass);
    }


}
