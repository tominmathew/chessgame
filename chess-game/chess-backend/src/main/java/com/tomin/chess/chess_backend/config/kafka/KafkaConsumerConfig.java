package com.tomin.chess.chess_backend.config.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

import java.sql.SQLOutput;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @KafkaListener(topics = "chess-moves", groupId = "chessGroup")
    public void listen(String message){
        System.out.println("Received Message: " + message);
    }
}
