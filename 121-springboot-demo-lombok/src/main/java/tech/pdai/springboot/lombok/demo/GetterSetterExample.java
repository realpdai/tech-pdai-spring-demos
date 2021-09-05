package tech.pdai.springboot.lombok.demo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pdai
 */
@EqualsAndHashCode(exclude = {"id", "shape"}, callSuper = false)
public class GetterSetterExample {

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PROTECTED)
    private int id;
    private String shape;
}
