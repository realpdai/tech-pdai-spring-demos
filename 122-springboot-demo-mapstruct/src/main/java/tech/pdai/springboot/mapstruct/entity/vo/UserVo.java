package tech.pdai.springboot.mapstruct.entity.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * @author pdai
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Long id;
    private String username;
    private Integer gender;
    private LocalDate birthday;
    private String createTime;
    private List<UserConfig> configs;

    @Data
    public static class UserConfig {
        private String field1;
        private Integer field2;
    }
}
