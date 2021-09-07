package tech.pdai.springboot2unit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tech.pdai.springboot2unit5.service.IUserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * A way to test from H2.
 * <p>
 * Just a demo, and change profile to 'test' for H2, and 'product' for MySQL.
 */
@Profile("default")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class JavaSpringbootUnit5ApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    @DisplayName("Integration test")
    void contextLoads() {
        assertFalse(userService.findAll().isEmpty());
        assertEquals("pdai", userService.findAll().get(0).getName());
    }

}
