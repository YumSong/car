package com.zhbit.car.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/7/17.
 */
@RestController
@RequestMapping("/")
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/test")
    String test1(){
        return "hello,test1()";
    }
}
