package tech.pdai.springboot.smartdoc.entity.param;

import lombok.Builder;
import lombok.Data;

/**
 * user.
 *
 * @author pdai
 */
@Data
@Builder
public class UserParam {

    /**
     * username.
     */
    private String name;

    /**
     * user age.
     */
    private int age;

    /**
     * user address.
     */
    private AddressParam address;
}
