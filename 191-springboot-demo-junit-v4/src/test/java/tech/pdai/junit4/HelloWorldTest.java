package tech.pdai.junit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Hello world test.
 *
 * @author pdai
 */
public class HelloWorldTest {

    @Test
    public void firstTest() {
        assertEquals(2, 1 + 1);
    }
}
