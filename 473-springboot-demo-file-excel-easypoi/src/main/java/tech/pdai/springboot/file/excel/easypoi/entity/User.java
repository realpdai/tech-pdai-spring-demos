package tech.pdai.springboot.file.excel.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pdai
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements BaseEntity {

    /**
     * user id.
     */
    @Excel(name = "ID")
    private Long id;

    /**
     * username.
     */
    @Excel(name = "Name")
    private String userName;

    /**
     * email.
     */
    @Excel(name = "Email")
    private String email;

    /**
     * phoneNumber.
     */
    @Excel(name = "Phone")
    private long phoneNumber;

    /**
     * description.
     */
    @Excel(name = "Description")
    private String description;


}
