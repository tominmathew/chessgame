package com.tomin.chess.chess_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "moves")
public class ChessMove {

    @Id
    private String id;

    private String gameId;
    private String player;
    private String move;
    private LocalDateTime timestamp;
}
