package com.whgb.controller.account;

import com.whgb.utils.StateUtils;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-21.
 */
@Service
public class AccountMessageHandler {
    @Autowired
    private KafkaTemplate<String, String> template;
    public void sendMessage(int messageId,Map<String,String> payload) {
        JSONObject jsonString = JSONObject.fromObject(payload);
        this.template.send("generalTopic",String.valueOf(messageId),jsonString.toString());
    }


    //*************************************************************************

    @KafkaListener(id = "account", topics = "generalTopic", containerFactory = "accountKafkaListenerContainerFactory")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("account consumer");
        Integer messageId = Integer.parseInt(cr.key().toString());
        switch (messageId){
            case StateUtils.MESSAGE_ACCOUNT_REGISTERED:
                break;
        }
        System.out.println(cr.toString());
    }


}
