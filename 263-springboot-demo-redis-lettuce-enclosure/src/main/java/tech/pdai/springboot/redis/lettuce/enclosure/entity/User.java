package tech.pdai.springboot.redis.lettuce.enclosure.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pdai
 */
@Getter
@Setter
public class User {

    /**
     * user id.
     */
    private Long id;

    /**
     * username.
     */
    private String userName;

}
