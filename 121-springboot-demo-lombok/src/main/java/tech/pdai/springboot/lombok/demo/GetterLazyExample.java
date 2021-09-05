package tech.pdai.springboot.lombok.demo;

import lombok.Getter;

/**
 * @author pdai
 */
public class GetterLazyExample {
    @Getter(lazy = true)
    private final double[] cached = expensive();

    private double[] expensive() {
        double[] result = new double[1000000];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.asin(i);
        }
        return result;
    }
}
