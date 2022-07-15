package tech.pdai.springboot.view.thymeleaf3.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test")
    public String hello(Model model) {
        model.addAttribute("user", "pdai");
        model.addAttribute("date", LocalDateTime.now());
        return "hello";
    }
}
