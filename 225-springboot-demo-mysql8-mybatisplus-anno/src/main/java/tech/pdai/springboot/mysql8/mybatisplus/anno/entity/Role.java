package tech.pdai.springboot.mysql8.mybatisplus.anno.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author pdai
 */
@Getter
@Setter
@TableName("tb_role")
public class Role implements BaseEntity {

    /**
     * role id.
     */
    @TableId
    private Long id;

    /**
     * role name.
     */
    @TableField("name")
    private String name;

    /**
     * role key.
     */
    @TableField("role_key")
    private String roleKey;

    /**
     * description.
     */
    @TableField("description")
    private String description;

    /**
     * create date time.
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * update date time.
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}
