package tech.pdai.junit4.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        /**
         * 此处类的配置顺序会影响执行顺序
         */
        JunitTest1.class,
        JunitTest2.class
})
public class JunitSuiteTest {
}
