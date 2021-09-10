package tech.pdai.springboot.sms.ali.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pdai
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "sms")
public class SmsConfig {
    private String product;

    private String domain;

    private String region;

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

}
