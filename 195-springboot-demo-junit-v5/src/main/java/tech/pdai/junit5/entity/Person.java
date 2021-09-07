package tech.pdai.junit5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person
 *
 * @author pdai
 */
@Data
@AllArgsConstructor
public class Person {

    private String firstName;

    private String lastName;
}
