package com.tomin.chess.chess_backend.servicetest;

import com.tomin.chess.chess_backend.service.kafka.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaProducerServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService kafkaProducerService;

    @Test
    public void testSendMessage(){
        String topic = "chess-moves";
        String message = "Move1: e2 to e4";

        kafkaProducerService.sendMessage(topic, message);

        verify(kafkaTemplate, times(1)).send(topic, message);
    }

}
