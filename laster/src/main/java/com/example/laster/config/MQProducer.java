//package com.example.laster.config;
//
//import org.apache.rocketmq.client.producer.TransactionSendResult;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//@Component
//public class MQProducer {
//    @Resource
//    private RocketMQTemplate rocketMQTemplate;
//    public void sendMessage(String topic,String message){
//        rocketMQTemplate.convertAndSend(topic,message);
//    }
//
//    public void sendMessageTranscaction(String topic,String msg) throws InterruptedException {
//        String[] tags=new String[]{"TagA","TagB","TagC","TagD","TagE"};
//        for (int i=0;i<10;i++){
//            Message<String> message = MessageBuilder.withPayload(msg).build();
//            String des = topic+":"+tags[i%tags.length];
//            TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction(des, message, des);
//            System.out.println(transactionSendResult);
//            Thread.sleep(10);
//        }
//    }
//}
