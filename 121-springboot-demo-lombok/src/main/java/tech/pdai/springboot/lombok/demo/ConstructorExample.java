package tech.pdai.springboot.lombok.demo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author pdai
 */
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class ConstructorExample {
    @NonNull
    private int id;
    @NonNull
    private String shape;

    private int age;

    public static void main(String[] args) {
        new ConstructorExample(1, "circle");
        //使用静态工厂方法
        ConstructorExample.of(2, "circle");
        //无参构造
        new ConstructorExample();
        //包含所有参数
        new ConstructorExample(1, "circle", 2);
    }
}
