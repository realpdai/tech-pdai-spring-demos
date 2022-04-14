package tech.pdai.springboot.postgre.mybatisplus.entity.query;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserQueryBean {

    /**
     * contains name pattern.
     */
    private String userName;

    /**
     * contains desc pattern.
     */
    private String description;

    private String phoneNumber;

    private String email;

}
