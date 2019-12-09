package com.service.feign.interfaces;

import com.service.feign.fallback.FeignServiceHellowImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = FeignServiceHellowImpl.class)
public interface FeignServiceHellow {
    @RequestMapping(value = "/hellow",method = RequestMethod.GET)
    String SayHellowFromFeign(@RequestParam(value = "name")String name);
}
