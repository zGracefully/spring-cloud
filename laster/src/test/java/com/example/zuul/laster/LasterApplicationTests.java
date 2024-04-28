package com.example.zuul.laster;

import com.example.laster.LasterApplication;
//import com.example.laster.config.MQProducer;
import com.example.laster.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = LasterApplication.class)
class LasterApplicationTests {

//    @Resource
//    private MQProducer mqProducer;
    @Test
    void contextLoads() {

    }

    @Test
    void send(){
        for (int i= 0 ;i< 5;i++){
            String topic = "my-produce-topic";
            String message = "hello rocketmq world!"+i;
//            mqProducer.sendMessage(topic,message);
            System.out.println("消息发送成功!");
        }

    }

    @Test
    void sendTran() throws InterruptedException {
        String topic = "my-produce-topic";
        String message = "hello rocketmq tran world!";
//        mqProducer.sendMessageTranscaction(topic,message);
        System.out.println("事物消息发送成功!");
    }
}
