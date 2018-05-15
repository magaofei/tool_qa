package com.magaofei.qa.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET)
    public String hello () {
        return "Hello, World";
    }


}
