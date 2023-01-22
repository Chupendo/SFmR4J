package com.example.springsecurity.servicies.lisener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaLiseners {
    private static final String TAG = "KafkaLiseners";
    Logger log = LoggerFactory.getLogger(TAG);
    @KafkaListener(topics = {"devs4j-topic"}, groupId = "group")
    public void listen(String message){
       log.info("Received Message in group foo: "+message);
    }
}
