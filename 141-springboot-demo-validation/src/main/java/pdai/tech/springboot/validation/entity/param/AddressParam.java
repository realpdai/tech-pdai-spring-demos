package pdai.tech.springboot.validation.entity.param;

import io.swagger.annotations.ApiModel;
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
@ApiModel("Address")
public class AddressParam {
    
    private String city;

    private String zipcode;
}
