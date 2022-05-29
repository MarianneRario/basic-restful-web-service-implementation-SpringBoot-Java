package com.rariom.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello-world")
public class HelloWorldController {

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


}
