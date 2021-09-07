package tech.pdai.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Hello world test.
 *
 * @author pdai
 */
public class HelloWorldTest {

    @Test
    void firstTest() {
        assertEquals(2, 1 + 1);
    }
}
