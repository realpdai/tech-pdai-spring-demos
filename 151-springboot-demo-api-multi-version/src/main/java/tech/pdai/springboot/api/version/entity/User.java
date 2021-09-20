package tech.pdai.springboot.api.version.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author pdai
 */
@Data
@Builder
public class User {
    /**
     * user's name.
     */
    private String name;

    /**
     * user's age.
     */
    private int age;
}
