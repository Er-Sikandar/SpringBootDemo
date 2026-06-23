package com.example.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("helloHtml")
    public String helloHtml(){
        return "<h1>Hello World</h1>";
    }


}
