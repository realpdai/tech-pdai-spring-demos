package tech.pdai.junit4;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Ignore Test.
 */
public class IgnoreTest {

    /**
     * ignore.
     */
    @Ignore
    @Test
    public void ignoreTest(){
        System.out.println("ignore test");
    }
}
