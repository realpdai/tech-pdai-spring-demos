package tech.pdai.springboot.lombok.demo;

import lombok.Builder;
import lombok.ToString;

import java.util.UUID;

/**
 * @author pdai
 */
@Builder
@ToString
public class BuilderDefaultExample {

    @Builder.Default
    private final String id = UUID.randomUUID().toString();

    private String username;

    @Builder.Default
    private long insertTime = System.currentTimeMillis();

}
