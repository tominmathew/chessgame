package com.tomin.chess.chess_backend.repository;

import com.tomin.chess.chess_backend.model.ChessMove;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ChessMoveRepository extends ReactiveMongoRepository<ChessMove, String> {
    Flux<ChessMove> findByGameId(String gameId);
}
