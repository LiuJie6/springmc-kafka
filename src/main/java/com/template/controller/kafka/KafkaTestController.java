package com.template.controller.kafka;

import com.template.model.response.ResponseResult;
import com.template.model.state.State;
import com.template.service.kafka.producer.KafkaProducerServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Project Name:springmc-kafka
 * File Name:KafkaTestController
 * Package Name:com.template.controller.kafka
 * Date:2019/3/1
 * Author:liujie
 * Description:
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


@RestController
@RequestMapping("api/kafka")
public class KafkaTestController {

    @Resource(name = "kafkaProducerServer")
    private KafkaProducerServer kafkaProducerServer;

    @PostMapping("test")
    public Object kafkaTest(@RequestParam(value = "msg", defaultValue = "null") String msg) throws Exception {
        Map<String, Object> map = this.kafkaProducerServer.sendMsgForTemplate(msg, false, 0);
        return new ResponseResult(true, State.SUCCESS.getCode(), "", map);
    }
}
