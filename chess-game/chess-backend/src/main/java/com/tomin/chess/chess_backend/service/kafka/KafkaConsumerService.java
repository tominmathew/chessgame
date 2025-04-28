package com.tomin.chess.chess_backend.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "chess-moves", groupId = "chessGroup")
    public void listen(String message){
        System.out.println("Received Message: " + message );
    }
}
