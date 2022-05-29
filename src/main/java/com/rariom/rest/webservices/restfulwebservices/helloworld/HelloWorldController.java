package com.rariom.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(path = "/hello-world")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Bean");
    }

    @GetMapping(path = "/path-variable/{name}")
    public HelloWorldBean helloWorldWithPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello, " + name);
    }

    // I18N
    @GetMapping(path = "/internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale ){
        return messageSource.getMessage("good.morning.message", null, locale);
    }

}
