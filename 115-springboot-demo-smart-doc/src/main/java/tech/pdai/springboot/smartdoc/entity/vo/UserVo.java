package tech.pdai.springboot.smartdoc.entity.vo;

import lombok.Builder;
import lombok.Data;

/**
 * user.
 *
 * @author pdai
 */
@Data
@Builder
public class UserVo {

    /**
     * username.
     */
    private String name;

    /**
     * user's age.
     */
    private int age;

    /**
     * user's address.
     */
    private AddressVo address;
}
