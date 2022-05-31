package com.rariom.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
public class PersonVersioningController {


    // path versioning
    @GetMapping(path = "/v1")
    public PersonV1 personV1(){
        return new PersonV1("Marianne V1");
    }

    // params versioning
    @GetMapping(value = "/param", params = "version=1")
    public PersonV1 paramPersonV1(){
        return new PersonV1("Marianne V1");
    }

    @GetMapping(value = "/param", params = "version=2")
    public PersonV2 paramPersonV2(){
        return new PersonV2(new Name("Paulo", "V2"));
    }

    // header versioning

    @GetMapping(value = "/header", headers = "X-API-VERSION=1")
    public PersonV1 headerPersonV1(){
        return new PersonV1("Marianne V1");
    }

    @GetMapping(value = "/header", headers = "X-API-VERSION=2")
    public PersonV2 headerPersonV2(){
        return new PersonV2(new Name("Paulo", "V2"));
    }
}
