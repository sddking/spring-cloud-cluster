package com.service.feign.web;

import com.service.feign.interfaces.FeignServiceHellow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {
    @Autowired
    FeignServiceHellow feignServiceHellow;

    @RequestMapping(value = "/hellow")
    public String SayHellow(@RequestParam String name){
        return  feignServiceHellow.SayHellowFromFeign(name);
    }
}
