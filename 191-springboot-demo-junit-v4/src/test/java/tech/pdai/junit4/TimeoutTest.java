package tech.pdai.junit4;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Timeout Test.
 */
public class TimeoutTest {

    @Test(timeout = 1000)
    public void testCase1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5000);
        System.out.println("in timeout exception");
    }
}

