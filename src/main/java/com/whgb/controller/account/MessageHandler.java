package com.whgb.controller.account;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-06-21.
 */
@Service
public class MessageHandler {
    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendMessage(String s) {
        this.template.send("myTopic", "foo1");
    }

    @KafkaListener(id = "account", topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println(cr.toString());
        System.out.println("asdfasdfasfd");
    }
}
