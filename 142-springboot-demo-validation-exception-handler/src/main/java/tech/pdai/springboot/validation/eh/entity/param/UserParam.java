package tech.pdai.springboot.validation.eh.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * user.
 *
 * @author pdai
 */
@Data
@Builder
@ApiModel(value = "User", subTypes = {AddressParam.class})
public class UserParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "could not be empty")
    private String userId;

    @NotEmpty(message = "could not be empty")
    @Email(message = "invalid email")
    private String email;

    @NotEmpty(message = "could not be empty")
    @Pattern(regexp = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$", message = "invalid ID")
    private String cardNo;

    @NotEmpty(message = "could not be empty")
    @Length(min = 1, max = 10, message = "nick name should be 1-10")
    private String nickName;

    @Range(min = 0, max = 1, message = "sex should be 0-1")
    private int sex;

    @Max(value = 100, message = "Please input valid age")
    private int age;

    private AddressParam address;

}
