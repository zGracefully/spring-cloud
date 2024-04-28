package com.example.laster.service;

import com.example.laster.dao.UserDao;
import com.example.laster.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
@Component("userService")
public class UserService {
    @Autowired
    private ExecutorService executorService;
    private UserMapper userMapper;
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    public String user(UserDao userDao){
        System.out.println("进入.......");
        userMapper.insert(userDao);
        executorService.submit(()->{
           userDao.setName("异步线程");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            userMapper.insert(userDao);
        });
        return "success";
    }
}
