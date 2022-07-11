package tech.pdai.springboot.smartdoc.entity.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * address.
 *
 * @author pdai
 */
@Data
@Builder
@AllArgsConstructor
public class AddressParam {

    /**
     * city.
     */
    private String city;

    /**
     * zip code.
     */
    private String zipcode;
}
