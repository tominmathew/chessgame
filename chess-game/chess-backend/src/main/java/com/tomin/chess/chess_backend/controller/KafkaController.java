package com.tomin.chess.chess_backend.controller;

import com.tomin.chess.chess_backend.service.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    KafkaController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/send-message")
    public void sendMessageToKafka(@RequestBody String message){
        String topic = "chess-moves";
        kafkaProducerService.sendMessage(topic, message);
    }
}
