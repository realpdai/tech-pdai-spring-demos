package tech.pdai.springboot.postgre.jpa.entity.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleQueryBean {

    /**
     * contains name pattern.
     */
    private String name;

    /**
     * contains desc pattern.
     */
    private String description;

}
