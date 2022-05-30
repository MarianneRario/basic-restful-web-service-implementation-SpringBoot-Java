package com.rariom.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/filtering")
public class FilteringController {


    // simple method for dynamic filtering
    protected MappingJacksonValue filter(
            SomeBean someBean, SimpleBeanPropertyFilter simpleBeanPropertyFilter){

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        // dynamic filtering using MappingJacksonValue class
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;

    }


    /* DYNAMIC FILTERING */
    // only return f1 and f2
    @GetMapping
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("val1", "val2", "val3");
        // simpleBeanPropertyFilter
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("f1", "f2");

        MappingJacksonValue mjv =  filter(someBean, simpleBeanPropertyFilter);
        return mjv;
    }


    // return f3
    @GetMapping(path = "/list")
    public MappingJacksonValue retrieveSomeBean2(){
        SomeBean someBean = new SomeBean("val1", "val2", "val3");

        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("f3");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", simpleBeanPropertyFilter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filterProvider);


        return mappingJacksonValue;
    }
}
