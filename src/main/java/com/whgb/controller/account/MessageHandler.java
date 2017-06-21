package com.whgb.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-06-21.
 */
@Service
public class MessageHandler {
    @Autowired
    private KafkaTemplate<String, String> template;

}
