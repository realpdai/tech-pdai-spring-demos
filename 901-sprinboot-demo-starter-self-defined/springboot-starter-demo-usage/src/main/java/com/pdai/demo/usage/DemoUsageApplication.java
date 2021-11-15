package com.pdai.demo.usage;

import com.pdai.demo.module.DemoModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoUsageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUsageApplication.class, args);
    }

    @Autowired
    private DemoModule demoModule;


    @GetMapping("demo")
    public String demo(){
        return demoModule.exeModuleMethod();
    }
}
