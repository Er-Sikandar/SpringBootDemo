package com.example.springdemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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

    // http://localhost:9090/getPath/Sikandar/28
    @GetMapping("getPath/{name}/{age}")
    public String getPath(@PathVariable String name, @PathVariable Integer age){
        return "Hello " + name + ", Age: " + age;
    }

    /*curl --location 'http://localhost:9090/postDataForm' \
            --form 'name="Sikandar"' \
            --form 'age="28"'*/
    @PostMapping("postDataForm")
    public String postDataForm(@RequestParam String name, @RequestParam Integer age) {
        return "Hello " + name + ", Age: " + age;
    }


   /* curl --location 'http://localhost:9090/postDataFormPart' \
            --form 'name="Sikandar"' \
            --form 'age="28"' \
            --form 'file=@"/home/sikandar/Downloads/DroomScreen/care.jpg"'*/
    @PostMapping(value = "postDataFormPart",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String postDataFormPart(@RequestParam String name, @RequestParam Integer age,
                                   @RequestParam MultipartFile file) {
        return "Hello " + name + ", Age: " + age + ", File: " + file.getOriginalFilename();
    }


    /*curl --location 'http://localhost:9090/postDataRaw' \
            --header 'Content-Type: application/json' \
            --data '{"name":"Sikandar","age":28}'*/
    @PostMapping("postDataRaw")
    public String postDataRaw(@RequestBody Map<String, Object> data){
        if (!data.containsKey("name")) {
            return "name is missing";
        }
        if (!data.containsKey("age")) {
            return "age is missing";
        }
        String name = (String) data.get("name");
        Integer age = (Integer) data.get("age");
        return "Hello " + name + ", Age: " + age;
    }


}
