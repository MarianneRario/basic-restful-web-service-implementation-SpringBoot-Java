package com.rariom.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filtering")
public class FilteringController {

    @GetMapping
    public SomeBean retrieveSomeBean(){
        return new SomeBean("val1", "val2", "val3");
    }
}
