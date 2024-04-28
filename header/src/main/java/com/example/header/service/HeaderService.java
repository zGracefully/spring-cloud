package com.example.header.service;

import com.example.header.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-laster")
public interface HeaderService {
    @GetMapping("/laster/post")
    String post();
    @PostMapping("/laster/post")
    String post(@RequestBody User user);
}
