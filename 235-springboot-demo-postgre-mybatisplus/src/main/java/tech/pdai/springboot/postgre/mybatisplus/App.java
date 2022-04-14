package tech.pdai.springboot.postgre.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pdai
 */
@SpringBootApplication
@MapperScan("tech.pdai.springboot.postgre.mybatisplus.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}