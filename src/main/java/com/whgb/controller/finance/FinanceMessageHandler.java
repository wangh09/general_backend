package com.whgb.controller.finance;

import com.whgb.utils.StateUtils;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wangh09 on 2017/6/23.
 */
@Service
public class FinanceMessageHandler {
    @KafkaListener(id = "finance", topics = "generalTopic", containerFactory = "financeKafkaListenerContainerFactory")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("finance consumer");
        Integer messageId = Integer.parseInt(cr.key().toString());
        switch (messageId){
            case StateUtils.MESSAGE_ACCOUNT_REGISTERED:
                break;
        }
        System.out.println(cr.toString());
    }
}
