package com.example.laster.controller;

import com.example.laster.dao.UserDao;
import com.example.laster.model.User;
import com.example.laster.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laster")
public class LasterController {
    private UserService userService;
    public LasterController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/post")
    public String post(){
        System.out.println("laster是这里，有啥事");
        return "武功秘籍：九阴白骨爪";
    }
    @PostMapping("/post")
    public String post(@RequestBody User user){
        System.out.println("laster系几，仲麻野");
        return "少林绝技：葵花宝典";
    }
    @PostMapping("/user")
    public String user(@RequestBody UserDao user){
        return userService.user(user);
    }
}
