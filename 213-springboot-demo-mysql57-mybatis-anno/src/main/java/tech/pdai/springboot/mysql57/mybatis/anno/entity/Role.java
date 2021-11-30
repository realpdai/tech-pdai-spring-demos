package tech.pdai.springboot.mysql57.mybatis.anno.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import tech.pdai.springboot.mysql57.mybatis.anno.entity.query.BaseEntity;

/**
 * @author pdai
 */
@Getter
@Setter
public class Role implements BaseEntity {

    /**
     * role id.
     */
    private Long id;

    /**
     * role name.
     */
    private String name;

    /**
     * role key.
     */
    private String roleKey;

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

}
