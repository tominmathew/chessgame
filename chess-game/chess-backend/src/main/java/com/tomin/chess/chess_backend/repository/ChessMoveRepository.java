package com.tomin.chess.chess_backend.repository;

import com.tomin.chess.chess_backend.model.ChessMove;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChessMoveRepository extends MongoRepository<ChessMove, String> {
    List<ChessMove> findByGameId(String gameId);
}
