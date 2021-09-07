package tech.pdai.junit4.module;

public class Calculator {

    public int result = 0;

    /**
     * add.
     *
     * @param operand1 first param
     * @param operand2 second param
     * @return sum
     */
    public int add(int operand1, int operand2) {
        result = operand1 + operand2;
        return result;
    }

    public int subtract(int operand1, int operand2) {
        result = operand1 - operand2;
        return result;
    }

    public int multiple(int operand1, int operand2) {
        result = operand1 * operand2;
        for (; ; ) {                    //死循环
        }
    }

    public int divide(int operand1, int operand2) {
        result = operand1 / 0;
        return result;
    }

    public int getResult() {
        return this.result;
    }

}
