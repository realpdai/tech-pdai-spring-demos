package tech.pdai.springboot.lombok.demo;

import lombok.NonNull;
import lombok.Value;

/**
 * @author pdai
 */
@Value
public class ValueExample {
    @NonNull
    private int id;
    @NonNull
    private String shape;
    private int age;
}