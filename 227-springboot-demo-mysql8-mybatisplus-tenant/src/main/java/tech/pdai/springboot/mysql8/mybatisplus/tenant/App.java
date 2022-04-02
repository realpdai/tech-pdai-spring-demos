package tech.pdai.springboot.mysql8.mybatisplus.tenant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pdai
 */
@SpringBootApplication
@MapperScan("tech.pdai.springboot.mysql8.mybatisplus.tenant.dao")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}