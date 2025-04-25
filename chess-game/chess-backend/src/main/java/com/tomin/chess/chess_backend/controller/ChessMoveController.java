package com.tomin.chess.chess_backend.controller;

import com.tomin.chess.chess_backend.model.ChessMove;
import com.tomin.chess.chess_backend.repository.ChessMoveRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/moves")
public class ChessMoveController {

    @Autowired
    private ChessMoveRepository repository;

    @PostMapping
    public ChessMove saveMove(@RequestBody ChessMove move){
        move.setTimestamp(LocalDateTime.now());
        return repository.save(move);
    }

    @GetMapping("/{gameId}")
    public List<ChessMove> getMoves(@PathVariable String gameId){
        return repository.findByGameId(gameId);
    }
}
