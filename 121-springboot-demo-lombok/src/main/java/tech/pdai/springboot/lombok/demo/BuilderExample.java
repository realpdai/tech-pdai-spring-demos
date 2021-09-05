package tech.pdai.springboot.lombok.demo;

import lombok.Builder;
import lombok.Singular;

import java.util.Set;

/**
 * This class is for xxxx.
 *
 * @author pdai
 */
@Builder
public class BuilderExample {
    private String name;
    private int age;
    @Singular
    private Set<String> occupations;

    public static void main(String[] args) {
        BuilderExample test = BuilderExample.builder().age(11).name("test")
                .occupation("1")
                .occupation("2")
                .build();
    }
}
