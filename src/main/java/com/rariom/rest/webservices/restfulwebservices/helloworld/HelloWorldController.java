package com.rariom.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
