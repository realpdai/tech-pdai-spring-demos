package tech.pdai.springboot.swagger.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    private String name;

    private int age;

    private AddressVo address;
}
