package tech.pdai.springboot.file.excel.poi.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * @author pdai
 */
@Builder
@Data
public class User implements BaseEntity {

    /**
     * user id.
     */
    private Long id;

    /**
     * username.
     */
    private String userName;

    /**
     * email.
     */
    private String email;

    /**
     * phoneNumber.
     */
    private long phoneNumber;

    /**
     * description.
     */
    private String description;


}
