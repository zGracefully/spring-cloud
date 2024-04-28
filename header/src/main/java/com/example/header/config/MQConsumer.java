//package com.example.header.config;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@RocketMQMessageListener(consumerGroup = "producer-laster",topic = "my-produce-topic")
//public class MQConsumer implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String s) {
//        System.out.println("consumer:"+s);
//    }
//}
