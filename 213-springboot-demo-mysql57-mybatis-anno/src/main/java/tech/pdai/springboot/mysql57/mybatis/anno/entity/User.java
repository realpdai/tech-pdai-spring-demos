package tech.pdai.springboot.mysql57.mybatis.anno.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.Role;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.query.BaseEntity;

/**
 * @author pdai
 */
@Getter
@Setter
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
     * user pwd.
     */
    @JsonIgnore
    private String password;

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

    /**
     * create date time.
     */
    private LocalDateTime createTime;

    /**
     * update date time.
     */
    private LocalDateTime updateTime;

    /**
     * join to role table.
     */
    private List<Role> roles;

}
