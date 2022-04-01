package pdai.springboot.mysql8.mybatisplus.anno.gencode.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author pdai
 * @since 2022-03-29
 */
@TableName("tb_user_role")
@ApiModel(value = "TbUserRole对象", description = "")
public class TbUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TbUserRole{" +
        "userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
