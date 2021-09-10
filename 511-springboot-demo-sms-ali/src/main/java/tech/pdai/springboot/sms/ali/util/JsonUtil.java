package tech.pdai.springboot.sms.ali.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * @author pdai
 */
public class JsonUtil {

    /**
     * @param object object
     * @return str
     */
    @SneakyThrows
    public static String toJson(Object object) {
        return new ObjectMapper().writeValueAsString(object);
    }
}
