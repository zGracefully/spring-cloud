//package com.example.laster.listener;
//
////import com.ctc.wstx.util.StringUtil;
////import org.apache.commons.lang.StringUtils;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
//import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
//import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
//import org.apache.rocketmq.spring.support.RocketMQUtil;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.converter.StringMessageConverter;
//
//@RocketMQTransactionListener(rocketMQTemplateBeanName = "rocketMQTemplate")
//public class TranscationListener implements RocketMQLocalTransactionListener {
//    @Override
//    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
//        String des = (String) o;
//        org.apache.rocketmq.common.message.Message msg = RocketMQUtil.convertToRocketMessage(
//                new StringMessageConverter(),
//                "UTF-8",
//                des,
//                message
//        );
//        String tags = msg.getTags();
////        if (StringUtils.contains(tags,"TagA")){
////            return RocketMQLocalTransactionState.COMMIT;
////        }else if (StringUtils.contains(tags,"TagB")){
////            return RocketMQLocalTransactionState.ROLLBACK;
////        }else {
////            return RocketMQLocalTransactionState.UNKNOWN;
////        }
//        return null;
//    }
//
//    @Override
//    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
//        return null;
//    }
//}
