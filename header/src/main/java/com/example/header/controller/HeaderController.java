package com.example.header.controller;

import com.example.common.config.LogAnnotation;
import com.example.header.service.HeaderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/header")
public class HeaderController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HeaderService headerService;

    @GetMapping("/post")
    @LogAnnotation(value = "pos")
    @HystrixCommand(fallbackMethod = "error")
    public String post(){
        System.out.println("这里是header，来干嘛");
        String object = restTemplate.getForObject("http://service-laster/laster/post", String.class);
//        User user = new User();
//        user.setName("浪里飘");
//        String object = headerService.post(user);
//        String object = token;
        return object;
    }


    public String error(){
        return "good";
    }
}
