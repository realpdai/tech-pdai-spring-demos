package tech.pdai.junit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameterized Test.
 *
 */
@RunWith(Parameterized.class) // 步骤一: 指定定参数运行器
public class PrimeNumberCheckerTest {

    /**
     * 步骤二：声明变量
     */
    private Integer inputNumber;
    private Boolean expectedResult;
    private PrimeNumberChecker primeNumberChecker;

    /**
     * 步骤三：为测试类声明一个带有参数的公共构造函数，为变量赋值
     */
    public PrimeNumberCheckerTest(Integer inputNumber,
                                  Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    /**
     * 步骤四：为测试类声明一个使用注解 org.junit.runners.Parameterized.Parameters 修饰的，返回值为
     * java.util.Collection 的公共静态方法，并在此方法中初始化所有需要测试的参数对
     *   1）该方法必须由Parameters注解修饰
     2）该方法必须为public static的
     3）该方法必须返回Collection类型
     4）该方法的名字不做要求
     5）该方法没有参数
     */
    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {6, false},
                {19, true},
                {22, false},
                {23, true}
        });
    }

    @Before
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    /**
     * 步骤五：编写测试方法，使用自定义变量进行测试
     */
    @Test
    public void testPrimeNumberChecker() {
        System.out.println("Parameterized Number is : " + inputNumber);
        Assert.assertEquals(expectedResult,
                primeNumberChecker.validate(inputNumber));
    }
}

