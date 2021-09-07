package tech.pdai.springboot.mapstruct.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import tech.pdai.springboot.mapstruct.entity.User;
import tech.pdai.springboot.mapstruct.entity.param.UserQueryParam;

/**
 * @author pdai
 */
@Component
public class IUserDao {

    public List<User> list(UserQueryParam userParam) {
        return Collections.singletonList(findOne());
    }

    public User findOne() {
        return User.builder()
                .id(1L).username("pdai")
                .birthday(LocalDate.now())
                .createTime(LocalDateTime.now())
                .sex(1)
                .config("[{\"field1\":\"xxx\", \"field2\": 22}]")
                .description("hello mapstruct")
                .password("xdafsfasdfasdf")
                .build();
    }
}
