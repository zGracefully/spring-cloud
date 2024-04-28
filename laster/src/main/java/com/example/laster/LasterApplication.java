package com.example.laster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.example.laster.mapper")
public class LasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LasterApplication.class, args);
    }

}
