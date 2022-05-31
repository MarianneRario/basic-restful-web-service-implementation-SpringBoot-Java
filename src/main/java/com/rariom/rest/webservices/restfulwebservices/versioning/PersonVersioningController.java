package com.rariom.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
public class PersonVersioningController {


    @GetMapping(path = "/v1")
    public PersonV1 personV1(){
        return new PersonV1("Marianne V1");
    }

    @GetMapping(path = "/v2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Paulo", "V2"));
    }
}
