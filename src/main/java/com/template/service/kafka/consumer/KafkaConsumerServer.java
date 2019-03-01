package com.template.service.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Project Name:springmc-kafka
 * File Name:KafkaConsumerServer
 * Package Name:com.template.service.kafka.consumer
 * Date:2019/3/1
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("kafkaConsumerServer")
public class KafkaConsumerServer implements MessageListener<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerServer.class);


    @Override
    public void onMessage(ConsumerRecord<String, String> consumerRecord) {
        String msg = consumerRecord.value();
        String topic = consumerRecord.topic();
        String key = consumerRecord.key();
        logger.info("topic:" + topic + " msg:" + msg + " key:" + key);
    }
}
