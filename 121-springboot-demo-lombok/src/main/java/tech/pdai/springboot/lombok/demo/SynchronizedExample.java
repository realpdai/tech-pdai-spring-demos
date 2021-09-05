package tech.pdai.springboot.lombok.demo;

import lombok.Synchronized;

/**
 * @author pdai
 */
public class SynchronizedExample {

    @Synchronized
    public static void hello() {
        System.out.println("world");
    }
}
