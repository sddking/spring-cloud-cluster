package com.springcloud.hystrix.web;

import com.springcloud.hystrix.service.HellowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowController {
    @Autowired
    HellowService hellowService;

    @GetMapping("/hellow")
    public String hellow(String name){
        return  hellowService.hiService(name);
    }
}
