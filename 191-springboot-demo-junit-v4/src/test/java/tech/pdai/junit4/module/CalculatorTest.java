package tech.pdai.junit4.module;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private static Calculator cal=new Calculator();

    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void add() {
        cal.add(2,2);
        assertEquals(4,cal.getResult());
    }

    @Test
    public void subtract() {
        cal.subtract(4,2);
        assertEquals(2,cal.getResult());
    }

    @Ignore
    public void multiply() {
        fail("Not yet implemented");
    }

    @Test(timeout = 2000)
    public void divide() {
        for(;;);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        cal.divide(4,0);
    }

}