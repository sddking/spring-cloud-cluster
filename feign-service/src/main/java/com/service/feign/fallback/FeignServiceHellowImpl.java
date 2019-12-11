package com.service.feign.fallback;
import  com.service.feign.interfaces.FeignServiceHellow;
public class FeignServiceHellowImpl implements  FeignServiceHellow{
    @Override
    public String SayHellowFromFeign(String name) {
        return "sorry "+name;
    }
}