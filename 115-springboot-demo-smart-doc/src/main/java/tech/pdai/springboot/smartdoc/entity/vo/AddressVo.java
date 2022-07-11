package tech.pdai.springboot.smartdoc.entity.vo;

import lombok.Builder;
import lombok.Data;

/**
 * address.
 *
 * @author pdai
 */
@Data
@Builder
public class AddressVo {
    /**
     * city.
     */
    private String city;

    /**
     * zip code.
     */
    private String zipcode;
}
