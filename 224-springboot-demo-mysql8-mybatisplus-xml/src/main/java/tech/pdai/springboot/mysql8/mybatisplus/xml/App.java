package tech.pdai.springboot.mysql8.mybatisplus.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pdai
 */
@SpringBootApplication
@MapperScan("tech.pdai.springboot.mysql8.mybatisplus.xml.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}