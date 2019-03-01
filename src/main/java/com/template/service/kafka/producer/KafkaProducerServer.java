package com.template.service.kafka.producer;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Project Name:springmc-kafka
 * File Name:KafkaProducerServer
 * Package Name:com.template.service.kafka.producer
 * Date:2019/3/1
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@Service("kafkaProducerServer")
public class KafkaProducerServer {

    @Resource(name = "kafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${consumer.topic}")
    private String topic;

    /**
     * @param msg          消息
     * @param partition    是否适用分区
     * @param partitionNum 分区数，若使用分区，该值必大于0
     * @return 发送消息结果
     * @throws Exception 异常
     */
    public Map<String, Object> sendMsgForTemplate(Object msg
            , boolean partition
            , int partitionNum) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String msgString = mapper.writeValueAsString(msg);
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, msgString);
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        return map;
    }


}
