package tech.pdai.springboot.mapstruct.entity.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pdai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryParam {
    private Long id;
    private String username;
}
