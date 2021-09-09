package tech.pdai.springboot.postgre.jpa.druid.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import tech.pdai.springboot.postgre.jpa.druid.constants.PGConstants;

/**
 * @author pdai
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_role")
public class Role implements BaseEntity {

    /**
     * role id.
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = PGConstants.ID_GENERATOR)
    @GenericGenerator(name = PGConstants.ID_GENERATOR, strategy = PGConstants.ID_GENERATOR_CONFIG)
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
